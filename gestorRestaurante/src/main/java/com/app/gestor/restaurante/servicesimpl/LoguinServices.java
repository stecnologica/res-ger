package com.app.gestor.restaurante.servicesimpl;


import com.app.gestor.restaurante.dto.res.DtoResponseApi;
import com.app.gestor.restaurante.dto.res.DtoResponseLoguin;
import com.app.gestor.restaurante.entity.UserAppEntity;
import com.app.gestor.restaurante.repository.UserAppRepository;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class LoguinServices {

    private final UserAppRepository userRepository;
    private final BCryptPasswordEncoder passwordEncoder;



    public LoguinServices(UserAppRepository userRepository, BCryptPasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public DtoResponseLoguin register(UserAppEntity user) {
        DtoResponseLoguin response = new DtoResponseLoguin();
        System.out.println(user.toString());

        try {
            String cifrado = passwordEncoder.encode(user.getContrasena());
            System.out.println("Cifrado Contraseña: ******" + cifrado);

            user.setContrasena(passwordEncoder.encode(user.getContrasena()));
            UserAppEntity responseEntityApp = userRepository.save(user);
            if (responseEntityApp != null) {
                response.setCodigo("200");
                response.setSuccess(true);
                response.setMessage("Registro Creado Exitosamente");
                response.setData(responseEntityApp);
            }
            //Else de error en la creacion del evento masivo
            else {
                response.setCodigo("401");
                response.setSuccess(false);
                response.setMessage("Error insertando en la BD");
                response.setData("Error Realizando el insert a la BD");
            }
        } catch (Exception e) {
            response.setCodigo("400");
            response.setSuccess(false);
            response.setMessage("Error insertando en la BD Exeption" + e);
            response.setData("Error Realizando el insert a la BD");
        }
        return response;
    }


    // Login y Validación de Contraseña
    public DtoResponseApi login(String nombreusuario, String contrasena) throws Exception {

        String mensaje;
        DtoResponseApi response = new DtoResponseApi();
        System.out.println("nombre_usuario " + nombreusuario + " contraseña " + contrasena);
        try {
            Optional<UserAppEntity> userOpt = userRepository.findByNombreusuario(nombreusuario);
            System.out.println("userOpt " + userOpt);
            if (userOpt.isEmpty()) {
                response.setCodigo("400");
                response.setSuccess(false);
                response.setMessage("Usuario no encontrado" );
                response.setData("Usuario no encontrado");
            }
            UserAppEntity user = userOpt.get();
            try {
                if (!passwordEncoder.matches(contrasena, user.getContrasena())) {
                    response.setCodigo("401");
                    response.setSuccess(false);
                    response.setMessage("Contraseña incorrecta");
                    response.setData("Contraseña incorrecta");

                } else {
                    mensaje = "Autenticacion Exitosa";
                    response.setCodigo("200");
                    response.setSuccess(true);
                    response.setMessage(mensaje);
                    System.out.println(mensaje);
                }
            } catch (Exception e) {
                response.setCodigo("400");
                response.setSuccess(false);
                response.setMessage("Error en Autenticacion Contraseña Exeption" + e);
                response.setData("Error en Autenticacion Exeption");
            }

        } catch (Exception e) {
            response.setCodigo("400");
            response.setSuccess(false);
            response.setMessage("Error en Autenticacion Usuario Exeption" + e);
            response.setData("Error en Autenticacion Exeption");
        }

        return response;
    }
}

