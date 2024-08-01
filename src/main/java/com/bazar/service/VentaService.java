package com.bazar.service;

import com.bazar.model.Venta;
import com.bazar.model.VentaDetalle;
import com.bazar.repository.IProductoRepository;
import com.bazar.repository.IVentaDetalleRepository;
import com.bazar.repository.IVentaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class VentaService implements IVentaService{

    @Autowired
    private IVentaRepository ventaRepository;
    @Autowired
    private IVentaDetalleRepository detalleRepository;
    @Autowired
    private IProductoRepository productoRepository;


    @Override
    public List<Venta> getVentas() {
        return ventaRepository.findAll();
    }

    @Override
    public Venta saveVenta(Venta venta) {
        return ventaRepository.save(venta);
    }

    @Override
    public Venta findVenta(Long id) {
       return ventaRepository.findById(id).orElse(null);
    }

    @Transactional
    public Boolean registrarVenta(Venta venta) {
        for (VentaDetalle detalle: venta.getDetalleVenta()) {
            Integer stock = detalle.getProducto().getStock();
            Integer cantidad = detalle.getCantidad();
            if(stock < cantidad) return false;
            detalle.getProducto().setStock(stock-cantidad);
            productoRepository.save(detalle.getProducto());
            detalleRepository.save(detalle);
        }
        ventaRepository.save(venta);
        return true;
    }

}
