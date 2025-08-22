package com.sistemaBackend.SistemaTittaBackend.model;

import java.sql.Date;
import org.hibernate.annotations.CreationTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "tbl_venta")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Venta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_venta")
    private Long idVenta;

    @CreationTimestamp
    @Column(name = "fecha_venta", nullable = false, updatable = false)
    private Date fechaVenta;

    @Column(name = "total_venta", nullable = false)
    private double totalVenta;

    @ManyToOne
    @JoinColumn(name = "id_usuario")
    private Usuario usuario;
}