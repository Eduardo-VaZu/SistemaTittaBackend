package com.sistemaBackend.SistemaTittaBackend.service.impl;

import com.sistemaBackend.SistemaTittaBackend.dto.response.StockSedeResponseDTO;
import com.sistemaBackend.SistemaTittaBackend.exception.ResourceNotFoundException;
import com.sistemaBackend.SistemaTittaBackend.mapper.Mapper;
import com.sistemaBackend.SistemaTittaBackend.model.StockSede;
import com.sistemaBackend.SistemaTittaBackend.model.StockSedeId;
import com.sistemaBackend.SistemaTittaBackend.repository.ProductoRepository;
import com.sistemaBackend.SistemaTittaBackend.repository.SedeRepository;
import com.sistemaBackend.SistemaTittaBackend.repository.StockSedeRepository;
import com.sistemaBackend.SistemaTittaBackend.service.StockSedeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StockSedeServiceImpl implements StockSedeService {

    @Autowired
    private StockSedeRepository stockSedeRepository;
    @Autowired
    private ProductoRepository productoRepository;
    @Autowired
    private SedeRepository sedeRepository;

    @Autowired
    private Mapper productoMapper;

    @Override
    public StockSedeResponseDTO actualizarStock(Long idProducto, Long idSede, int cantidad) {
        StockSedeId stockSedeId = new StockSedeId(idProducto, idSede);
        StockSede stock = stockSedeRepository.findById(stockSedeId)
                .orElseThrow(() -> new ResourceNotFoundException("No se encontró stock para el producto " + idProducto + " en la sede " + idSede));

        stock.setCantidad(cantidad);
        StockSede stockActualizado = stockSedeRepository.save(stock);
        return productoMapper.toStockSedeResponseDTO(stockActualizado);
    }
}