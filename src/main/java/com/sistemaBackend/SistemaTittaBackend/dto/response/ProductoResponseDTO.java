package com.sistemaBackend.SistemaTittaBackend.dto.response;

import lombok.Data;
import java.math.BigDecimal;
import java.util.List;

@Data
public class ProductoResponseDTO {
    private Long idProducto;
    private String nombreProducto;
    private String sku;
    private String descripcion;
    private BigDecimal precio;
    private boolean estadoProducto;
    private Long idCategoria; // O puedes anidar un CategoriaDTO si lo prefieres
    private ImagenProductoResponseDTO imagen;
    private List<StockSedeResponseDTO> stocks;
}
