package com.sistemaBackend.SistemaTittaBackend.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductoDTO {
    private String nombreProducto;
    private String sku;
    private String descripcion;
    private Double precio;
    private String imagen;
    private String idCategoria;
}
