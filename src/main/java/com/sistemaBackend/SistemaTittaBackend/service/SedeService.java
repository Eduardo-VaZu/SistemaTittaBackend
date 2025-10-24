package com.sistemaBackend.SistemaTittaBackend.service;

import com.sistemaBackend.SistemaTittaBackend.dto.request.SedeDTO;
import com.sistemaBackend.SistemaTittaBackend.dto.response.SedeResponseDTO;
import com.sistemaBackend.SistemaTittaBackend.model.Sede;

import java.util.List;

public interface SedeService {

    SedeResponseDTO crearSede(SedeDTO sedeDTO);
    List<SedeResponseDTO> obtenerTodosLasSedes();
    SedeResponseDTO obtenerSedePorId(Long id);
    SedeResponseDTO actualizarSede(Long id, SedeDTO sedeDTO);
    void eliminarSede(Long id);

}
