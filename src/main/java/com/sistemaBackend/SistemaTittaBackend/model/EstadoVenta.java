package com.sistemaBackend.SistemaTittaBackend.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "tbl_estado_ventas")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class EstadoVenta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_estado_venta")
    private Long idEstadoVenta;

    @Column(name = "nombre_estado", nullable = false, unique = true, length = 50)
    private String nombreEstado;
}