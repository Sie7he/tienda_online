package com.bazar.controller;

import com.bazar.model.Producto;
import com.bazar.service.IProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductoController {
    @Autowired
    private IProductoService productoService;

    @GetMapping("/productos")
    public List<Producto> getProductos() {
        return productoService.getProductos();
    }

    @GetMapping("/producto/{id}")
    public Producto getProducto(@PathVariable Long id) {
        return productoService.findProducto(id);
    }

    @GetMapping("/productos/sortedByPriceDesc")
    public List<Producto> getProductoSortingByPriceDesc() {
        return productoService.getProductosSortByPrice();
    }

    @PostMapping("/productos")
    public Producto saveProducto(@RequestBody Producto producto) {
        return productoService.saveProducto(producto);
    }

    @PutMapping("/productos/{id}")
    public Producto updateProducto(@RequestBody Producto producto,@PathVariable Long id) {
        return productoService.updateProducto(producto, id);
    }

    @DeleteMapping("/producto/{id}")
    public String deleteProducto(@PathVariable Long id) {
        productoService.deleteProducto(id);
        return "Producto eliminado";
    }
}
