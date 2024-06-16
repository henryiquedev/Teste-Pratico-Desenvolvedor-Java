package com.teste.pratico.model;

import lombok.Data;
import javax.persistence.*;
// import java.time.LocalDateTime;

@Entity
@Data
@Table(name = "solicitante")
public class Solicitante {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nome;
}

