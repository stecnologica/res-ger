package com.app.gestor.restaurante.servicesimpl;


import com.app.gestor.restaurante.dto.req.DtoRequestReceta;
import com.app.gestor.restaurante.dto.res.DtoResponseApi;
import com.app.gestor.restaurante.dto.res.DtoResponseReseta;
import com.app.gestor.restaurante.entity.RecetaEntity;
import com.app.gestor.restaurante.entity.UserAppEntity;
import com.app.gestor.restaurante.repository.RecetaRepository;
import com.app.gestor.restaurante.repository.UserAppRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class RecetaServices {
    private final UserAppRepository appRepository;
    private final RecetaRepository recetaRepository;

    public RecetaServices(UserAppRepository appRepository, RecetaRepository recetaRepository) {
        this.appRepository = appRepository;
        this.recetaRepository = recetaRepository;
        ;
    }


    public DtoResponseApi crearreceta(DtoRequestReceta requestreceta) {

        RecetaEntity recetaEntity = new RecetaEntity();
        DtoResponseApi dto = new DtoResponseApi();


        UserAppEntity Userapp = appRepository.findById(requestreceta.getUsuario_fk())
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));

        recetaEntity.setNombreReceta(requestreceta.getNombreReceta());
        recetaEntity.setDescripcion(requestreceta.getDescripcion());
        recetaEntity.setUsuario(Userapp);

        try {


            RecetaEntity respustasave = recetaRepository.save(recetaEntity);

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

    public DtoResponseApi updatereceta(DtoRequestReceta dtoRequestReceta, Long id) {

        RecetaEntity recetaEntity = new RecetaEntity();
        DtoResponseApi dto = new DtoResponseApi();

        try {
            UserAppEntity Userapp = appRepository.findById(dtoRequestReceta.getUsuario_fk())
                    .orElseThrow(() -> new RuntimeException("Userapp no encontrado"));

            recetaEntity.setIdPk(id);
            recetaEntity.setNombreReceta(dtoRequestReceta.getNombreReceta());
            recetaEntity.setDescripcion(dtoRequestReceta.getDescripcion());
            recetaEntity.setUsuario(Userapp);



        }catch (Exception e) {
            String mensaje = "error Exeptcion consultando Userapp para insertar el ingrediente" + e.getMessage();
            dto.setCodigo("501");
            dto.setSuccess(Boolean.FALSE);
            dto.setMessage(mensaje);
        }

        try {
            RecetaEntity respustasave = recetaRepository.save(recetaEntity);
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


    public DtoResponseApi listarreceta() {

        DtoResponseApi dto = new DtoResponseApi();

        try {



            List<DtoResponseReseta> lista =
                    recetaRepository.listarRecetaconUserApp();

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
