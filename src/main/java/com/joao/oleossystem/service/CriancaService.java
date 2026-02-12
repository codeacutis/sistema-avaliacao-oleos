package com.joao.oleossystem.service;

import org.springframework.stereotype.Service;

import com.joao.oleossystem.model.Crianca;
import com.joao.oleossystem.repository.CriancaRepository;

@Service
public class CriancaService {

    public CriancaRepository criancaRepository;

    public CriancaService(CriancaRepository criancaRepository){
        this.criancaRepository = criancaRepository;
    }

    public void salvarCrianca(Crianca crianca){
        criancaRepository.saveAndFlush(crianca);
    }

    public Crianca buscarCriancaPorId(Integer idCrianca){
        return criancaRepository.findById(idCrianca).orElseThrow(
            ()-> new RuntimeException("Criança não encontrada!")
        );
    }

    public void deletarCriancaPorId(Integer idCrianca){
        criancaRepository.deleteById(idCrianca);
    }

    public void atualizarCriancaPorId(Integer idCrianca, Crianca crianca){
        Crianca criancaModel = criancaRepository.findById(idCrianca).orElseThrow(
            ()-> new RuntimeException("Criança não encontrada!")
        );
        Crianca criancaAtualizada = Crianca.builder()
        .id(criancaModel.getId())
        .nome(criancaModel.getNome() != null ? crianca.getNome() : criancaModel.getNome())
        .transtorno(criancaModel.getTranstorno() != null ? crianca.getTranstorno() : criancaModel.getTranstorno())
        .dataNascimento(criancaModel.getDataNascimento() != null ? crianca.getDataNascimento(): criancaModel.getDataNascimento())
        .dataInicioEstudo(criancaModel.getDataInicioEstudo() != null ? crianca.getDataInicioEstudo() : criancaModel.getDataInicioEstudo())
        .statusEstudo(criancaModel.getStatusEstudo() != null ? crianca.getStatusEstudo() : criancaModel.getStatusEstudo())
        .estudo(criancaModel.getEstudo() != null ? crianca.getEstudo() : criancaModel.getEstudo())
        .build();

        criancaRepository.saveAndFlush(criancaAtualizada);
    }
}
