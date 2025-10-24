package com.sistemaBackend.SistemaTittaBackend.controller;

import com.sistemaBackend.SistemaTittaBackend.dto.request.SedeDTO;
import com.sistemaBackend.SistemaTittaBackend.dto.response.SedeResponseDTO;
import com.sistemaBackend.SistemaTittaBackend.model.Sede;
import com.sistemaBackend.SistemaTittaBackend.service.SedeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/sedes")
public class SedeController {

    @Autowired
    private SedeService sedeService;

    @GetMapping
    public List<SedeResponseDTO> obtenerTodasLasSedes() {
        return sedeService.obtenerTodosLasSedes();
    }

    @GetMapping("/{id}")
    public ResponseEntity<SedeResponseDTO> obtenerSedePorId(@PathVariable Long id) {
        SedeResponseDTO sede = sedeService.obtenerSedePorId(id);
        return ResponseEntity.ok(sede);
    }

    @PostMapping
    public ResponseEntity<SedeResponseDTO> crearSede(@RequestBody SedeDTO sedeDTO) {
        SedeResponseDTO sedeCreada = sedeService.crearSede(sedeDTO);
        return new ResponseEntity<>(sedeCreada, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<SedeResponseDTO> actualizarSede(@PathVariable Long id, @RequestBody SedeDTO sedeDTO) {
        SedeResponseDTO sedeActualizada = sedeService.actualizarSede(id, sedeDTO);
        return ResponseEntity.ok(sedeActualizada);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarSede(@PathVariable Long id) {
        sedeService.eliminarSede(id);
        return ResponseEntity.noContent().build();
    }
}
