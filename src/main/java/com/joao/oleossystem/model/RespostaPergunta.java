package com.joao.oleossystem.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name="resposta pergunta")
@Entity
public class RespostaPergunta {
    @Id
    @GeneratedValue(strategy = jakarta.persistence.GenerationType.IDENTITY)
    private Integer id;
    private String valorReposta;
    @ManyToOne
    @JoinColumn(name = "id_pergunta")
    private Pergunta pergunta;
    @ManyToOne
    @JoinColumn(name = "id_resposta_questionario")
    private RespostaQuestionario respostaQuestionario;

    @Override
    public String toString() {
        return "RespostaPergunta [id=" + id + ", valorReposta=" + valorReposta + ", pergunta=" + pergunta
                + ", respostaQuestionario=" + respostaQuestionario + "]";
    }
}
