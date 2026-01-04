package com.app.gestor.restaurante.entity;


import jakarta.persistence.*;
import lombok.Data;


@Entity
@Table(name= "user_api")
@Data
public class UserApiEntity {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="idUser")
    private Integer idUser;

    @Column(name="userName")
    private String userName;

    @Column(name="password")
    private String password;

    @Column(name="appName")
    private String appName;

    public UserApiEntity() {
        super();
    }
    @Override
    public String toString() {
        return "UserEntity [idUser=" + idUser + ", userName=" + userName + ", password= [PROTECTED]" + ", appName="
                + appName + "]";
    }

}

