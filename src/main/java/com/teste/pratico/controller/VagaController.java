package com.teste.pratico.controller;

import com.teste.pratico.model.Vaga;
import com.teste.pratico.service.VagaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Controller
@RequestMapping("/api")
public class VagaController {

    @Autowired
    private VagaService vagaService;

    @PostMapping("/vaga")
    @ResponseBody
    public Vaga criarVaga(@RequestBody Vaga vaga) {
        return vagaService.salvarVaga(vaga);
    }

    @GetMapping("/vagas")
    @ResponseBody
    public List<Vaga> listarVagas() {
        return vagaService.listarVagas();
    }



}
