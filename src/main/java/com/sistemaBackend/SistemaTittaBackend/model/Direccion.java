package com.sistemaBackend.SistemaTittaBackend.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "tbl_direccion")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Direccion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_direccion")
    private Long idDireccion;

    @Column(name = "calle")
    private String calle;

    @Column(name = "numero_exterior")
    private String numeroExterior;

    @Column(name = "codigo_postal")
    private String codigoPostal;

    @Column(name = "ciudad")
    private String ciudad;

    @Column(name = "estado_provincial")
    private String estadoProvincial;
}
