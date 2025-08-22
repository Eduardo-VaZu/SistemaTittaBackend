package com.sistemaBackend.SistemaTittaBackend.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "tbl_metodo_pago")
@Data
public class MetodoPago {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_metodo_pago")
    private int idMetodoPago;

    @Column(name = "nombre_metodo", nullable = false, unique = true, length = 50)
    private String nombreMetodo;
}