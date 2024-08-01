package com.bazar.service;

import com.bazar.model.Producto;

import java.util.List;

public interface IProductoService {

    List<Producto> getProductos();

    void saveProducto(Producto producto);

    Producto findProducto(Long id);

    Producto updateProducto(Producto producto);

    void deleteProducto(Long id);
}
