package com.teste.pratico.controller;

import com.teste.pratico.model.Solicitante;
import com.teste.pratico.service.AgendamentoService;
import com.teste.pratico.service.SolicitanteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Controller
@RequestMapping("/api")
public class SolicitanteController {

    @Autowired
    private SolicitanteService solicitanteService;

    @Autowired
    private AgendamentoService agendamentoService;


    @PostMapping("/solicitantes")
    @ResponseBody
    public Solicitante criarSolicitante(@RequestBody Solicitante solicitante) {
        return solicitanteService.salvarSolicitante(solicitante);
    }


    @GetMapping("/solicitante")
    @ResponseBody
    public List<Solicitante> listarSolicitantes() {
        return solicitanteService.listarSolicitantes();
    }


}
