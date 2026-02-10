package com.joao.oleossystem.model;

import java.time.LocalDate;

import com.joao.oleossystem.enums.StatusEstudo;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
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
@Table(name="criança")
@Entity
public class Crianca {
    @Id
    @GeneratedValue(strategy = jakarta.persistence.GenerationType.IDENTITY)
    private Integer id;
    private String nome;
    private String transtorno;
    private LocalDate dataNascimento;
    private LocalDate dataInicioEstudo;
    @Enumerated(EnumType.STRING)
    private StatusEstudo statusEstudo;
    @OneToOne(mappedBy = "crianca", cascade = CascadeType.ALL)
    private Estudo estudo;

    @Override
    public String toString() {
        return "Crianca{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", dataNascimento=" + dataNascimento +
                ", dataInicioEstudo=" + dataInicioEstudo +
                ", statusEstudo=" + statusEstudo +
                ", estudo=" + estudo +
                '}';
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Crianca other = (Crianca) obj;
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
