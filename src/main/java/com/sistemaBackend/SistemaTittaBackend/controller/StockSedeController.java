package com.sistemaBackend.SistemaTittaBackend.controller;

import com.sistemaBackend.SistemaTittaBackend.dto.request.StockSedeDTO;
import com.sistemaBackend.SistemaTittaBackend.dto.response.StockSedeResponseDTO;
import com.sistemaBackend.SistemaTittaBackend.service.StockSedeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/stock")
public class StockSedeController {

    @Autowired
    private StockSedeService stockSedeService;

    @PutMapping("/producto/{idProducto}/sede/{idSede}")
    public ResponseEntity<StockSedeResponseDTO> actualizarStock(
            @PathVariable Long idProducto,
            @PathVariable Long idSede,
            @RequestBody StockSedeDTO stockDTO) {
        StockSedeResponseDTO stockActualizado = stockSedeService.actualizarStock(idProducto, idSede, stockDTO.getCantidad());
        return ResponseEntity.ok(stockActualizado);
    }
}
