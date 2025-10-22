package com.sistemaBackend.SistemaTittaBackend.service;

import com.sistemaBackend.SistemaTittaBackend.model.Producto;

import java.util.List;

public interface ProductoService {

    Producto crearProducto(Producto producto);
    List<Producto> obtenerTodosLosProductos();
    Producto obtenerProductoPorId(Long idProducto);
    Producto actualizarProducto(Long idProducto, Producto productoDetails);
    Producto actualizarCategoriaDeProducto(Long idProducto, Long idCategoria);
    void eliminarProducto(Long idProducto);

}
