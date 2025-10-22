package com.sistemaBackend.SistemaTittaBackend.repository;

import com.sistemaBackend.SistemaTittaBackend.model.Rol;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RolRepository extends JpaRepository<Rol, Long> {

    Optional<Rol> findRolByNombre(String nombre);

}
