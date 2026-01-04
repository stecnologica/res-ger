package com.app.gestor.restaurante.dto.req;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class DtoRequestReceta {

    private String nombreReceta;
    private String descripcion;
    private Long usuario_fk;
}
