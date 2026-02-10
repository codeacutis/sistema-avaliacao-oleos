package com.joao.oleossystem.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.joao.oleossystem.model.FaseEstudo;

public interface FaseEstudoRepository extends JpaRepository<FaseEstudo, Integer>{
    
        List<FaseEstudo> findByEstudoIdOrderByDataInicio(Long estudoId);
}
