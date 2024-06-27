package com.teste.pratico.model;

import lombok.Data;
import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Data
public class Vaga {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private LocalDateTime inicio;

    @Column
    private LocalDateTime fim;

    @Column
    private Integer quantidade;


}
