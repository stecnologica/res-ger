package com.app.gestor.restaurante.servicesimpl;


import com.app.gestor.restaurante.entity.UserApiEntity;
import com.app.gestor.restaurante.repository.UserApiRepository;
import com.app.gestor.restaurante.utils.JwtUtil;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AuthService {

    private final UserApiRepository userRepository;
    private final BCryptPasswordEncoder passwordEncoder;
    private final JwtUtil jwtUtil;



    public AuthService(UserApiRepository userRepository, JwtUtil jwtUtil) {
        this.userRepository = userRepository;
        this.passwordEncoder = new BCryptPasswordEncoder();
        this.jwtUtil = jwtUtil;
    }

   /* public UserApiEntity register(UserApiEntity user) {
        System.out.println(user.toString());
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return userRepository.save(user);
    }*/

    // Login y Validación de Contraseña
    public String login(String userName, String password) throws Exception {

        System.out.println("userName "+ userName + " contraseña " + password );

        Optional<UserApiEntity> userOpt = userRepository.findByUserName(userName);

        System.out.println("userOpt "+ userOpt);

        if (userOpt.isEmpty()) {
            throw new Exception("Usuario no encontrado");
        }
        UserApiEntity user = userOpt.get();

        if (!passwordEncoder.matches(password, user.getPassword())) {
            throw new Exception("Contraseña incorrecta");
        }
        // Generar JWT
        return jwtUtil.generateToken(user.getUserName());
    }



}

