package com.teste.pratico.bean;

import com.teste.pratico.model.Agendamento;
import com.teste.pratico.model.Solicitante;
import com.teste.pratico.service.AgendamentoService;
import lombok.Data;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

import org.slf4j.Logger;


@Data
@ViewScoped
@Component
public class AgendamentoBean implements Serializable {

    @Autowired
    private AgendamentoService agendamentoService;

    private Agendamento agendamento;
    private LocalDateTime inicio;
    private LocalDateTime fim;
    private Solicitante solicitante;
    private List<Solicitante> solicitantes;
    private List<Agendamento> agendamentos;

    private static final Logger logger = LoggerFactory.getLogger(AgendamentoBean.class); //hj16


    @PostConstruct
    public void init() {
        agendamento = new Agendamento();
        solicitantes = agendamentoService.listarSolicitantes();
    }

    public void salvar() {
        try {
           /* if (agendamento.getSolicitante() == null) {
                FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro", "Solicitante é obrigatório.");
                FacesContext.getCurrentInstance().addMessage(null, message);
                return;
            } hj16 */
            agendamentoService.salvarAgendamento(agendamento);
            agendamento = new Agendamento(); // Reseta o form
            FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Sucesso", "Agendamento salvo com sucesso!");
            FacesContext.getCurrentInstance().addMessage(null, message);
        } catch (Exception e) {
            FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro ao salvar agendamento", e.getMessage());
            FacesContext.getCurrentInstance().addMessage(null, message);
            e.printStackTrace();
        }
    }

   /* public void consultar() {
            agendamentos = agendamentoService.buscarAgendamentos(inicio, fim, solicitante);
    } hj16*/

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
