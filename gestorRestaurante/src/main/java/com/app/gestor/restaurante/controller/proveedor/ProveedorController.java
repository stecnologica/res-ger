package com.app.gestor.restaurante.controller.proveedor;


import com.app.gestor.restaurante.dto.req.DtoRequestCrearProveedor;
import com.app.gestor.restaurante.dto.res.DtoResponseApi;

import com.app.gestor.restaurante.servicesimpl.ProveedorServices;
import org.hibernate.annotations.Parameter;
import org.springframework.web.bind.annotation.*;



@RestController
@CrossOrigin(origins = "http://localhost:5173/")
@RequestMapping("/webapp")
public class ProveedorController {

    private final ProveedorServices proveedorServices;

    public ProveedorController(ProveedorServices proveedorServices) {
        this.proveedorServices = proveedorServices;
    }

    @PostMapping("/crearproveedor")
    public DtoResponseApi crearproveedor(@RequestBody DtoRequestCrearProveedor requestcrearproveedor) {
        DtoResponseApi respuesta = new DtoResponseApi();

        try {
            respuesta = proveedorServices.crearProveedor(requestcrearproveedor);
            System.out.println("respuesta de crear proveedor "+ respuesta);



        } catch (Exception e) {
            respuesta.setCodigo("400");
            respuesta.setSuccess(false);
            respuesta.setMessage("Error en Autenticacion Contraseña Exeption" + e);
            respuesta.setData("Error en Autenticacion Exeption");
        }

        return respuesta;
    }


    @PutMapping("/actualizarproveedor/{id}")
    public DtoResponseApi actualizarproveedor( @PathVariable Long id,
                                               @RequestBody DtoRequestCrearProveedor requestactualizarproveedor) {
        DtoResponseApi respuesta = new DtoResponseApi();

        try {
            respuesta = proveedorServices.updateProveedor(requestactualizarproveedor, id);
            System.out.println("respuesta de crear proveedor "+ respuesta);

        } catch (Exception e) {
            respuesta.setCodigo("400");
            respuesta.setSuccess(false);
            respuesta.setMessage("Error en Autenticacion Contraseña Exeption" + e);
            respuesta.setData("Error en Autenticacion Exeption");
        }

        return respuesta;
    }

    @GetMapping("/listarproveedor")
    public DtoResponseApi actualizarproveedor() {
        DtoResponseApi respuesta = new DtoResponseApi();

        try {
            respuesta = proveedorServices.Listproveedor();
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
