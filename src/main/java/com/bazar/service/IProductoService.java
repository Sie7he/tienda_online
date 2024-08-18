package com.bazar.service;

import com.bazar.model.Producto;

import java.util.List;

public interface IProductoService {

    List<Producto> getProductos();

    Producto saveProducto(Producto producto);

    Producto findProducto(Long id);

    Producto updateProducto(Producto producto, Long id);

    void deleteProducto(Long id);

    List<Producto> getProductosSortByPrice();
}
