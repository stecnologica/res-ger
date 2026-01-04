package com.app.gestor.restaurante.repository;


import com.app.gestor.restaurante.entity.UserAppEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserAppRepository extends JpaRepository<UserAppEntity, Long> {
    Optional<UserAppEntity> findByNombreusuario(String nombreusuario);
}
