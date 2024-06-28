package com.teste.pratico.service;

import com.teste.pratico.model.Agendamento;
import com.teste.pratico.model.Solicitante;
import com.teste.pratico.model.Vaga;
import com.teste.pratico.repository.AgendamentoRepository;
import com.teste.pratico.repository.VagaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;


@Service
public class AgendamentoService {

    @Autowired
    private AgendamentoRepository agendamentoRepository;

    @Autowired
    private VagaRepository vagaRepository;

    @PersistenceContext
    private EntityManager entityManager;

    @Transactional
    public Agendamento salvarAgendamento(Agendamento agendamento) {
        if (agendamento.getId() == null) {
            entityManager.persist(agendamento);
        } else {
            entityManager.merge(agendamento);
        }
        validarAgendamento(agendamento);
        return agendamentoRepository.save(agendamento);
    }

    private void validarAgendamento(Agendamento agendamento) {
        Assert.notNull(agendamento.getId(), "O ID do agendamento não pode ser nulo");
        Optional<Agendamento> agendamentoExistente = agendamentoRepository.findById(agendamento.getId());
        List<Agendamento> agendamentosExistentes = agendamentoRepository.findByDataBetweenAndSolicitante(
                agendamento.getData().toLocalDate().atStartOfDay(),
                agendamento.getData().toLocalDate().atTime(23, 59, 59),
                agendamento.getSolicitante()
        );

        if (!agendamentosExistentes.isEmpty()) {
            throw new IllegalStateException("O solicitante já possui um agendamento nesse dia.");
        }

        Vaga vaga = vagaRepository.findById(agendamento.getId()).orElseThrow(() -> new IllegalStateException("Vaga não encontrada"));
        long agendamentosNoPeriodo = agendamentoRepository.findByDataBetweenAndSolicitante(vaga.getInicio(), vaga.getFim(), agendamento.getSolicitante()).size();
        if (agendamentosNoPeriodo >= (vaga.getQuantidade() * 0.25)) {
            throw new IllegalStateException("Limite de agendamentos por solicitante excedido.");
        }

       long totalAgendamentosNoPeriodo = agendamentoRepository.findByDataBetween(vaga.getInicio(), vaga.getFim()).size();
        if (totalAgendamentosNoPeriodo >= vaga.getQuantidade()) {
            throw new IllegalStateException("Não há vagas disponíveis para o período.");

        }
    }

    public List<Agendamento> buscarAgendamentos(LocalDateTime inicio, LocalDateTime fim, Solicitante solicitante) {
        return agendamentoRepository.findByDataBetweenAndSolicitante(inicio, fim, solicitante);
    }




}
