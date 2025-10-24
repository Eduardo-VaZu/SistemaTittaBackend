package com.sistemaBackend.SistemaTittaBackend.mapper;

import com.sistemaBackend.SistemaTittaBackend.dto.response.DireccionResponseDTO;
import com.sistemaBackend.SistemaTittaBackend.dto.response.HorarioOperacionSedeResponseDTO;
import com.sistemaBackend.SistemaTittaBackend.dto.response.SedeResponseDTO;
import com.sistemaBackend.SistemaTittaBackend.model.Direccion;
import com.sistemaBackend.SistemaTittaBackend.model.HorarioOperacionSede;
import com.sistemaBackend.SistemaTittaBackend.model.Sede;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

@Component
public class SedeMapper {

    public SedeResponseDTO toSedeResponseDTO(Sede sede) {
        if (sede == null) {
            return null;
        }

        SedeResponseDTO dto = new SedeResponseDTO();
        dto.setIdSede(sede.getIdSede());
        dto.setNombreSede(sede.getNombreSede());
        dto.setTelefono(sede.getTelefono());
        dto.setEstado(sede.getEstado());
        dto.setDireccion(toDireccionResponseDTO(sede.getDireccion()));
        dto.setHorariosOperacion(sede.getHorariosOperacion().stream()
                .map(this::toHorarioResponseDTO)
                .collect(Collectors.toList()));

        return dto;
    }

    private DireccionResponseDTO toDireccionResponseDTO(Direccion direccion) {
        if (direccion == null) {
            return null;
        }
        DireccionResponseDTO dto = new DireccionResponseDTO();
        dto.setIdDireccion(direccion.getIdDireccion());
        dto.setCalle(direccion.getCalle());
        dto.setNumeroExterior(direccion.getNumeroExterior());
        dto.setCodigoPostal(direccion.getCodigoPostal());
        dto.setCiudad(direccion.getCiudad());
        dto.setEstadoProvincial(direccion.getEstadoProvincial());
        return dto;
    }

    private HorarioOperacionSedeResponseDTO toHorarioResponseDTO(HorarioOperacionSede horario) {
        if (horario == null) {
            return null;
        }
        HorarioOperacionSedeResponseDTO dto = new HorarioOperacionSedeResponseDTO();
        dto.setIdHorarioOperacionSede(horario.getIdHorarioOperacionSede());
        dto.setDiaSemana(horario.getDiaSemana());
        dto.setHoraApertura(horario.getHoraApertura());
        dto.setHoraCierre(horario.getHoraCierre());
        return dto;
    }


}