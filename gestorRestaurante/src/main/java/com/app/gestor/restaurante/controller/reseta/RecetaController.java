package com.app.gestor.restaurante.controller.reseta;

import com.app.gestor.restaurante.dto.req.DtoRequestReceta;
import com.app.gestor.restaurante.dto.res.DtoResponseApi;
import com.app.gestor.restaurante.servicesimpl.RecetaServices;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "http://localhost:5173/")
@RequestMapping("/webapp")
public class RecetaController {


    private final RecetaServices recetaServices;

    public RecetaController(RecetaServices recetaServices) {
        this.recetaServices = recetaServices;
    }


    @PostMapping("/crearreceta")
    public DtoResponseApi crearreceta(@RequestBody DtoRequestReceta dtoRequestReceta ) {
            DtoResponseApi respuesta = new DtoResponseApi();

            try {
                respuesta = recetaServices.crearreceta(dtoRequestReceta);
                System.out.println("respuesta de crearreceta "+ respuesta);



            } catch (Exception e) {
                respuesta.setCodigo("400");
                respuesta.setSuccess(false);
                respuesta.setMessage("Error en Autenticacion Contraseña Exeption" + e);
                respuesta.setData("Error en Autenticacion Exeption");
            }

            return respuesta;
    }

    @PutMapping("/actualizarreceta/{id}")
    public DtoResponseApi actualizarreceta( @PathVariable Long id,
                                                   @RequestBody DtoRequestReceta dtoRequestReceta) {
            DtoResponseApi respuesta = new DtoResponseApi();

            try {
                respuesta = recetaServices.updatereceta(dtoRequestReceta, id);
                System.out.println("respuesta de crear proveedor "+ respuesta);

            } catch (Exception e) {
                respuesta.setCodigo("400");
                respuesta.setSuccess(false);
                respuesta.setMessage("Error en Autenticacion Contraseña Exeption" + e);
                respuesta.setData("Error en Autenticacion Exeption");
            }

            return respuesta;
    }


    @GetMapping("/listarreceta")
    public DtoResponseApi listarreceta() {
            DtoResponseApi respuesta = new DtoResponseApi();

            try {
                respuesta = recetaServices.listarreceta();
                System.out.println("respuesta de crear proveedor "+ respuesta);

            } catch (Exception e) {
                respuesta.setCodigo("400");
                respuesta.setSuccess(false);
                respuesta.setMessage("Error en Autenticacion Contraseña Exeption" + e);
                respuesta.setData("Error en Autenticacion Exeption");
            }

            return respuesta;
        }


}
