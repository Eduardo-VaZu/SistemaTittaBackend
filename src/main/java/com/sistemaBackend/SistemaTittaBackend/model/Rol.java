package com.sistemaBackend.SistemaTittaBackend.model;

import com.sistemaBackend.SistemaTittaBackend.model.enums.RolEnum;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "tbl_rol")
@Data
public class Rol {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_rol")
    private Long idRol;

    @Column(name = "nombre_rol", nullable = false, unique = true, length = 50)
    private RolEnum nombreRol;

    @ManyToOne
    @JoinColumn(name = "id_usuario")
    private Usuario usuario;
}
