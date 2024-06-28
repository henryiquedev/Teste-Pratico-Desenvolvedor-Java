package com.teste.pratico.bean;

import com.teste.pratico.model.Agendamento;
import com.teste.pratico.model.Solicitante;
import com.teste.pratico.repository.SolicitanteRepository;
import com.teste.pratico.service.AgendamentoService;
import com.teste.pratico.service.SolicitanteService;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.ManagedBean;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;


@Data
@ViewScoped
@Component
@ManagedBean
public class AgendamentoBean  {

    @Autowired
    private AgendamentoService agendamentoService;

    @Autowired
    private SolicitanteService solicitanteService;

    @Autowired
    private SolicitanteRepository solicitanteRepository;


    private Agendamento agendamento;
    private LocalDateTime inicio;
    private LocalDateTime fim;
    private Solicitante solicitante;
    private List<Agendamento> agendamentos;

    private List<Solicitante> solicitantes = new ArrayList<>();


    @Setter
    @Getter



    private static final Logger logger = LoggerFactory.getLogger(AgendamentoBean.class); //hj16


    @PostConstruct
    public void init() {
        agendamento = new Agendamento();
        solicitantes = solicitanteService.listarSolicitantes();
    }


    public void salvar() {
        try {
            logger.info("Agendamento: {}", agendamento);
            logger.info("Solicitante do Agendamento: {}", agendamento.getSolicitante());

            if (agendamento.getSolicitante() == null || agendamento.getSolicitante().getId() == null) {
                throw new IllegalArgumentException("Solicitante ID must not be null!");
            }

            if (agendamento.getId() == null) {
                throw new IllegalArgumentException("O ID do agendamento não pode ser nulo");
            }
            agendamentoService.salvarAgendamento(agendamento);
            agendamento = new Agendamento();

            FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Sucesso", "Agendamento salvo com sucesso!");
            FacesContext.getCurrentInstance().addMessage(null, message);
        } catch (Exception e) {
            FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro ao salvar agendamento", e.getMessage());
            FacesContext.getCurrentInstance().addMessage(null, message);
            logger.error("Erro ao salvar agendamento", e);
        }
    }

    public void consultar() {
        try {
            logger.debug("Consultando agendamentos entre {} e {} para solicitante {}", inicio, fim, solicitante);
            agendamentos = agendamentoService.buscarAgendamentos(inicio, fim, solicitante);
            if (agendamentos.isEmpty()) {
                FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_WARN, "Aviso", "Nenhum agendamento encontrado.");
                FacesContext.getCurrentInstance().addMessage(null, message);
            }
        } catch (Exception e) {
            FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro ao consultar agendamentos", e.getMessage());
            FacesContext.getCurrentInstance().addMessage(null, message);
            e.printStackTrace();
        }
    }
}
