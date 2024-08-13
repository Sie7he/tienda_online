package com.bazar.repository;

import com.bazar.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface IClienteRepository extends JpaRepository <Cliente, Long> {

    List<Cliente> findAllByEstadoTrue();

    Optional<Cliente> findByEstadoTrueAndId(Long id);

    @Query("UPDATE Cliente c SET c.estado = false WHERE c.id = ?1")
    void desactiveCliente(Long id);
}
