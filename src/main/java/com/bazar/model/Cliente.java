package com.bazar.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@Entity
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_cliente")
    private Long id;
    private String nombre;
    private String apellido;
    private String run;
    private boolean estado = Boolean.TRUE;

    public Cliente(){}

    public Cliente(Long id_cliente, String nombre, String apellido, String run, boolean estado) {
        this.id = id_cliente;
        this.nombre = nombre;
        this.apellido = apellido;
        this.run = run;
        this.estado = estado;
    }
}
