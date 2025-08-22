package com.sistemaBackend.SistemaTittaBackend.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "tbl_imagen")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Imagen {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_imagen")
    private Long idImagen;

    @Column(name = "url_imagen", nullable = false, unique = true, length = 200)
    private String urlImagen;

    @OneToOne(mappedBy = "imagen", fetch = FetchType.LAZY)
    private Producto producto;
}