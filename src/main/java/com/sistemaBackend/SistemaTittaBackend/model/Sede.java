package com.sistemaBackend.SistemaTittaBackend.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.math.BigInteger;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "tbl_sedes")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Sede {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_sede")
    private Long idSede;

    @Column(name = "nombre_sede", nullable = false, unique = true, length = 100)
    private String nombreSede;

    @Column(name = "telefono", nullable = false, unique = true, length = 9)
    private BigInteger telefono;

    @Column(name = "estado", nullable = false, length = 5)
    private Boolean estado;

    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "id_direccion", referencedColumnName = "id_direccion", nullable = false)
    private Direccion direccion;

    @EqualsAndHashCode.Exclude
    @OneToMany(mappedBy = "sede", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<HorarioOperacionSede> horariosOperacion = new HashSet<>();

    @EqualsAndHashCode.Exclude
    @OneToMany(mappedBy = "sede", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<StockSede> stocks = new HashSet<>();

    @EqualsAndHashCode.Exclude
    @OneToMany(mappedBy = "sede", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<UsuarioSede> usuariosSedes = new HashSet<>();

}
