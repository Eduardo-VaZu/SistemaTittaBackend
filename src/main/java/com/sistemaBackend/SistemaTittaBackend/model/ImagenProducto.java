package com.sistemaBackend.SistemaTittaBackend.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "tbl_imagen_producto")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ImagenProducto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_imagen")
    private Long idImagen;

    @Column(name = "url_imagen", nullable = false, unique = true, length = 200)
    private String urlImagen;

    @OneToOne(mappedBy = "imagen", fetch = FetchType.LAZY)
    @EqualsAndHashCode.Exclude
    private Producto producto;
}