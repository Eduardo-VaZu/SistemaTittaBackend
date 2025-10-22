package com.sistemaBackend.SistemaTittaBackend.service.impl;

import com.sistemaBackend.SistemaTittaBackend.model.Producto;
import com.sistemaBackend.SistemaTittaBackend.repository.ProductoRepository;
import com.sistemaBackend.SistemaTittaBackend.service.ProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductoServiceImpl implements ProductoService {

    @Autowired
    private ProductoRepository productoRepository;

    @Override
    public Producto crearProducto(Producto producto) {
        productoRepository.findBySku(producto.getSku()).ifPresent(p -> {
            throw new RuntimeException("SKU ya existe");
        });
        return productoRepository.save(producto);
    }

    @Override
    public List<Producto> obtenerTodosLosProductos() {
        return productoRepository.findAll();
    }

    @Override
    public Producto obtenerProductoPorId(Long idProducto) {
        return productoRepository.findById(idProducto)
                .orElseThrow(() -> new RuntimeException("Producto no encontrado"));
    }

    @Override
    public Producto actualizarProducto(Long idProducto, Producto productoDetails) {
        Producto producto = obtenerProductoPorId(idProducto);

        producto.setNombreProducto(productoDetails.getNombreProducto());
        producto.setDescripcion(productoDetails.getDescripcion());
        producto.setPrecio(productoDetails.getPrecio());
        producto.setEstadoProducto(productoDetails.isEstadoProducto());

        return productoRepository.save(producto);
    }

    @Override
    public void eliminarProducto(Long idProducto) {
        Producto producto = obtenerProductoPorId(idProducto);
        productoRepository.delete(producto);
    }
}
