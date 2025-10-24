package com.sistemaBackend.SistemaTittaBackend.service.impl;

import com.sistemaBackend.SistemaTittaBackend.dto.request.SedeDTO;
import com.sistemaBackend.SistemaTittaBackend.dto.response.SedeResponseDTO;
import com.sistemaBackend.SistemaTittaBackend.exception.ResourceNotFoundException;
import com.sistemaBackend.SistemaTittaBackend.mapper.Mapper;
import com.sistemaBackend.SistemaTittaBackend.model.Direccion;
import com.sistemaBackend.SistemaTittaBackend.model.HorarioOperacionSede;
import com.sistemaBackend.SistemaTittaBackend.model.Sede;
import com.sistemaBackend.SistemaTittaBackend.repository.SedeRepository;
import com.sistemaBackend.SistemaTittaBackend.service.SedeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.util.List;
import java.util.stream.Collectors;

@Service
public class SedeServiceImpl implements SedeService {

    @Autowired
    private SedeRepository sedeRepository;
    @Autowired
    private Mapper sedeMapper;

    @Override
    @Transactional
    public SedeResponseDTO crearSede(SedeDTO sedeDTO) {
        Sede sede = new Sede();
        sede.setNombreSede(sedeDTO.getNombreSede());
        sede.setTelefono(sedeDTO.getTelefono());
        sede.setEstado(sedeDTO.getEstado());

        Direccion direccion = new Direccion();
        direccion.setCalle(sedeDTO.getDireccion().getCalle());
        direccion.setNumeroExterior(sedeDTO.getDireccion().getNumeroExterior());
        direccion.setCodigoPostal(sedeDTO.getDireccion().getCodigoPostal());
        direccion.setCiudad(sedeDTO.getDireccion().getCiudad());
        direccion.setEstadoProvincial(sedeDTO.getDireccion().getEstadoProvincial());
        sede.setDireccion(direccion);

        if (sedeDTO.getHorariosOperacion() != null && !sedeDTO.getHorariosOperacion().isEmpty()) {
            sedeDTO.getHorariosOperacion().forEach(horarioDTO -> {
                HorarioOperacionSede horario = new HorarioOperacionSede();
                horario.setDiaSemana(horarioDTO.getDiaSemana());
                horario.setHoraApertura(horarioDTO.getHoraApertura());
                horario.setHoraCierre(horarioDTO.getHoraCierre());
                horario.setSede(sede); // Establecer la relación bidireccional
                sede.getHorariosOperacion().add(horario);
            });
        }

        Sede sedeGuardada = sedeRepository.save(sede);
        return sedeMapper.toSedeResponseDTO(sedeGuardada);
    }

    @Override
    public List<SedeResponseDTO> obtenerTodosLasSedes() {
        return sedeRepository.findAll()
                .stream()
                .map(sedeMapper::toSedeResponseDTO)
                .collect(Collectors.toList());
    }

    @Override
    public SedeResponseDTO obtenerSedePorId(Long id) {
        sedeRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Sede no encontrada con id: " + id));
        return sedeMapper.toSedeResponseDTO(sedeRepository.findById(id).get());
    }

    @Override
    @Transactional
    public SedeResponseDTO actualizarSede(Long id, SedeDTO sedeDTO) {
        Sede sede = sedeRepository.findById(id)
                        .orElseThrow(() -> new ResourceNotFoundException("Sede no encontrada con id: " + id));
        sede.setNombreSede(sedeDTO.getNombreSede());
        sede.setTelefono(sedeDTO.getTelefono());
        sede.setEstado(sedeDTO.getEstado());

        Direccion direccion = sede.getDireccion();
        direccion.setCalle(sedeDTO.getDireccion().getCalle());
        direccion.setNumeroExterior(sedeDTO.getDireccion().getNumeroExterior());
        direccion.setCodigoPostal(sedeDTO.getDireccion().getCodigoPostal());
        direccion.setCiudad(sedeDTO.getDireccion().getCiudad());
        direccion.setEstadoProvincial(sedeDTO.getDireccion().getEstadoProvincial());

        sede.getHorariosOperacion().clear();
        if (sedeDTO.getHorariosOperacion() != null && !sedeDTO.getHorariosOperacion().isEmpty()) {
            sedeDTO.getHorariosOperacion().forEach(horarioDTO -> {
                HorarioOperacionSede horario = new HorarioOperacionSede();
                horario.setDiaSemana(horarioDTO.getDiaSemana());
                horario.setHoraApertura(horarioDTO.getHoraApertura());
                horario.setHoraCierre(horarioDTO.getHoraCierre());
                horario.setSede(sede);
                sede.getHorariosOperacion().add(horario);
            });
        }
        Sede sedeGuardada = sedeRepository.save(sede);

        return sedeMapper.toSedeResponseDTO(sedeGuardada);
    }

    @Override
    public void eliminarSede(Long id) {
        Sede sede = sedeRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Sede no encontrada con id: " + id));
        sedeRepository.delete(sede);
    }

}
