package com.joao.oleossystem.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.joao.oleossystem.enums.TipoQuestionario;
import com.joao.oleossystem.model.Questionario;

public interface QuestionarioRepository extends JpaRepository<Questionario, Integer>{

    Optional<Questionario> findByTipoAndAtivoTrue(TipoQuestionario tipo);
}
