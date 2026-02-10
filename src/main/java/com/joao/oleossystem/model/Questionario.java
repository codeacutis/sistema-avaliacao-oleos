package com.joao.oleossystem.model;

import java.util.List;

import com.joao.oleossystem.enums.TipoQuestionario;
import com.joao.oleossystem.enums.TipoUsuario;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
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
@Table(name="questionario")
@Entity
public class Questionario {
    @Id
    @GeneratedValue(strategy = jakarta.persistence.GenerationType.IDENTITY)
    private Integer id;
    private String titulo;
    @Enumerated(EnumType.STRING)
    private TipoQuestionario tipo;
    @Enumerated(EnumType.STRING)
    private TipoUsuario publicoAlvo;
    private boolean ativo;
    @OneToMany(mappedBy = "questionario", cascade = CascadeType.ALL)
    private List<Pergunta> perguntas;

    @Override
    public String toString() {
        return "Questionario [ativo=" + ativo + ", id=" + id + ", perguntas=" + perguntas + ", publicoAlvo=" + publicoAlvo
                + ", titulo=" + titulo + ", tipo=" + tipo + "]";
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Questionario other = (Questionario) obj;
        if (id == null || other.id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        return true;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        return result;
    }
}
