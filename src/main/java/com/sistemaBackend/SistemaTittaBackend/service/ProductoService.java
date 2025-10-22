package com.sistemaBackend.SistemaTittaBackend.service;

import com.sistemaBackend.SistemaTittaBackend.model.Producto;

import java.util.List;

public interface ProductoService {

    Producto crearProducto(Producto producto);
    List<Producto> obtenerTodosLosProductos();
    Producto obtenerProductoPorId(Long idProducto);
    Producto actualizarProducto(Long idProducto, Producto productoDetails);
    void eliminarProducto(Long idProducto);

}
