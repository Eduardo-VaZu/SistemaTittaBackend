package com.sistemaBackend.SistemaTittaBackend.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "tbl_producto")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Producto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_producto")
    private Long idProducto;

    @Column(name = "nombre_producto", nullable = false, unique = true, length = 100)
    private String nombreProducto;

    @Column(name = "sku", nullable = false, length = 50)
    private String sku;

    @Column(name = "descripcion", columnDefinition = "TEXT")
    private String descripcion;

    @Column(name = "precio", nullable = false, precision = 10, scale = 2)
    private BigDecimal precio;

    @Column(name = "estado_producto", nullable = false, length = 5)
    private boolean estadoProducto;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_categoria", nullable = false)
    private Categoria categoria;

    @OneToOne(mappedBy = "producto", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "id_imagen", referencedColumnName = "id_imagen")
    @EqualsAndHashCode.Exclude
    private Imagen imagen;

    @OneToMany(mappedBy = "producto", cascade = CascadeType.ALL)
    @EqualsAndHashCode.Exclude
    private Set<StockSede> stocks= new HashSet<>();
}