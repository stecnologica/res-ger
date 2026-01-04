package com.app.gestor.restaurante.dto.res;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Data
public class DtoResponseIngrediente {

    private Long idIngrediente;
    private String nombreIngrediente;
    private String marca;
    private Double precioCompra;
    private Double pesoProducto;
    private String unidadMedida;
    private Double valorProductoGramo;
    private Long proveedorId;
    private String nombreProveedor;

    public DtoResponseIngrediente(Long idIngrediente, String nombreIngrediente, String marca, Double precioCompra, Double pesoProducto, String unidadMedida, Double valorProductoGramo, Long proveedorId, String nombreProveedor) {
        this.idIngrediente = idIngrediente;
        this.nombreIngrediente = nombreIngrediente;
        this.marca = marca;
        this.precioCompra = precioCompra;
        this.pesoProducto = pesoProducto;
        this.unidadMedida = unidadMedida;
        this.valorProductoGramo = valorProductoGramo;
        this.proveedorId = proveedorId;
        this.nombreProveedor = nombreProveedor;
    }
}
