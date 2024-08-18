package com.bazar.service;

import com.bazar.dto.VentaDTO;
import com.bazar.dto.VentaDetalleDTO;
import com.bazar.mapper.VentaMapper;
import com.bazar.model.Venta;
import com.bazar.model.VentaDetalle;
import com.bazar.repository.IProductoRepository;
import com.bazar.repository.IVentaDetalleRepository;
import com.bazar.repository.IVentaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class VentaService implements IVentaService{

    @Autowired
    private IVentaRepository ventaRepository;
    @Autowired
    private IProductoRepository productoRepository;
    @Autowired
    private IVentaDetalleRepository detalleRepository;
    Pageable firstPageWithTwoELements = PageRequest.of(0, 2);

    @Override


    public List<VentaDTO> getVentasDTO() {
        List<Venta> ventas = ventaRepository.findAll();
            return ventas.stream()
                    .map(VentaMapper :: toVentaDTO)
                    .collect(Collectors.toList());
    }

    @Override
    public Venta findVenta(Long id) {
       return ventaRepository.findById(id).orElse(null);
    }

    @Override
    public List<VentaDTO> getVentaPagination() {
        Pageable firstPageWithTwoElements = PageRequest.of(0,2);
       Page<Venta> ventas = ventaRepository.findAll(firstPageWithTwoElements);

       return ventas.stream()
               .map(VentaMapper::toVentaDTO)
               .collect(Collectors.toList());
    }



    @Override
    @Transactional
    public Venta RegistrarVenta(Venta venta) {
        Venta nuevaVenta = this.ventaRepository.save(venta);
        List<VentaDetalle> detalleList = new ArrayList<>();
        for (VentaDetalle detalle : venta.getDetalleVenta()) {
            gestionarStock(detalle);
            detalle.setVenta(venta);
            detalleList.add(detalle);

        }
        detalleRepository.saveAll(detalleList);
        return nuevaVenta;

    }

    private void gestionarStock(VentaDetalle detalle) {
        Long productoId = detalle.getProducto().getId();
        int cantidad = detalle.getCantidad();
        int stock = productoRepository.findStockById(productoId);
        int newStock = stock - cantidad;

        if(newStock < 0) {
            throw new RuntimeException("Stock insuficiente para el producto: "+ productoId);
        }

        productoRepository.discountStock(newStock, productoId);
    }


}
