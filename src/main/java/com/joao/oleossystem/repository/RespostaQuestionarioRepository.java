package com.joao.oleossystem.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.joao.oleossystem.model.RespostaQuestionario;

public interface RespostaQuestionarioRepository extends JpaRepository<RespostaQuestionario, Integer>{

     boolean existsByCriancaIdAndQuestionarioIdAndDataResposta(
            Long criancaId,
            Long questionarioId,
            LocalDate dataResposta
    );

    List<RespostaQuestionario> findByCriancaId(Long criancaId);
}
