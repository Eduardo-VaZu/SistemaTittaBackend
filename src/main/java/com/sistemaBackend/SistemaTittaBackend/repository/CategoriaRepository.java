package com.sistemaBackend.SistemaTittaBackend.repository;

import com.sistemaBackend.SistemaTittaBackend.model.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoriaRepository extends JpaRepository<Categoria, Long> {}