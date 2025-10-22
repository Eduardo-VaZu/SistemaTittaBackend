package com.sistemaBackend.SistemaTittaBackend.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "tbl_credencial_tradicional")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CredencialTradicional {

    @Id
    @Column(name = "id_usuario")
    private Long idUsuario;

    @OneToOne
    @MapsId
    @EqualsAndHashCode.Exclude
    private Usuario usuario;

    @Column(name = "password_hash", nullable = false)
    private String passwordHash;
}
