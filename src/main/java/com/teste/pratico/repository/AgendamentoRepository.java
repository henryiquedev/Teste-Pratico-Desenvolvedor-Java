package com.teste.pratico.repository;

import com.teste.pratico.model.Agendamento;
import com.teste.pratico.model.Solicitante;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.Collection;
import java.util.List;

@Repository
public interface AgendamentoRepository extends JpaRepository<Agendamento, Long> {
    List<Agendamento> findByDataBetweenAndSolicitante(LocalDateTime inicio, LocalDateTime fim, Solicitante solicitante);


   Collection<Object> findByDataBetween(LocalDateTime inicio, LocalDateTime fim);
}

