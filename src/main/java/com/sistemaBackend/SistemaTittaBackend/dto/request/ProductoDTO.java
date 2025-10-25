package com.sistemaBackend.SistemaTittaBackend.dto.request;

import lombok.Data;
import java.math.BigDecimal;
import java.util.List;

@Data
public class ProductoDTO {
    private String nombreProducto;
    private String sku;
    private String descripcion;
    private BigDecimal precio;
    private boolean estadoProducto;
    private CategoriaDTO categoria;
    private ImagenProductoDTO imagen;
    private List<StockSedeDTO> stocks;
}
