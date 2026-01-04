package com.app.gestor.restaurante.controller.ingrediente;


import com.app.gestor.restaurante.dto.req.DtoRequestCrearProveedor;
import com.app.gestor.restaurante.dto.req.DtoRequestIngredientes;
import com.app.gestor.restaurante.dto.res.DtoResponseApi;
import com.app.gestor.restaurante.servicesimpl.IngredientesServices;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "http://localhost:5173/")
@RequestMapping("/webapp")
public class IngredienteController {

    private final IngredientesServices ingredientesServices;

    public IngredienteController(IngredientesServices ingredientesServices) {
        this.ingredientesServices = ingredientesServices;
    }

    @PostMapping("/crearingrediente")
    public DtoResponseApi crearingrediente(@RequestBody DtoRequestIngredientes dtoIngredientes) {
        DtoResponseApi respuesta = new DtoResponseApi();
        System.out.println("Dto q entra de ingredinetes: " + dtoIngredientes);

        try {
            respuesta = ingredientesServices.crearingrediente(dtoIngredientes);
            System.out.println("respuesta de crear Ingrediente: " + respuesta);

        } catch (Exception e) {
            respuesta.setCodigo("400");
            respuesta.setSuccess(false);
            respuesta.setMessage("Error en Autenticacion Contraseña Exeption" + e);
            respuesta.setData("Error en Autenticacion Exeption");
        }

        return respuesta;
    }




    @PutMapping("/actualizaringrediente/{id}")
    public DtoResponseApi updateingrediente( @PathVariable Long id,
                                               @RequestBody DtoRequestIngredientes dtoRequestIngredientes) {
        DtoResponseApi respuesta = new DtoResponseApi();

        try {
            respuesta = ingredientesServices.updateingrediente(dtoRequestIngredientes, id);
            System.out.println("respuesta de crear ingrediente update "+ respuesta);

        } catch (Exception e) {
            respuesta.setCodigo("400");
            respuesta.setSuccess(false);
            respuesta.setMessage("Error en Autenticacion Contraseña Exeption" + e);
            respuesta.setData("Error en Autenticacion Exeption");
        }

        return respuesta;
    }


    @GetMapping("/listaringrediente")
    public DtoResponseApi listaringrediente() {
        DtoResponseApi respuesta = new DtoResponseApi();

        try {
            respuesta = ingredientesServices.Listingrediente();
            System.out.println("respuesta de listar ingrediente "+ respuesta);

        } catch (Exception e) {
            respuesta.setCodigo("400");
            respuesta.setSuccess(false);
            respuesta.setMessage("Error en Autenticacion Contraseña Exeption" + e);
            respuesta.setData("Error en Autenticacion Exeption");
        }

        return respuesta;
    }



}
