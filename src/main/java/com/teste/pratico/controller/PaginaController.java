package com.teste.pratico.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PaginaController {

    @GetMapping("/index")
    public String index() {
        return "index";
    }

    @GetMapping("/cadastroagendamento")
    public String cadastroagendamento() {
        return "cadastroagendamento";
    }

    @GetMapping("/consultaagendamento")
    public String consultaagendamento() {
        return "consultaagendamento";
    }

    @GetMapping("/homeagendamento")
    public String homeagendamento() {
        return "homeagendamento";
    }

    @GetMapping("/cadastrosolicitante")
    public String cadastrosolicitante() {
        return "cadastrosolicitante";
    }

    @GetMapping("/cadastrovaga")
    public String cadastrovaga() {
        return "cadastrovaga";
    }

}
