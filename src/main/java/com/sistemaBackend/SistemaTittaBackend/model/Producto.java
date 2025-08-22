package com.sistemaBackend.SistemaTittaBackend.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "tbl_producto")
@Data
public class Producto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_producto")
    private int idProducto;

    @Column(name = "nombre_producto", nullable = false, unique = true, length = 100)
    private String nombreProducto;

    @Column(name = "sku", nullable = false, length = 50)
    private String sku;

    @Column(name = "descripcion", length = 500)
    private String descripcion;

    @Column(name = "precio", nullable = false)
    private double precio;

    @Column(name = "estado_producto", nullable = false, length = 5)
    private boolean estadoProducto;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_categoria", nullable = false)
    private Categoria categoria;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "id_imagen", referencedColumnName = "id_imagen")
    private Imagen imagen;
}