package com.sistemaBackend.SistemaTittaBackend.controller;

import com.sistemaBackend.SistemaTittaBackend.dto.request.ProductoDTO;
import com.sistemaBackend.SistemaTittaBackend.dto.response.ProductoResponseDTO;
import com.sistemaBackend.SistemaTittaBackend.model.Producto;
import com.sistemaBackend.SistemaTittaBackend.service.ProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/producto")
@CrossOrigin(origins = "*", methods = { RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE })
public class ProductoController {

    @Autowired
    private ProductoService productoService;

    @GetMapping
    public List<ProductoResponseDTO> obtenerTodosLosProductos() {
        return productoService.obtenerTodosLosProductos();
    }

    @GetMapping("/{idProducto}")
    private ResponseEntity<ProductoResponseDTO> obtenerProducto(@PathVariable Long idProducto) {
        ProductoResponseDTO producto = productoService.obtenerProductoPorId(idProducto);
        return ResponseEntity.ok(producto);
    }

    @PostMapping
    public ResponseEntity<ProductoResponseDTO> crearProducto(@RequestBody ProductoDTO producto) {
        ProductoResponseDTO nuevoProducto = productoService.crearProducto(producto);
        return new ResponseEntity<>(nuevoProducto, HttpStatus.CREATED);
    }

    @PutMapping("/{idProducto}")
    public ResponseEntity<ProductoResponseDTO> actualizarProducto(@PathVariable Long idProducto, @RequestBody ProductoDTO productoDetails) {
        ProductoResponseDTO productoActualizado = productoService.actualizarProducto(idProducto, productoDetails);
        return ResponseEntity.ok(productoActualizado);
    }

    @DeleteMapping("/{idProducto}")
    public ResponseEntity<Void> eliminarProducto(@PathVariable Long idProducto) {
        productoService.eliminarProducto(idProducto);
        return ResponseEntity.noContent().build();
    }

}
