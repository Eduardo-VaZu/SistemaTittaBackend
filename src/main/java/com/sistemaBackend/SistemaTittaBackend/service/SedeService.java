package com.sistemaBackend.SistemaTittaBackend.service;

import com.sistemaBackend.SistemaTittaBackend.model.Sede;

import java.util.List;

public interface SedeService {

    Sede crearSede(Sede sede);
    List<Sede> obtenerTodosLasSedes();

}
