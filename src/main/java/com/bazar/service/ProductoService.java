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
        return productoRepository.findAll();
    }

    @Override
    public void saveProducto(Producto producto) {
        productoRepository.save(producto);
    }

    @Override
    public Producto findProducto(Long id) {
       return productoRepository.findById(id).orElse(null);
    }

    @Override
    public Producto updateProducto(Producto producto) {
        this.saveProducto(producto);
        return this.findProducto(producto.getId_producto());
    }

    @Override
    public void deleteProducto(Long id) {
        productoRepository.logicDelete(id);
    }
}
