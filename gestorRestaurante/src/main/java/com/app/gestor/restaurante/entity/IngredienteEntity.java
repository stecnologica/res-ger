package com.app.gestor.restaurante.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "ingredientes")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class IngredienteEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idPk;

    @Column(nullable = false)
    private String nombreIngrediente;

    private String marca;

    @Column(nullable = false)
    private Double precioCompra;

    @Column(nullable = false)
    private Double pesoProducto;

    @Column(nullable = false)
    private String unidadMedida;

    @Column(nullable = false)
    private Double valorProductoGramo;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "proveedor_fk")
    private ProveedorEntity proveedor;
}