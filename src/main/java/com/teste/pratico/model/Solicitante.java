package com.teste.pratico.model;

import lombok.Data;
import javax.persistence.*;
import java.util.List;
import java.util.Objects;


@Entity
@Data
public class Solicitante {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nome;


    @OneToMany(mappedBy = "solicitante", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Agendamento> agendamentos;

    //
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Solicitante that = (Solicitante) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "Solicitante{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                '}';
    }

    //

}

