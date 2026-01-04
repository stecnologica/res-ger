package com.app.gestor.restaurante.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "users_app_restaurante")
@Getter
@Setter
public class UserAppEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="nombre")
    private String nombre;

    @Column(name="apellido")
    private String apellido;

    @Column(name="nombre_usuario", unique = true)
    private String nombreusuario;

    @Column(name= "correo",unique = true)
    private String correo;

    @Column(name="roll")
    private String roll;

    @Column(name="contrasena")
    private String contrasena; // Se guarda encriptada


    public UserAppEntity() {
    }

    public UserAppEntity(Long id, String nombre, String apellido, String nombreusuario, String correo, String roll, String contrasena) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.nombreusuario = nombreusuario;
        this.correo = correo;
        this.roll = roll;
        this.contrasena = contrasena;
    }

}
