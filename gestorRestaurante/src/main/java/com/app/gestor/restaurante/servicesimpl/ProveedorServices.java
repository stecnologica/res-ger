package com.app.gestor.restaurante.servicesimpl;

import com.app.gestor.restaurante.dto.req.DtoRequestCrearProveedor;
import com.app.gestor.restaurante.dto.res.DtoResponseApi;
import com.app.gestor.restaurante.entity.ProveedorEntity;
import com.app.gestor.restaurante.repository.ProveedorRepository;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class ProveedorServices {

    private final ProveedorRepository proveedorRepository;


    public ProveedorServices(ProveedorRepository proveedorRepository) {
        this.proveedorRepository = proveedorRepository;
    }

    public DtoResponseApi crearProveedor(DtoRequestCrearProveedor requestcrearproveedor) {

        ProveedorEntity proveedor = new ProveedorEntity();
        DtoResponseApi dto = new DtoResponseApi();


        proveedor.setNombreProveedor(requestcrearproveedor.getNombreProveedor());
        proveedor.setProducto(requestcrearproveedor.getProducto());
        proveedor.setMarca(requestcrearproveedor.getMarca());
        proveedor.setTelefono(requestcrearproveedor.getTelefono());
        proveedor.setDireccion(requestcrearproveedor.getDireccion());
        proveedor.setSegmento(requestcrearproveedor.getSegmento());


        try {

            ProveedorEntity respustasave = proveedorRepository.save(proveedor);

            if (respustasave != null) {

                String mensaje = "Creacion Proveedor Exitoso";

                dto.setCodigo("200");
                dto.setSuccess(Boolean.TRUE);
                dto.setMessage(mensaje);
                dto.setData(respustasave);
                return dto;

            }else {
                String mensaje = "error creando Proveedor";

                dto.setCodigo("401");
                dto.setSuccess(Boolean.FALSE);
                dto.setMessage(mensaje);
                dto.setData(respustasave);
                return dto;
            }
        }catch (Exception e) {

            String mensaje = "error Exeptcion creando Proveedor" + e.getMessage();
            dto.setCodigo("501");
            dto.setSuccess(Boolean.FALSE);
            dto.setMessage(mensaje);
            return dto;
        }
    }





    public DtoResponseApi updateProveedor(DtoRequestCrearProveedor requestcrearproveedor, Long id) {

        ProveedorEntity proveedor = new ProveedorEntity();
        DtoResponseApi dto = new DtoResponseApi();

        proveedor.setIdPk(id);
        proveedor.setNombreProveedor(requestcrearproveedor.getNombreProveedor());
        proveedor.setProducto(requestcrearproveedor.getProducto());
        proveedor.setMarca(requestcrearproveedor.getMarca());
        proveedor.setTelefono(requestcrearproveedor.getTelefono());
        proveedor.setDireccion(requestcrearproveedor.getDireccion());
        proveedor.setSegmento(requestcrearproveedor.getSegmento());


        try {

            ProveedorEntity respustasave = proveedorRepository.save(proveedor);

            if (respustasave != null) {

                String mensaje = "Creacion Proveedor Exitoso";

                dto.setCodigo("200");
                dto.setSuccess(Boolean.TRUE);
                dto.setMessage(mensaje);
                dto.setData(respustasave);
                return dto;

            }else {
                String mensaje = "error creando Proveedor";

                dto.setCodigo("401");
                dto.setSuccess(Boolean.FALSE);
                dto.setMessage(mensaje);
                dto.setData(respustasave);
                return dto;
            }
        }catch (Exception e) {

            String mensaje = "error Exeptcion creando Proveedor" + e.getMessage();
            dto.setCodigo("501");
            dto.setSuccess(Boolean.FALSE);
            dto.setMessage(mensaje);
            return dto;
        }
    }


    public DtoResponseApi Listproveedor() {

        DtoResponseApi dto = new DtoResponseApi();

        try {
            List<ProveedorEntity> respustasave = proveedorRepository.findAll();
            if (respustasave != null) {

                String mensaje = "Creacion Proveedor Exitoso";

                dto.setCodigo("200");
                dto.setSuccess(Boolean.TRUE);
                dto.setMessage(mensaje);
                dto.setData(respustasave);

                return dto;

            }else {
                String mensaje = "error creando Proveedor";

                dto.setCodigo("401");
                dto.setSuccess(Boolean.FALSE);
                dto.setMessage(mensaje);
                dto.setData(respustasave);
                return dto;
            }
        }catch (Exception e) {

            String mensaje = "error Exeptcion creando Proveedor" + e.getMessage();
            dto.setCodigo("501");
            dto.setSuccess(Boolean.FALSE);
            dto.setMessage(mensaje);
            return dto;
        }
    }


    }
