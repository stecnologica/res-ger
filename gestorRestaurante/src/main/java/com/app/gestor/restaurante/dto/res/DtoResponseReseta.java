package com.app.gestor.restaurante.dto.res;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Data
public class DtoResponseReseta {

    private long id_pk;
    private String nombreReceta;
    private String descripcion;
    private Long usuario_fk;

    public DtoResponseReseta(long id_pk, String nombreReceta, String descripcion, Long usuario_fk) {
        this.id_pk = id_pk;
        this.nombreReceta = nombreReceta;
        this.descripcion = descripcion;
        this.usuario_fk = usuario_fk;
    }
}
