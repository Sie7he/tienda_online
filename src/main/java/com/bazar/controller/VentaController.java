package com.bazar.controller;

import com.bazar.model.Venta;
import com.bazar.service.IVentaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class VentaController {

    @Autowired
    private IVentaService ventaService;

    @GetMapping("/ventas")
    List<Venta> getVentas() {
        return ventaService.getVentas();
    }

    @PostMapping("/ventas")
    Venta createVenta(@RequestBody Venta venta) {
        return ventaService.RegistrarVenta(venta);
    }

}
