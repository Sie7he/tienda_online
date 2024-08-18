package com.bazar.service;

import com.bazar.dto.VentaDTO;
import com.bazar.model.Venta;

import java.util.List;

public interface IVentaService {


    List<VentaDTO> getVentasDTO();

    Venta findVenta(Long id);

    Venta RegistrarVenta(Venta venta);

    List<VentaDTO> getVentaPagination();

}
