package com.app.gestor.restaurante.controller.auth;

import com.app.gestor.restaurante.dto.res.DtoResponseApi;
import com.app.gestor.restaurante.dto.res.DtoResposeJwt;
import com.app.gestor.restaurante.servicesimpl.AuthService;
import org.springframework.web.bind.annotation.*;

import java.util.Map;


@RestController
@CrossOrigin(origins = "http://localhost:5173")
@RequestMapping("/auth")
public class AuthController {

    private final AuthService authService;

    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    /*
    @PostMapping("/registro")
    public ResponseEntity<UserApiEntity> register(@RequestBody UserApiEntity user) {
        return ResponseEntity.ok(authService.register(user));
    }
    */

    @PostMapping("/authenticate")
    public DtoResponseApi login(@RequestBody Map<String, String> credentials) {

        DtoResponseApi respose = new DtoResponseApi(false,null, null);
        try {
            final String token = authService.login(credentials.get("userName"), credentials.get("password"));
            if (token == null) {
                DtoResposeJwt responsejwt = new DtoResposeJwt();
                responsejwt.setJwtToken(token);
                respose.setSuccess(false);
                respose.setCodigo("401");
                respose.setMessage("error Credenciales inválidas");
                respose.setData(responsejwt);
                return respose;
            } else{
                DtoResposeJwt responsejwt = new DtoResposeJwt();
                responsejwt.setJwtToken(token);
                respose.setSuccess(true);
                respose.setCodigo("200");
                respose.setMessage("Token Creado");
                respose.setData(responsejwt);
                return respose;
            }
        } catch (Exception e) {
            DtoResposeJwt responsejwt = new DtoResposeJwt();
            respose.setSuccess(false);
            respose.setCodigo("400");
            respose.setMessage("error Credenciales inválidas" + e.getMessage());
            respose.setData(responsejwt);
            return respose;
        }
    }

}
