package com.joao.oleossystem.model;

import java.time.LocalDate;

import com.joao.oleossystem.enums.TipoFase;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
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
@Table(name="fase estudo")
@Entity
public class FaseEstudo {
    @Id
    @GeneratedValue(strategy = jakarta.persistence.GenerationType.IDENTITY)
    private Integer id;
    @Enumerated(EnumType.STRING)
    private TipoFase tipoFase;
    private LocalDate dataInicio;
    private LocalDate dataFim;
    private String oleoEssencial;
    @ManyToOne
    @JoinColumn(name = "id_estudo")
    private Estudo estudo;

    @Override
    public String toString() {
        return "FaseEstudo{" +
                "id=" + id +
                ", tipoFase=" + tipoFase +
                ", dataInicio=" + dataInicio +
                ", dataFim=" + dataFim +
                ", oleoEssencial='" + oleoEssencial + '\'' +
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
        FaseEstudo other = (FaseEstudo) obj;
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
