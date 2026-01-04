package com.app.gestor.restaurante.dto.res;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import lombok.Data;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPOJOBuilder
@Data
public class DtoResponseApi {

    public DtoResponseApi() {
    }

    private boolean success;

    //Este campo si se utiliza en otras clases mediante lombook, pero no se imprime en el toString
    private String codigo;

    //Este campo si se utiliza en otras clases mediante lombook, pero no se imprime en el toString
    private String message;

    private Object data;

    public DtoResponseApi(boolean success, String codigo, String message, Object data) {
        this.success = success;
        this.codigo = codigo;
        this.message = message;
        this.data = data;
    }

    public DtoResponseApi(boolean b, String s, String jwtInvalid) {
    }
//Este campo si se utiliza en otras clases mediante lombook, pero no se imprime en el toString


    @Override
    public String toString() {
        return "DtoResponseLoguin{" +
                "success=" + success +
                ", codigo='" + codigo + '\'' +
                ", message='" + message + '\'' +
                ", data=" + data +
                '}';
    }
}
