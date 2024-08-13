package com.bazar.service;

import com.bazar.model.Producto;
import com.bazar.repository.IProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductoService implements IProductoService{

    @Autowired
    private IProductoRepository productoRepository;

    @Override
    public List<Producto> getProductos() {
        return productoRepository.findAllByEstadoTrue();
    }

    @Override
    public Producto saveProducto(Producto producto) {
       return productoRepository.save(producto);
    }

    @Override
    public Producto findProducto(Long id) {
       return productoRepository.findByEstadoTrueAndId(id).orElse(null);
    }

    @Override
    public Producto updateProducto(Producto producto) {
        this.saveProducto(producto);
        return this.findProducto(producto.getId());
    }

    @Override
    public void deleteProducto(Long id) {
        productoRepository.desactiveProduct(id);
    }
}
