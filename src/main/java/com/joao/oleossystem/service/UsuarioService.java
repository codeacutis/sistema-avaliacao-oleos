package com.joao.oleossystem.service;

import org.springframework.stereotype.Service;

import com.joao.oleossystem.model.Usuario;
import com.joao.oleossystem.repository.UsuarioRepository;

@Service
public class UsuarioService {

    private final UsuarioRepository usuarioRepository;

    public UsuarioService(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    public void salvarUsuario(Usuario usuario){
        usuarioRepository.saveAndFlush(usuario);
    }

    public Usuario buscarUsuarioPorEmail(String email){
        return usuarioRepository.findByEmail(email).orElseThrow(
            ()-> new RuntimeException("Email não encontrado")
        );
    }

    public void excluirUsuarioPorEmail(String email){
        usuarioRepository.deleteByEmail(email);
    }

    public void atualizarUsuarioPorId(Integer id, Usuario usuario){
        Usuario usuarioModel = usuarioRepository.findById(id).orElseThrow(
            () -> new RuntimeException("Usuário não encontrado!")
        );

        Usuario usuarioAtualizado = Usuario.builder()
        .id(usuarioModel.getId())
        .nome(usuario.getNome() != null ? usuario.getNome() : usuarioModel.getNome())
        .email(usuario.getEmail() != null ? usuario.getEmail() : usuarioModel.getEmail())
        .senha(usuario.getSenha() != null ? usuario.getSenha() : usuarioModel.getSenha())
        .tipoUsuario(usuario.getTipoUsuario() != null ? usuario.getTipoUsuario() : usuarioModel.getTipoUsuario())
        .ativo(usuario.isAtivo() != false ? usuario.isAtivo() : usuarioModel.isAtivo())
        .build();

        usuarioRepository.saveAndFlush(usuarioAtualizado);

    }


}
