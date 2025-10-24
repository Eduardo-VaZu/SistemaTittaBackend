package com.sistemaBackend.SistemaTittaBackend.repository;

import com.sistemaBackend.SistemaTittaBackend.model.Sede;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SedeRepository extends JpaRepository<Sede, Long> {
    Sede findSedeByNombreSede(String nombreSede);
}
