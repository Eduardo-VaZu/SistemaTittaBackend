package com.sistemaBackend.SistemaTittaBackend.service.impl;

import com.sistemaBackend.SistemaTittaBackend.exception.ResourceNotFoundException;
import com.sistemaBackend.SistemaTittaBackend.model.*;
import com.sistemaBackend.SistemaTittaBackend.repository.CategoriaRepository;
import com.sistemaBackend.SistemaTittaBackend.repository.ProductoRepository;
import com.sistemaBackend.SistemaTittaBackend.repository.SedeRepository;
import com.sistemaBackend.SistemaTittaBackend.service.ProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class ProductoServiceImpl implements ProductoService {

    @Autowired
    private ProductoRepository productoRepository;
    @Autowired
    private CategoriaRepository categoriaRepository;
    @Autowired
    private SedeRepository sedeRepository;

    @Override
    @Transactional
    public Producto crearProducto(Producto producto) {
        productoRepository.findBySku(producto.getSku()).ifPresent(p -> {
            throw new RuntimeException("SKU ya existe");
        });

        if (producto.getImagen() != null) {
            producto.getImagen().setProducto(producto);
        }

        if (producto.getStocks() != null) {
            producto.getStocks().forEach(stock -> stock.setProducto(producto));
        }

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
    public Producto actualizarCategoriaDeProducto(Long idProducto, Long idCategoria) {
        Producto producto = obtenerProductoPorId(idProducto);
        Categoria nuevaCategoria = categoriaRepository.findById(idCategoria)
                .orElseThrow(() -> new RuntimeException("Categoría no encontrada"));
        producto.setCategoria(nuevaCategoria);
        return productoRepository.save(producto);
    }

    @Override
    public void eliminarProducto(Long idProducto) {
        Producto producto = obtenerProductoPorId(idProducto);
        productoRepository.delete(producto);
    }
}
