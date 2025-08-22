package com.sistemaBackend.SistemaTittaBackend.model;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Embeddable
@Data
@NoArgsConstructor
@AllArgsConstructor
public class StockSedeId implements Serializable {

    @Column(name = "id_producto")
    private Long idProducto;

    @Column(name = "id_sede")
    private Long idSede;
}
