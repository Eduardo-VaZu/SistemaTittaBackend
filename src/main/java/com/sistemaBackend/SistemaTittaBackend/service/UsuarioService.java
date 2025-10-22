package com.sistemaBackend.SistemaTittaBackend.service;

import com.sistemaBackend.SistemaTittaBackend.model.Usuario;

import java.util.List;

public interface UsuarioService {

    Usuario crearUsuario(Usuario usuario);
    List<Usuario> obtenerTodosLosUsuarios();
    Usuario obtenerUsuarioPorEmail(String email);
    Usuario actualizarUsuario(Long idUsuario, Usuario usuarioDetails);
    void eliminarUsuario(Long idUsuario);

}
