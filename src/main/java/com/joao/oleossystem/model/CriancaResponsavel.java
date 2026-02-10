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
@Table(name="criança responsavel")
@Entity
public class CriancaResponsavel {
    @Id
    @GeneratedValue(strategy = jakarta.persistence.GenerationType.IDENTITY)
    private Integer id;
    private String tipoVinculo;
    @ManyToOne
    @JoinColumn(name = "id_crianca")
    private Crianca crianca;
    @ManyToOne
    @JoinColumn(name = "id_responsavel")
    private Usuario responsavel;

    @Override
    public String toString() {
        return "CriancaResponsavel [crianca=" + crianca + ", id=" + id + ", responsavel=" + responsavel + ", tipoVinculo="
                + tipoVinculo + "]";
    }
}
