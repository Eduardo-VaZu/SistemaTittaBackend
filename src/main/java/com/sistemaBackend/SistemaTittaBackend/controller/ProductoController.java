package com.sistemaBackend.SistemaTittaBackend.controller;

import com.sistemaBackend.SistemaTittaBackend.dto.request.ProductoConStockDTO;
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
    public List<Producto> obtenerTodosLosProductos() {
        return productoService.obtenerTodosLosProductos();
    }

    @GetMapping("/{idProducto}")
    private ResponseEntity<Producto> obtenerProducto(@PathVariable Long idProducto) {
        Producto producto = productoService.obtenerProductoPorId(idProducto);
        return ResponseEntity.ok(producto);
    }

    @PostMapping
    public ResponseEntity<Producto> crearProducto(@RequestBody Producto producto) {
        Producto nuevoProducto = productoService.crearProducto(producto);
        return new ResponseEntity<>(nuevoProducto, HttpStatus.CREATED);
    }

    @PutMapping("/{idProducto}")
    public ResponseEntity<Producto> actualizarProducto(@PathVariable Long idProducto, @RequestBody Producto productoDetails) {
        Producto productoActualizado = productoService.actualizarProducto(idProducto, productoDetails);
        return ResponseEntity.ok(productoActualizado);
    }

    @PatchMapping("/{idProducto}/categoria")
    public ResponseEntity<Producto> actualizarCategoriaProducto(@PathVariable Long idProducto, @RequestBody Long idCategoria) {
        Producto productoActualizado = productoService.actualizarCategoriaDeProducto(idProducto, idCategoria);
        return ResponseEntity.ok(productoActualizado);
    }

    @DeleteMapping("/{idProducto}")
    public ResponseEntity<Void> eliminarProducto(@PathVariable Long idProducto) {
        productoService.eliminarProducto(idProducto);
        return ResponseEntity.noContent().build();
    }

    @PostMapping("/lote")
    public ResponseEntity<List<Producto>> crearProductos(@RequestBody List<ProductoConStockDTO> productosDTO) {
        List<Producto> nuevosProductos = productoService.crearProductos(productosDTO);
        return new ResponseEntity<>(nuevosProductos, HttpStatus.CREATED);
    }
}
