package com.sistemaBackend.SistemaTittaBackend.dto.response;

import lombok.Data;
import java.time.LocalTime;

@Data
public class HorarioOperacionSedeResponseDTO {
    private Long idHorarioOperacionSede;
    private String diaSemana;
    private LocalTime horaApertura;
    private LocalTime horaCierre;
}
