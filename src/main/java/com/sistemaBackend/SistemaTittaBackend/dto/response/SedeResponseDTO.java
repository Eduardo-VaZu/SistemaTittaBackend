package com.sistemaBackend.SistemaTittaBackend.dto.response;

import lombok.Data;
import java.util.List;

@Data
public class SedeResponseDTO {
    private Long idSede;
    private String nombreSede;
    private Long telefono;
    private Boolean estado;
    private DireccionResponseDTO direccion;
    private List<HorarioOperacionSedeResponseDTO> horariosOperacion;
}
