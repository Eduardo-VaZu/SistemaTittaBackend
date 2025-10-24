package com.sistemaBackend.SistemaTittaBackend.service.impl;

import com.sistemaBackend.SistemaTittaBackend.model.Sede;
import com.sistemaBackend.SistemaTittaBackend.repository.SedeRepository;
import com.sistemaBackend.SistemaTittaBackend.service.SedeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SedeServiceImpl implements SedeService {

    @Autowired
    private SedeRepository sedeRepository;

    @Override
    public Sede crearSede(Sede sede) {
        Sede sedeLocal = sedeRepository.findSedeByNombreSede(sede.getNombreSede());
        return sedeRepository.save(sede);
    }

    @Override
    public List<Sede> obtenerTodosLasSedes() {
        return sedeRepository.findAll();
    }
}
