package com.sistemaBackend.SistemaTittaBackend.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "tbl_estado_venta")
@Data
public class EstadoVenta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_estado_venta")
    private int idEstadoVenta;

    @Column(name = "nombre_estado", nullable = false, unique = true, length = 50)
    private String nombreEstado;
}