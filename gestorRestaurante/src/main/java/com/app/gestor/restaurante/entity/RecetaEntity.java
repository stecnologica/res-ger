package com.app.gestor.restaurante.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "receta")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class RecetaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idPk;

    @Column(nullable = false)
    private String nombreReceta;

    @Column(columnDefinition = "TEXT")
    private String descripcion;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "usuario_fk", nullable = false)
    private UserAppEntity usuario;
}