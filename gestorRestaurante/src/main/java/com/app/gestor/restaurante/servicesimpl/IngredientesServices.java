package com.app.gestor.restaurante.servicesimpl;


import com.app.gestor.restaurante.dto.req.DtoRequestCrearProveedor;
import com.app.gestor.restaurante.dto.req.DtoRequestIngredientes;
import com.app.gestor.restaurante.dto.res.DtoResponseApi;
import com.app.gestor.restaurante.dto.res.DtoResponseIngrediente;
import com.app.gestor.restaurante.entity.IngredienteEntity;
import com.app.gestor.restaurante.entity.ProveedorEntity;
import com.app.gestor.restaurante.repository.IngredientesRepository;
import com.app.gestor.restaurante.repository.ProveedorRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class IngredientesServices {

    private final ProveedorRepository proveedorRepository;
    private final IngredientesRepository ingredientesRepository;

    public IngredientesServices(ProveedorRepository proveedorRepository, IngredientesRepository ingredientesRepository) {
        this.proveedorRepository = proveedorRepository;
        this.ingredientesRepository = ingredientesRepository;
    }


    public DtoResponseApi crearingrediente(DtoRequestIngredientes requestcrearIngrediente) {

        IngredienteEntity ingrediente = new IngredienteEntity();
        DtoResponseApi dto = new DtoResponseApi();

        try {
            ProveedorEntity proveedor = proveedorRepository.findById(requestcrearIngrediente.getProveedor_fk())
                    .orElseThrow(() -> new RuntimeException("Proveedor no encontrado"));

            ingrediente.setMarca(requestcrearIngrediente.getMarca());
            ingrediente.setNombreIngrediente(requestcrearIngrediente.getNombre_ingrediente());
            ingrediente.setPesoProducto(requestcrearIngrediente.getPeso_producto());
            ingrediente.setPrecioCompra(requestcrearIngrediente.getPrecio_compra());
            ingrediente.setUnidadMedida(requestcrearIngrediente.getUnidad_medida());
            ingrediente.setValorProductoGramo(requestcrearIngrediente.getValor_producto_gramo());
            ingrediente.setProveedor(proveedor);

        }catch (Exception e) {
            String mensaje = "error Exeption consultando provedor para insertar el ingrediente" + e.getMessage();
            dto.setCodigo("501");
            dto.setSuccess(Boolean.FALSE);
            dto.setMessage(mensaje);
        }

        try {
            IngredienteEntity respustasave = ingredientesRepository.save(ingrediente);
            System.out.println("respuesta de crear ingrediente "+ respustasave);

            if (respustasave != null) {

                String mensaje = "Creacion crearingrediente  Exitoso";

                dto.setCodigo("200");
                dto.setSuccess(Boolean.TRUE);
                dto.setMessage(mensaje);
                dto.setData(respustasave);

                return dto;

            }else {
                String mensaje = "error creando ingrediente";

                dto.setCodigo("401");
                dto.setSuccess(Boolean.FALSE);
                dto.setMessage(mensaje);
                dto.setData(respustasave);
                return dto;
            }
        }catch (Exception e) {

            String mensaje = "error Exeption creando ingrediente" + e.getMessage();
            dto.setCodigo("501");
            dto.setSuccess(Boolean.FALSE);
            dto.setMessage(mensaje);
            return dto;
        }
    }



    public DtoResponseApi updateingrediente(DtoRequestIngredientes requestcrearIngrediente, Long id) {

        IngredienteEntity ingrediente = new IngredienteEntity();
        DtoResponseApi dto = new DtoResponseApi();

        try {
            ProveedorEntity proveedor = proveedorRepository.findById(requestcrearIngrediente.getProveedor_fk())
                    .orElseThrow(() -> new RuntimeException("Proveedor no encontrado"));

            ingrediente.setIdPk(id);
            ingrediente.setMarca(requestcrearIngrediente.getMarca());
            ingrediente.setNombreIngrediente(requestcrearIngrediente.getNombre_ingrediente());
            ingrediente.setPesoProducto(requestcrearIngrediente.getPeso_producto());
            ingrediente.setPrecioCompra(requestcrearIngrediente.getPrecio_compra());
            ingrediente.setUnidadMedida(requestcrearIngrediente.getUnidad_medida());
            ingrediente.setValorProductoGramo(requestcrearIngrediente.getValor_producto_gramo());
            ingrediente.setProveedor(proveedor);

        }catch (Exception e) {
            String mensaje = "error Exeptcion consultando provedor para insertar el ingrediente" + e.getMessage();
            dto.setCodigo("501");
            dto.setSuccess(Boolean.FALSE);
            dto.setMessage(mensaje);
        }

        try {
            IngredienteEntity respustasave = ingredientesRepository.save(ingrediente);
            System.out.println("respuesta de updateingrediente "+ respustasave);

            if (respustasave != null) {

                String mensaje = "updateingrediente Exitoso";

                dto.setCodigo("200");
                dto.setSuccess(Boolean.TRUE);
                dto.setMessage(mensaje);
                dto.setData(respustasave);

                return dto;

            }else {
                String mensaje = "error updateingrediente";

                dto.setCodigo("401");
                dto.setSuccess(Boolean.FALSE);
                dto.setMessage(mensaje);
                dto.setData(respustasave);
                return dto;
            }
        }catch (Exception e) {

            String mensaje = "error Exeptcion updateingrediente" + e.getMessage();
            dto.setCodigo("501");
            dto.setSuccess(Boolean.FALSE);
            dto.setMessage(mensaje);
            return dto;
        }
    }



    public DtoResponseApi Listingrediente() {

        DtoResponseApi dto = new DtoResponseApi();

        try {



            List<DtoResponseIngrediente> lista =
                    ingredientesRepository.listarIngredientesConProveedor();

            System.out.println("Lsta de ingredientes "+lista.size());
            System.out.println("Lsta de ingredientes "+ lista.toString());


            if (lista != null) {

                String mensaje = "Listar Ingredientes Exitoso";

                dto.setCodigo("200");
                dto.setSuccess(Boolean.TRUE);
                dto.setMessage(mensaje);
                dto.setData(lista);

                return dto;

            }else {
                String mensaje = "error Listar Ingredientes";

                dto.setCodigo("401");
                dto.setSuccess(Boolean.FALSE);
                dto.setMessage(mensaje);
                dto.setData(lista);
                return dto;
            }
        }catch (Exception e) {

            String mensaje = "error Exeptcion Listar Ingredientes" + e.getMessage();
            dto.setCodigo("501");
            dto.setSuccess(Boolean.FALSE);
            dto.setMessage(mensaje);
            return dto;
        }
    }
}
