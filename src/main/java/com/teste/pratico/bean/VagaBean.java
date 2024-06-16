package com.teste.pratico.bean;

import com.teste.pratico.model.Vaga;
import com.teste.pratico.service.VagaService;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import java.io.Serializable;


@Data
@ViewScoped
@Component
public class VagaBean implements Serializable {

    @Autowired
    private VagaService vagaService;

    private Vaga vaga;

    //private List<Solicitante> solicitantes;


    @PostConstruct
    public void init() {
        vaga = new Vaga();
        //solicitantes = solicitanteService.listarSolicitantes();
    }

    public void salvar() {
        try {
            vagaService.salvarVaga(vaga);
            vaga = new Vaga(); // Reseta o form
            FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Sucesso", "Vaga salva com sucesso!");
            FacesContext.getCurrentInstance().addMessage(null, message);
        } catch (Exception e) {
            FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro ao salvar vaga", e.getMessage());
            FacesContext.getCurrentInstance().addMessage(null, message);
            e.printStackTrace();
        }
    }


}
