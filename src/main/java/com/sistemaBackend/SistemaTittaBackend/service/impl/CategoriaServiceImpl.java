package com.sistemaBackend.SistemaTittaBackend.service.impl;

import com.sistemaBackend.SistemaTittaBackend.model.Categoria;
import com.sistemaBackend.SistemaTittaBackend.repository.CategoriaRepository;
import com.sistemaBackend.SistemaTittaBackend.service.CategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoriaServiceImpl implements CategoriaService {

    @Autowired
    private CategoriaRepository categoriaRepository;


    @Override
    public Categoria crearCategoria(Categoria categoria) {
        Categoria categori = categoriaRepository.findCategoriaByNombreCategoria(categoria.getNombreCategoria());
        return categoriaRepository.save(categoria);
    }

    @Override
    public List<Categoria> obtenerTodosLasCategorias() {
        return categoriaRepository.findAll();
    }

    @Override
    public Categoria obtenerCategoriaPorId(Long idCategoria) {
        return null;
    }

    @Override
    public Categoria actualizarCategoria(Long idCategoria, Categoria categoriaDetails) {
        return null;
    }

    @Override
    public void eliminarCategoria(Long idCategoria) {

    }
}
