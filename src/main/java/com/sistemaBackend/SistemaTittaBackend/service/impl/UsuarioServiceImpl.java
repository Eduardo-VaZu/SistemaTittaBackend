package com.sistemaBackend.SistemaTittaBackend.service.impl;

import com.sistemaBackend.SistemaTittaBackend.model.Usuario;
import com.sistemaBackend.SistemaTittaBackend.repository.UsuarioRepository;
import com.sistemaBackend.SistemaTittaBackend.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioServiceImpl implements UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Override
    public Usuario crearUsuario(Usuario usuario) {
        usuarioRepository.findUsuarioByEmail(usuario.getEmail()).ifPresent(u -> {
            throw new RuntimeException("Email ya existe");
        });
        return usuarioRepository.save(usuario);
    }

    @Override
    public List<Usuario> obtenerTodosLosUsuarios() {
        return usuarioRepository.findAll();
    }

    @Override
    public Usuario obtenerUsuarioPorEmail(String email) {
        return usuarioRepository.findUsuarioByEmail(email)
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));
    }

    @Override
    public Usuario actualizarUsuario(Long idUsuario, Usuario usuarioDetails) {
        Usuario usuario = usuarioRepository.findUsuarioByIdUsuario(idUsuario)
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));
        usuario.setNombre(usuarioDetails.getNombre());
        usuario.setApellidoPaterno(usuarioDetails.getApellidoPaterno());
        usuario.setApellidoMaterno(usuarioDetails.getApellidoMaterno());
        usuario.setEmail(usuarioDetails.getEmail());
        return usuarioRepository.save(usuario);
    }

    @Override
    public void eliminarUsuario(Long idUsuario) {
        Usuario usuario = usuarioRepository.findUsuarioByIdUsuario(idUsuario)
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));
        usuarioRepository.delete(usuario);
    }
}
