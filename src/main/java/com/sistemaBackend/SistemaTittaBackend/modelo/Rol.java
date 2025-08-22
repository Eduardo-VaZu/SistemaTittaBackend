package com.sistemaBackend.SistemaTittaBackend.modelo;

import com.sistemaBackend.SistemaTittaBackend.modelo.enums.RolEnum;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "tbl_rol")
@Data
public class Rol {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_rol")
    private int idRol;

    @Column(name = "nombre_rol", nullable = false, unique = true, length = 50)
    private RolEnum nombreRol;

    @ManyToOne
    @JoinColumn(name = "id_usuario")
    private Usuario usuario;
}
