package com.teste.pratico.controller;

import com.teste.pratico.model.Agendamento;
import com.teste.pratico.model.Solicitante;
import com.teste.pratico.service.AgendamentoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@Controller
@RequestMapping("/api")
public class AgendamentoController {

    @Autowired
    private AgendamentoService agendamentoService;

    private static final Logger log = LoggerFactory.getLogger(AgendamentoController.class);



    @PostMapping("/agendamentos")
    public Agendamento criarAgendamento(@RequestBody Agendamento agendamento) {
        return agendamentoService.salvarAgendamento(agendamento);
    }

    @GetMapping("/listaragendamentos")
    @ResponseBody
    public ResponseEntity<List<Agendamento>> buscarAgendamentos(
            @RequestParam("inicio") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime inicio,
            @RequestParam("fim") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime fim,
            @RequestParam("solicitanteId") Long solicitanteId) {


       log.debug("Parâmetros recebidos - Inicio: {}, Fim: {}, SolicitanteId: {}", inicio, fim, solicitanteId);
        Solicitante solicitante = new Solicitante();
        solicitante.setId(solicitanteId);
        List<Agendamento> agendamentos = agendamentoService.buscarAgendamentos(inicio, fim, solicitante);
      log.debug("Agendamentos encontrados: {}", agendamentos.size());
        return ResponseEntity.ok(agendamentos);
    }

}
