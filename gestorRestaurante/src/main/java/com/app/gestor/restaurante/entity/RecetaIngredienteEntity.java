package com.app.gestor.restaurante.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "receta_ingrediente")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class RecetaIngredienteEntity {

    @EmbeddedId
    private RecetaIngredienteId id;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("idRecetaFk")
    @JoinColumn(name = "id_receta_fk")
    private RecetaEntity receta;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("idIngredienteFk")
    @JoinColumn(name = "id_ingrediente_fk")
    private IngredienteEntity ingrediente;

    @Column(nullable = false)
    private Double cantidad;
}