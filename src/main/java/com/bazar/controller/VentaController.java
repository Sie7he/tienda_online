package com.bazar.controller;

import com.bazar.dto.VentaDTO;
import com.bazar.model.Venta;
import com.bazar.service.IVentaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class VentaController {

    @Autowired
    private IVentaService ventaService;

    @GetMapping("/ventas")
    List<VentaDTO> getVentas() {
        return ventaService.getVentasDTO();
    }

    @GetMapping("/venta/{id}")
    public Venta getVentaById(@PathVariable Long id) {
        return ventaService.findVenta(id);
    }

    @GetMapping("/venta")
    public List<VentaDTO> getVentasPaginatio() {
    return ventaService.getVentaPagination();

    }

    @PostMapping("/ventas")
    Venta createVenta(@RequestBody Venta venta) {
        return ventaService.RegistrarVenta(venta);
    }

}
