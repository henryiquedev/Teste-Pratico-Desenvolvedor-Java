package com.teste.pratico.model;

import lombok.Data;
import javax.persistence.*;
import java.util.List;


@Entity
@Data
public class Solicitante {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nome;


    @OneToMany(mappedBy = "solicitante", cascade = CascadeType.ALL, fetch = FetchType.EAGER) //fetch = FetchType.EAGER
    private List<Agendamento> agendamentos;


}

