package com.bazar.service;

import com.bazar.model.Producto;
import com.bazar.repository.IProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
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
    public Producto updateProducto(Producto producto, Long id) {
       if (producto.getId() == id) {
           return this.saveProducto(producto);
       } else {
           throw new RuntimeException("Producto no coincide con ID");
       }
    }

    @Override
    public void deleteProducto(Long id) {
        productoRepository.desactiveProduct(id);
    }

    @Override
    public List<Producto> getProductosSortByPrice() {
        Pageable sortedByPrice = PageRequest.of(0,2,Sort.by("precio").descending());

        List<Producto> productoSorted = productoRepository.findAllByEstadoTrue(sortedByPrice);
        return productoSorted;
    }
}
