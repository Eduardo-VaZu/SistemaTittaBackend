package com.sistemaBackend.SistemaTittaBackend.service;

import com.sistemaBackend.SistemaTittaBackend.dto.request.ProductoDTO;
import com.sistemaBackend.SistemaTittaBackend.dto.response.ProductoResponseDTO;
import com.sistemaBackend.SistemaTittaBackend.model.Producto;

import java.util.List;

public interface ProductoService {

    ProductoResponseDTO crearProducto(ProductoDTO producto);
    List<ProductoResponseDTO> obtenerTodosLosProductos();
    ProductoResponseDTO obtenerProductoPorId(Long idProducto);
    ProductoResponseDTO actualizarProducto(Long idProducto, ProductoDTO productoDTO);
    void eliminarProducto(Long idProducto);

}
