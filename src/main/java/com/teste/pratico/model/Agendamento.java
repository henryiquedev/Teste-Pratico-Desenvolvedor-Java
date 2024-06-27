package com.teste.pratico.model;

import lombok.Data;
import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Data
public class Agendamento {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private LocalDateTime data;

    @Column
    private String motivo;

    @Column(length = 20)
    private String numero;

    @ManyToOne
    @JoinColumn(name = "solicitante_id", nullable = false)
    private Solicitante solicitante;

   

}

