package com.sistemaBackend.SistemaTittaBackend.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class HorarioOperacionSedeDTO {
    private String diaSemana;
    private LocalTime horaApertura;
    private LocalTime horaCierre;
}