package com.joao.oleossystem.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.joao.oleossystem.model.Estudo;

@Repository
public interface EstudoRepository extends JpaRepository<Estudo, Integer>{

    Optional<Estudo> findByCriancaId(Integer criancaId);

}
