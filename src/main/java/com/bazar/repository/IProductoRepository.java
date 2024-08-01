package com.bazar.repository;

import com.bazar.model.Producto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface IProductoRepository extends JpaRepository <Producto, Long> {

    @Query("UPDATE FROM PRODUCTO SET estado = 0 WHERE id_producto = ?1")
    void logicDelete(Long id);
}
