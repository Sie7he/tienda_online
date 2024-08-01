package com.bazar.service;

import com.bazar.model.Venta;

import java.util.List;

public interface IVentaService {

    List<Venta> getVentas();

    Venta saveVenta(Venta venta);

    Venta findVenta(Long id);



}
