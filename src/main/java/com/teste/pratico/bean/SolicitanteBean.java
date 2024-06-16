package com.teste.pratico.bean;

import com.teste.pratico.model.Solicitante;
import com.teste.pratico.service.SolicitanteService;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import java.io.Serializable;
import java.util.List;


@Data
@ViewScoped
@Component
public class SolicitanteBean implements Serializable {

    @Autowired
    private SolicitanteService solicitanteService;

    private Solicitante solicitante;

   // private List<Solicitante> solicitantes;


    @PostConstruct
    public void init() {
        solicitante = new Solicitante();
      //  solicitantes = solicitanteService.listarSolicitantes();
    }

    public void salvar() {
        try {
            solicitanteService.salvarSolicitante(solicitante);
            solicitante = new Solicitante(); // Reseta o form
            FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Sucesso", "Solicitante salvo com sucesso!");
            FacesContext.getCurrentInstance().addMessage(null, message);
        } catch (Exception e) {
            FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro ao salvar solicitante", e.getMessage());
            FacesContext.getCurrentInstance().addMessage(null, message);
            e.printStackTrace();
        }
    }


}
