package com.sistemaBackend.SistemaTittaBackend.model;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;

@Embeddable
@Data
@NoArgsConstructor
@AllArgsConstructor
public class DetalleVentaId implements Serializable {

    @Column(name = "id_venta")
    private Long idVenta;

    @Column(name = "id_producto")
    private Long idProducto;
}