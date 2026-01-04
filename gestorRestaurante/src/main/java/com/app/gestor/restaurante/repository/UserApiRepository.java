package com.app.gestor.restaurante.repository;


import com.app.gestor.restaurante.entity.UserApiEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserApiRepository extends JpaRepository<UserApiEntity, Long> {
    Optional<UserApiEntity> findByUserName(String userName);
}
