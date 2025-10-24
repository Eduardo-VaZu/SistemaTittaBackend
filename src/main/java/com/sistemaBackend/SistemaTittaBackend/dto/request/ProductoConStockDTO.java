package com.sistemaBackend.SistemaTittaBackend.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductoConStockDTO {
    private String nombreProducto;
    private String sku;
    private String descripcion;
    private BigDecimal precio;
    private boolean estadoProducto;
    private Long idCategoria;
    private String imagenUrl;
    private List<StockDTO> stocks;

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class StockDTO {
        private Long idSede;
        private int cantidad;
    }
}