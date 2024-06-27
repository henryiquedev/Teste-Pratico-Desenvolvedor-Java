package com.teste.pratico.bean;

import com.teste.pratico.model.Solicitante;
import com.teste.pratico.service.SolicitanteService;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

import java.util.List;


@Data
@ViewScoped
@Component
@Named(value = "solicitanteBean")
public class SolicitanteBean  {

    @Autowired
    private SolicitanteService solicitanteService;


    private Solicitante solicitante;

    @Setter
    @Getter
    private List<Solicitante> solicitantes;




   @PostConstruct
    public void init() {
        solicitante = new Solicitante();
        solicitantes = solicitanteService.listarSolicitantes();

    }

    //

    public Solicitante findSolicitanteById(Long id) {
        for (Solicitante solicitante : solicitantes) {
            if (solicitante.getId().equals(id)) {
                return solicitante;
            }
        }
        return null;
    }
//
    public void salvar() {
        try {
            solicitanteService.salvarSolicitante(solicitante);
            solicitante = new Solicitante();
            FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Sucesso", "Solicitante salvo com sucesso!");
            FacesContext.getCurrentInstance().addMessage(null, message);
        } catch (Exception e) {
            FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro ao salvar solicitante", e.getMessage());
            FacesContext.getCurrentInstance().addMessage(null, message);
            e.printStackTrace();
        }
    }


}
