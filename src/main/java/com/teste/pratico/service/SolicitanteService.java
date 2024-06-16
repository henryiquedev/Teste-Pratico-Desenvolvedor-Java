package com.teste.pratico.service;


import com.teste.pratico.model.Solicitante;
import com.teste.pratico.repository.SolicitanteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
public class SolicitanteService {


    @Autowired
    private SolicitanteRepository solicitanteRepository;


    @Transactional
    public Solicitante salvarSolicitante(Solicitante solicitante) {
        //validarAgendamento(agendamento);
        return solicitanteRepository.save(solicitante);
    }




}
