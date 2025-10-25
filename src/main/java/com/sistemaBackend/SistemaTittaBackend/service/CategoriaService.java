package com.sistemaBackend.SistemaTittaBackend.service;

import com.sistemaBackend.SistemaTittaBackend.dto.request.CategoriaDTO;
import com.sistemaBackend.SistemaTittaBackend.dto.response.CategoriaResponseDTO;
import com.sistemaBackend.SistemaTittaBackend.model.Categoria;

import java.util.List;

public interface CategoriaService {

    CategoriaResponseDTO crearCategoria(CategoriaDTO categoria);
    List<CategoriaResponseDTO> obtenerTodosLasCategorias();

}
