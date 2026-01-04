package com.app.gestor.restaurante.dto.req;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class DtoRequestIngredientes {


    private String nombre_ingrediente;
    private String marca;
    private Double precio_compra;
    private Double peso_producto;
    private String unidad_medida;
    private Double valor_producto_gramo;
    private Long proveedor_fk;
}
