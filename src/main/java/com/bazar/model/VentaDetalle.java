package com.bazar.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@Entity
public class VentaDetalle {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_detalle;
    @ManyToOne
    @JoinColumn(name = "codigo_venta", referencedColumnName = "codigo_venta")
    private Venta venta;
    @ManyToOne
    @JoinColumn(name = "id_producto", referencedColumnName = "id_producto")
    private Producto producto;
    private Integer cantidad;

    public VentaDetalle() {}

    public VentaDetalle(Long id_detalle, Venta venta, Producto producto, Integer cantidad) {
        this.id_detalle = id_detalle;
        this.venta = venta;
        this.producto = producto;
        this.cantidad = cantidad;
    }
}
