package com.app.gestor.restaurante.dto.req;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;



@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class DtoRequestCrearProveedor {


    private String nombreProveedor;

    private String producto;

    private String marca;

    private String telefono;

    private String direccion;

    private String segmento;
}
