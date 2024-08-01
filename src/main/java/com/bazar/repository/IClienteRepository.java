package com.bazar.repository;

import com.bazar.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface IClienteRepository extends JpaRepository <Cliente, Long> {

    @Query("UPDATE FROM cliente SET estado = 0 WHERE id_cliente = ?1")
    void logicDelete(Long id);
}
