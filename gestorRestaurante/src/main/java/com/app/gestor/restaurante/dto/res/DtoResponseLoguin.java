package com.app.gestor.restaurante.dto.res;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;


@JsonInclude(JsonInclude.Include.NON_NULL)
@Data
public class DtoResponseLoguin extends DtoResponseApi{


    private String nombre;
    private String apellido;
    private String nombreusuario;
    private String correo;
    private String contrasena;

    @Override
    public String toString() {
        return "DtoResponseLoguin{" +
                "nombre='" + nombre + '\'' +
                ", apellido='" + apellido + '\'' +
                ", nombreusuario='" + nombreusuario + '\'' +
                ", correo='" + correo + '\'' +
                ", contrasena= [PROTECTED]" +
                '}';
    }
}
