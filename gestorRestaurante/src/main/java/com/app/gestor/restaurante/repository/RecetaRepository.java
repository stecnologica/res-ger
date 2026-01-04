package com.app.gestor.restaurante.repository;

import com.app.gestor.restaurante.dto.res.DtoResponseIngrediente;
import com.app.gestor.restaurante.dto.res.DtoResponseReseta;
import com.app.gestor.restaurante.entity.RecetaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface RecetaRepository extends JpaRepository<RecetaEntity, Long> {


    @Query("""
        SELECT new com.app.gestor.restaurante.dto.res.DtoResponseReseta(
            i.idPk,
            i.nombreReceta,
            i.descripcion,
            p.id
        )
        FROM RecetaEntity i
        JOIN i.usuario p
    """)
    List<DtoResponseReseta> listarRecetaconUserApp();
}
