package com.app.gestor.restaurante.controller.loguin;

import com.app.gestor.restaurante.dto.res.DtoResponseApi;
import com.app.gestor.restaurante.dto.res.DtoResponseLoguin;
import com.app.gestor.restaurante.entity.UserAppEntity;
import com.app.gestor.restaurante.servicesimpl.LoguinServices;
import org.springframework.web.bind.annotation.*;

import java.util.Map;
import java.util.Objects;

@RestController
@CrossOrigin(origins = "http://localhost:5173/")
@RequestMapping("/webapp")
public class LoguinController {

    private final LoguinServices loguinServices;


    public LoguinController(LoguinServices loguinServices) {
        this.loguinServices = loguinServices;
    }



    @PostMapping("/login")
    public DtoResponseApi login(@RequestBody Map<String, String> credentials) {
        DtoResponseApi respuesta = new DtoResponseApi();
        try {
            DtoResponseApi token = loguinServices.login(credentials.get("nombreusuario"), credentials.get("contrasena"));
            if (token.isSuccess() == false) {
                respuesta.setSuccess(token.isSuccess());
                respuesta.setCodigo(token.getCodigo());
                respuesta.setMessage(token.getMessage());
            } else{
                respuesta.setSuccess(token.isSuccess());
                respuesta.setCodigo(token.getCodigo());
                respuesta.setMessage(token.getMessage());
            }
        } catch (Exception e) {
            respuesta.setCodigo("400");
            respuesta.setSuccess(false);
            respuesta.setMessage("Error en Autenticacion Contraseña Exeption" + e);
            respuesta.setData("Error en Autenticacion Exeption");
        }
        return respuesta;
    }

    @PostMapping("/registro")
    public DtoResponseApi register(@RequestBody UserAppEntity user) {
        DtoResponseApi response = new DtoResponseApi(false,null, null);
        try {
            DtoResponseLoguin entidadResponse = loguinServices.register(user);
            if (Objects.equals(entidadResponse.getCodigo(), "200")) {
                response.setSuccess(entidadResponse.isSuccess());
                response.setCodigo(entidadResponse.getCodigo());
                response.setMessage(entidadResponse.getMessage());
                response.setData(entidadResponse.getData());
            } else {
                response.setSuccess(entidadResponse.isSuccess());
                response.setCodigo("401");
                response.setMessage(entidadResponse.getMessage());
                response.setData(entidadResponse.getData());
            }
        }catch (Exception e){
            response.setSuccess(false);
            response.setCodigo("400");
            response.setMessage("Error Exeption: " + e);
        }
        return response;
    }

}
