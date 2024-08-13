package com.bazar.service;

import com.bazar.model.Producto;
import com.bazar.model.Venta;
import com.bazar.model.VentaDetalle;
import com.bazar.repository.IProductoRepository;
import com.bazar.repository.IVentaDetalleRepository;
import com.bazar.repository.IVentaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class VentaService implements IVentaService{

    @Autowired
    private IVentaRepository ventaRepository;
    @Autowired
    private IProductoRepository productoRepository;
    @Autowired
    private IVentaDetalleRepository detalleRepository;

    @Override
    public List<Venta> getVentas() {
        return ventaRepository.findAll();
    }


    @Override
    public Venta findVenta(Long id) {
       return ventaRepository.findById(id).orElse(null);
    }




    @Override
    @Transactional
    public Venta RegistrarVenta(Venta venta) {

        Venta nuevaVenta = this.ventaRepository.save(venta);

        List<VentaDetalle> detalleList = new ArrayList<>();
        for (VentaDetalle detalle : venta.getDetalleVenta()) {
            Long productoId = detalle.getProducto().getId();
            int cantidad = detalle.getCantidad();

            int stock = productoRepository.findStockById(productoId);
            int newStock = stock-cantidad;
            if(newStock < 0) {
                throw new RuntimeException("Stock insuficiente para el producto: "+ productoId);
            }
            productoRepository.discountStock(newStock, productoId);
            detalle.setVenta(venta);
            detalleList.add(detalle);

        }
        productoRepository.flush();
        detalleRepository.saveAll(detalleList);
        return nuevaVenta;

    }

}
