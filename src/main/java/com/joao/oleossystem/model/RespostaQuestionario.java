package com.joao.oleossystem.model;

import java.time.LocalDate;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
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
@Table(name="resposta questionario")
@Entity
public class RespostaQuestionario {
    @Id
    @GeneratedValue(strategy = jakarta.persistence.GenerationType.IDENTITY)
    private Integer id;
    private LocalDate dataResposta;
    @ManyToOne
    @JoinColumn(name = "id_questionario")
    private Questionario questionario;
    @ManyToOne
    @JoinColumn(name = "id_usuario")
    private Usuario usuario;
    @ManyToOne
    @JoinColumn(name = "id_crianca")
    private Crianca crianca;
    @ManyToOne
    @JoinColumn(name = "id_fase_estudo")
    private FaseEstudo faseEstudo;
    @OneToMany(mappedBy = "respostaQuestionario", cascade = CascadeType.ALL)
    private List<RespostaPergunta> respostas;

    @Override
    public String toString() {
        return "RespostaQuestionario [id=" + id + ", dataResposta=" + dataResposta + ", questionario=" + questionario
                + ", usuario=" + usuario + ", crianca=" + crianca + ", faseEstudo=" + faseEstudo + ", respostas="
                + respostas + "]";
    }
    
}
