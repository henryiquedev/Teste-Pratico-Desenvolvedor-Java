package com.teste.pratico.controller;

import com.teste.pratico.model.Agendamento;
import com.teste.pratico.model.Solicitante;
import com.teste.pratico.model.Vaga;
import com.teste.pratico.service.AgendamentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@Controller
@RequestMapping("/api") // Adiciona um prefixo comum para os endpoints de API
public class AgendamentoController {

    @Autowired
    private AgendamentoService agendamentoService;

    @PostMapping("/agendamentos")
    @ResponseBody
    public Agendamento criarAgendamento(@RequestBody Agendamento agendamento) {
        return agendamentoService.salvarAgendamento(agendamento);
    }

    @GetMapping("/listaragendamentos")
    @ResponseBody
    public List<Agendamento> buscarAgendamentos(@RequestParam LocalDateTime inicio, @RequestParam LocalDateTime fim, @RequestParam Long solicitanteId) {
        Solicitante solicitante = new Solicitante();
        solicitante.setId(solicitanteId);
        return agendamentoService.buscarAgendamentos(inicio, fim, solicitante);
    }

   @GetMapping("/solicitante")
    @ResponseBody
    public List<Solicitante> listarSolicitantes() {
        return agendamentoService.listarSolicitantes();
    }

    @GetMapping("/vagas")
    @ResponseBody
    public List<Vaga> listarVagas() {
        return agendamentoService.listarVagas();
    }

    @GetMapping("/index")
    public String index() {
        return "index"; // Isso mapeia para o arquivo index.xhtml na pasta src/main/resources/META-INF/resources/
    }

    @GetMapping("/cadastroagendamento")
    public String cadastroagendamento() {
        return "cadastroagendamento"; // Isso mapeia para o arquivo cadastroagendamento.xhtml na pasta src/main/resources/META-INF/resources/
    }

    @GetMapping("/consultaagendamento")
    public String consultaagendamento() {
        return "consultaagendamento"; // Isso mapeia para o arquivo consultaagendamento.xhtml na pasta src/main/resources/META-INF/resources/
    }

    @GetMapping("/homeagendamento")
    public String homeagendamento() {
        return "homeagendamento"; // Isso mapeia para o arquivo homeagendamento.xhtml na pasta src/main/resources/META-INF/resources/
    }
}
