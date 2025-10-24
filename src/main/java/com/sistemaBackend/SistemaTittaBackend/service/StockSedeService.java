package com.sistemaBackend.SistemaTittaBackend.service;

import com.sistemaBackend.SistemaTittaBackend.dto.response.StockSedeResponseDTO;

public interface StockSedeService {
    StockSedeResponseDTO actualizarStock(Long idProducto, Long idSede, int cantidad);
}
