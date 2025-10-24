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

    @PostMapping
    private ResponseEntity<Categoria> crearCategoria(@RequestBody Categoria categoria){
        Categoria categoriaCreada = categoriaService.crearCategoria(categoria);
        return new ResponseEntity<>(categoriaCreada, HttpStatus.CREATED);
    }
}
