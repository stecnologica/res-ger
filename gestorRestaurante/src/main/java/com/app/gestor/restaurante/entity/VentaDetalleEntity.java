package com.app.gestor.restaurante.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "venta_detalle")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class VentaDetalleEntity {

    @EmbeddedId
    private VentaDetalleId id;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("idVentaFk")
    @JoinColumn(name = "id_venta_fk")
    private VentaEntity venta;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("idRecetaFk")
    @JoinColumn(name = "id_receta_fk")
    private RecetaEntity receta;

    @Column(nullable = false)
    private Integer cantidad;
}