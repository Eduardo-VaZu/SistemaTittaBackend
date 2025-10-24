package com.sistemaBackend.SistemaTittaBackend.service.impl;

import com.sistemaBackend.SistemaTittaBackend.dto.request.ProductoDTO;
import com.sistemaBackend.SistemaTittaBackend.dto.response.ProductoResponseDTO;
import com.sistemaBackend.SistemaTittaBackend.exception.ResourceNotFoundException;
import com.sistemaBackend.SistemaTittaBackend.mapper.Mapper;
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
    @Autowired
    private Mapper productoMapper;


    @Override
    public ProductoResponseDTO crearProducto(ProductoDTO productoDTO) {
        Producto producto = new Producto();
        producto.setNombreProducto(productoDTO.getNombreProducto());
        producto.setSku(productoDTO.getSku());
        producto.setDescripcion(productoDTO.getDescripcion());
        producto.setPrecio(productoDTO.getPrecio());
        producto.setEstadoProducto(productoDTO.isEstadoProducto());

        Categoria categoria = new Categoria();
        categoria.setIdCategoria(productoDTO.getIdCategoria());
        producto.setCategoria(categoria);

        ImagenProducto imagen = new ImagenProducto();
        imagen.setImagenUrl(productoDTO.getImagen().getImagenUrl());
        producto.setImagen(imagen);

        Producto guardarProducto = productoRepository.save(producto);

        return productoMapper.toProductoResponseDTO(guardarProducto);
    }

    @Override
    public List<ProductoResponseDTO> obtenerTodosLosProductos() {
        return productoRepository.findAll()
                .stream()
                .map(productoMapper::toProductoResponseDTO)
                .collect(Collectors.toList());
    }

    @Override
    public ProductoResponseDTO obtenerProductoPorId(Long idProducto) {
        productoRepository.findById(idProducto)
                .orElseThrow(() -> new ResourceNotFoundException("Producto no encontrado con id: " + idProducto));
        return productoMapper.toProductoResponseDTO(productoRepository.findById(idProducto).get());
    }

    @Override
    public ProductoResponseDTO actualizarProducto(Long idProducto, ProductoDTO productoDTO) {
        Producto producto = productoRepository.findById(idProducto)
                .orElseThrow(() -> new ResourceNotFoundException("Producto no encontrado con id: " + idProducto));

        producto.setNombreProducto(productoDTO.getNombreProducto());
        producto.setSku(productoDTO.getSku());
        producto.setDescripcion(productoDTO.getDescripcion());
        producto.setPrecio(productoDTO.getPrecio());
        producto.setEstadoProducto(productoDTO.isEstadoProducto());

        Categoria categoria = new Categoria();
        categoria.setIdCategoria(productoDTO.getIdCategoria());
        producto.setCategoria(categoria);

        ImagenProducto imagen = new ImagenProducto();
        imagen.setImagenUrl(productoDTO.getImagen().getImagenUrl());
        producto.setImagen(imagen);

        Producto guardarProducto = productoRepository.save(producto);

        return productoMapper.toProductoResponseDTO(guardarProducto);
    }

    @Override
    public void eliminarProducto(Long idProducto) {
        productoRepository.findById(idProducto)
                .orElseThrow(() -> new ResourceNotFoundException("Producto no encontrado con id: " + idProducto));
        productoRepository.deleteById(idProducto);
    }
}
