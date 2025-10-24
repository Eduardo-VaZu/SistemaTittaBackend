package com.sistemaBackend.SistemaTittaBackend.controller;

import com.sistemaBackend.SistemaTittaBackend.model.Sede;
import com.sistemaBackend.SistemaTittaBackend.service.SedeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/sede")
public class SedeController {
    @Autowired
    private SedeService sedeService;

    @GetMapping
    public List<Sede> obtenerTodosLasSedes(){
        return sedeService.obtenerTodosLasSedes();
    }

    @PostMapping
    public ResponseEntity<Sede> crearSede(@RequestBody Sede sede){
        Sede sedeCreada = sedeService.crearSede(sede);
        return new ResponseEntity<>(sedeCreada, HttpStatus.CREATED);
    }


}
