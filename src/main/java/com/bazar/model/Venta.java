package com.bazar.model;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Getter @Setter
@Entity
public class Venta {

    private Long codigo_venta;
    private LocalDate fecha_venta;
    private int total;
    @OneToMany (mappedBy = "venta")
    private List<VentaDetalle> detalleVenta;
    @ManyToOne
    @JoinColumn(name= "id_cliente")
    private Cliente cliente;

    public Venta(){}

    public Venta(Long codigo_venta, LocalDate fecha_venta, int total, List<VentaDetalle> detalleVenta, Cliente cliente) {
        this.codigo_venta = codigo_venta;
        this.fecha_venta = fecha_venta;
        this.total = total;
        this.detalleVenta = detalleVenta;
        this.cliente = cliente;
    }
}
