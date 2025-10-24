package com.sistemaBackend.SistemaTittaBackend.dto.response;

import lombok.Data;

@Data
public class StockSedeResponseDTO {
    private Long idSede;
    private String nombreSede;
    private int cantidad;
}