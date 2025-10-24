package com.sistemaBackend.SistemaTittaBackend.service;

import com.sistemaBackend.SistemaTittaBackend.model.Categoria;

import java.util.List;

public interface CategoriaService {

    Categoria crearCategoria(Categoria categoria);
    List<Categoria> obtenerTodosLasCategorias();

}
