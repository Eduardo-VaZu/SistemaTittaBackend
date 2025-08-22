package com.sistemaBackend.SistemaTittaBackend.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "tbl_imagen")
@Data
public class Imagen {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_imagen")
    private int idImagen;

    @Column(name = "url_imagen", nullable = false, unique = true, length = 200)
    private String urlImagen;

    @OneToOne(mappedBy = "imagen", fetch = FetchType.LAZY)
    private Producto producto;
}