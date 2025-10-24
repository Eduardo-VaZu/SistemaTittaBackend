package com.sistemaBackend.SistemaTittaBackend.repository;

import com.sistemaBackend.SistemaTittaBackend.model.StockSede;
import com.sistemaBackend.SistemaTittaBackend.model.StockSedeId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StockSedeRepository extends JpaRepository<StockSede, StockSedeId> {
}
