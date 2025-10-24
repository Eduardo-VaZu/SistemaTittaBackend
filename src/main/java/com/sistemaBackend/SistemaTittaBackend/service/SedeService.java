package com.sistemaBackend.SistemaTittaBackend.service;

import com.sistemaBackend.SistemaTittaBackend.dto.request.SedeDTO;
import com.sistemaBackend.SistemaTittaBackend.dto.response.SedeResponseDTO;
import com.sistemaBackend.SistemaTittaBackend.model.Sede;

import java.util.List;

public interface SedeService {

    Sede crearSede(SedeDTO sedeDTO);
    List<Sede> obtenerTodosLasSedes();
    Sede obtenerSedePorId(Long id);
    Sede actualizarSede(Long id, SedeDTO sedeDTO);
    void eliminarSede(Long id);
    List<SedeResponseDTO> obtenerTodasLasSedes();
    SedeResponseDTO obtenerSedePorIdResponse(Long id);
}
