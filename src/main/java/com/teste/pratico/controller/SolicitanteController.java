package com.teste.pratico.controller;

import com.teste.pratico.model.Solicitante;
import com.teste.pratico.service.SolicitanteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Controller
@RequestMapping("/api") // Adiciona um prefixo comum para os endpoints de API
public class SolicitanteController {

    @Autowired
    private SolicitanteService solicitanteService;

    @PostMapping("/solicitantes")
    @ResponseBody
    public Solicitante criarSolicitante(@RequestBody Solicitante solicitante) {
        return solicitanteService.salvarSolicitante(solicitante);
    }




    @GetMapping("/cadastrosolicitante")
    public String cadastrosolicitante() {
        return "cadastrosolicitante"; // Isso mapeia para o arquivo cadastrosolicitante.xhtml na pasta src/main/resources/META-INF/resources/
    }


}
