package com.sistemaBackend.SistemaTittaBackend.controller;

import com.sistemaBackend.SistemaTittaBackend.model.Categoria;
import com.sistemaBackend.SistemaTittaBackend.service.CategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/categoria")
public class CategoriaController {

    @Autowired
    private CategoriaService categoriaService;

    @GetMapping
    public List<Categoria> obtenerTodoslosProductos(){
        return categoriaService.obtenerTodosLasCategorias();
    }

    @GetMapping("/{idCategoria}")
    private ResponseEntity<Categoria> obtenerCategoriaPorId(@PathVariable Long idCategoria){
        Categoria categoria = categoriaService.obtenerCategoriaPorId(idCategoria);
        return ResponseEntity.ok(categoria);
    }

    @PostMapping
    private ResponseEntity<Categoria> crearCategoria(@RequestBody Categoria categoria){
        Categoria categori = categoriaService.crearCategoria(categoria);
        return new ResponseEntity<>(categori, HttpStatus.CREATED);
    }
}
