package com.bazar.mapper;

import com.bazar.dto.VentaDTO;
import com.bazar.dto.VentaDetalleDTO;
import com.bazar.model.Venta;

import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class VentaMapper {

    public static VentaDTO toVentaDTO(Venta venta) {
        List<VentaDetalleDTO> detalleDTO = venta.getDetalleVenta().stream()
                .map(ventaDetalle -> new VentaDetalleDTO(
                        ventaDetalle.getProducto().getId(),
                        ventaDetalle.getProducto().getNombre(),
                        ventaDetalle.getCantidad()
                ))
                .collect(Collectors.toList());

            return new VentaDTO(
                    venta.getCodigo_venta(),
                    venta.getCliente().getId(),
                    venta.getFecha_venta(),
                    detalleDTO,
                    venta.getTotal()
            );
    }



}
