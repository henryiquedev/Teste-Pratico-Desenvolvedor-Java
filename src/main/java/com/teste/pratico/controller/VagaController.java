package com.teste.pratico.controller;

import com.teste.pratico.model.Vaga;
import com.teste.pratico.service.VagaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


@Controller
@RequestMapping("/api") // Adiciona um prefixo comum para os endpoints de API
public class VagaController {

    @Autowired
    private VagaService vagaService;

    @PostMapping("/vaga")
    @ResponseBody
    public Vaga criarVaga(@RequestBody Vaga vaga) {
        return vagaService.salvarVaga(vaga);
    }



    @GetMapping("/cadastrovaga")
    public String cadastrovaga() {
        return "cadastrovaga"; // Isso mapeia para o arquivo cadastrovaga.xhtml na pasta src/main/resources/META-INF/resources/
    }


}
