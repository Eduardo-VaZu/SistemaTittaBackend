package com.sistemaBackend.SistemaTittaBackend.dto.response;

import lombok.Data;

@Data
public class DireccionResponseDTO {
    private Long idDireccion;
    private String calle;
    private String numeroExterior;
    private String codigoPostal;
    private String ciudad;
    private String estadoProvincial;
}