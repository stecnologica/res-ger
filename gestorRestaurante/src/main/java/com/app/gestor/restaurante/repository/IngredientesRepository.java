package com.app.gestor.restaurante.repository;

import com.app.gestor.restaurante.dto.res.DtoResponseIngrediente;
import com.app.gestor.restaurante.entity.IngredienteEntity;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IngredientesRepository  extends JpaRepository<IngredienteEntity, Long> {



    @Query("""
        SELECT new com.app.gestor.restaurante.dto.res.DtoResponseIngrediente(
            i.idPk,
            i.nombreIngrediente,
            i.marca,
            i.precioCompra,
            i.pesoProducto,
            i.unidadMedida,
            i.valorProductoGramo,
            p.idPk,
            p.nombreProveedor
        )
        FROM IngredienteEntity i
        JOIN i.proveedor p
    """)
    List<DtoResponseIngrediente> listarIngredientesConProveedor();

}
