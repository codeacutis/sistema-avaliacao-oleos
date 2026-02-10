package com.joao.oleossystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.joao.oleossystem.model.Usuario;

import jakarta.transaction.Transactional;

import java.util.Optional;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Integer>{

    Optional<Usuario> findByEmail(String email);

    @Transactional //Caso der algum erro, não deleta o usuário
    void deleteByEmail(String email);

}
