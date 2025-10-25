package com.sistemaBackend.SistemaTittaBackend.service.impl;

import com.sistemaBackend.SistemaTittaBackend.dto.request.CategoriaDTO;
import com.sistemaBackend.SistemaTittaBackend.dto.response.CategoriaResponseDTO;
import com.sistemaBackend.SistemaTittaBackend.mapper.Mapper;
import com.sistemaBackend.SistemaTittaBackend.model.Categoria;
import com.sistemaBackend.SistemaTittaBackend.repository.CategoriaRepository;
import com.sistemaBackend.SistemaTittaBackend.service.CategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CategoriaServiceImpl implements CategoriaService {

    @Autowired
    private CategoriaRepository categoriaRepository;

    @Autowired
    private Mapper mapper;


    @Override
    public CategoriaResponseDTO crearCategoria(CategoriaDTO categoriaDTO) {
        Categoria nuevaCategoria = new Categoria();
        nuevaCategoria.setNombreCategoria(categoriaDTO.getNombreCategoria());

        Categoria categoriaGuardada = categoriaRepository.save(nuevaCategoria);
        return mapper.toCategoriaResponseDTO(categoriaGuardada);
    }

    @Override
    public List<CategoriaResponseDTO> obtenerTodosLasCategorias() {
        return categoriaRepository.findAll()
                .stream()
                .map(mapper::toCategoriaResponseDTO)
                .collect(Collectors.toList());
    }

}
