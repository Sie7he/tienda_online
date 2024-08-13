package com.bazar.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@Entity
public class Producto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_producto")
    private Long id;
    private String nombre;
    private String marca;
    private int precio;
    private int stock;
    private boolean estado = Boolean.TRUE;

    public Producto(){}

    public Producto(Long id_producto, String nombre, String marca, int precio, int stock, boolean estado) {
        this.id = id_producto;
        this.nombre = nombre;
        this.marca = marca;
        this.precio = precio;
        this.stock = stock;
        this.estado = estado;
    }
}
