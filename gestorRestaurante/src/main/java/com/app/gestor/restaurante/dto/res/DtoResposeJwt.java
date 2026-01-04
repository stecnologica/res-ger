package com.app.gestor.restaurante.dto.res;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;


@JsonInclude(JsonInclude.Include.NON_NULL)
@Data
public class DtoResposeJwt {

    private String trasactionID;
    private String jwtToken;

    @Override
    public String toString() {
        return "DtoResposeJwt{" +
                "trasactionID='" + trasactionID + '\'' +
                ", jwtToken='" + jwtToken + '\'' +
                '}';
    }
}
