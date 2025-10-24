package com.sistemaBackend.SistemaTittaBackend.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SedeDTO {
    private String nombreSede;
    private Long telefono;
    private Boolean estado;
    private DireccionDTO direccion;
    private List<HorarioOperacionSedeDTO> horariosOperacion;
}
