package com.bazar.model;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@Entity
public class Cliente {

    private Long id_cliente;
    private String nombre;
    private String apellido;
    private String run;
    private boolean estado;

    public Cliente(){}

    public Cliente(Long id_cliente, String nombre, String apellido, String run, boolean estado) {
        this.id_cliente = id_cliente;
        this.nombre = nombre;
        this.apellido = apellido;
        this.run = run;
        this.estado = estado;
    }
}
