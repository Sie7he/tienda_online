package com.bazar.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@Entity
public class Producto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_producto;
    private String nombre;
    private String marca;
    private int precio;
    private int stock;
    private boolean estado = Boolean.FALSE;

    public Producto(){}

    public Producto(Long id_producto, String nombre, String marca, int precio, int stock, boolean estado) {
        this.id_producto = id_producto;
        this.nombre = nombre;
        this.marca = marca;
        this.precio = precio;
        this.stock = stock;
        this.estado = estado;
    }
}
