package com.bazar.repository;

import com.bazar.model.Producto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Repository
public interface IProductoRepository extends JpaRepository <Producto, Long> {

    @Modifying
    @Query("update Producto p set p.estado = false where p.id = ?1")
    void desactiveProduct(Long id);

    List<Producto> findAllByEstadoTrue();

    Optional<Producto> findByEstadoTrueAndId(Long id);

    int findStockById(Long id);

    @Modifying
    @Query("update Producto p set p.stock = ?1 where p.id = ?2")
    void discountStock(int stock, Long id);


}
