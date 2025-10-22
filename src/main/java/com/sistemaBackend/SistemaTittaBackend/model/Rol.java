package com.sistemaBackend.SistemaTittaBackend.model;

import com.sistemaBackend.SistemaTittaBackend.model.enums.RolEnum;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "tbl_rol")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Rol {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_rol")
    private Long idRol;

    @Enumerated(EnumType.STRING)
    @Column(name = "nombre_rol", nullable = false, unique = true, length = 50)
    private RolEnum nombreRol;

}
