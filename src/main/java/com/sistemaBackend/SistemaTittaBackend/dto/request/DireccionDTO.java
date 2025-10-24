package com.sistemaBackend.SistemaTittaBackend.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DireccionDTO {
    private String calle;
    private String numeroExterior;
    private String codigoPostal;
    private String ciudad;
    private String estadoProvincial;
}
