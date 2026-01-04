package com.app.gestor.restaurante.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "proveedor")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ProveedorEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idPk;

    @Column(nullable = false)
    private String nombreProveedor;

    private String producto;
    private String marca;
    private String telefono;
    private String direccion;
    private String segmento;
}