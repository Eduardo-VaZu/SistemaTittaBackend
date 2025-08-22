package com.sistemaBackend.SistemaTittaBackend.model;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;

@Embeddable
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ItemCarritoId implements Serializable {

    @Column(name = "id_carrito")
    private Long idCarrito;

    @Column(name = "id_producto")
    private Long idProducto;
}
