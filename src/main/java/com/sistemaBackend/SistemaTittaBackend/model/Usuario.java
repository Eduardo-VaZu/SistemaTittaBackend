package com.sistemaBackend.SistemaTittaBackend.model;

import java.sql.Date;
import java.util.List;

import org.hibernate.annotations.CreationTimestamp;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "tbl_usuario")
@Data
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_usuario")
    private Long idUsuario;

    @Column(name = "nombre", nullable = false, unique = true, length = 100)
    private String nombre;

    @Column(name = "apellido_paterno", nullable = false, unique = true, length = 100)
    private String apellidoPaterno;

    @Column(name = "apellido_materno", nullable = false, unique = true, length = 100)
    private String apellidoMaterno;

    @Column(name = "email", nullable = false, unique = true, length = 255)
    private String email;

    @CreationTimestamp
    @Column(name = "fecha_registro", nullable = false, updatable = false)
    private Date fechaRegistro;

    @Column(name = "estado_usuario", nullable = false, length = 5)
    private boolean estadoUsuario;

    @OneToMany(mappedBy = "usuario", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Rol> roles;
}
