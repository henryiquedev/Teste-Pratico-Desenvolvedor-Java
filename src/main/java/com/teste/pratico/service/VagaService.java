package com.teste.pratico.service;


import com.teste.pratico.model.Solicitante;
import com.teste.pratico.model.Vaga;
import com.teste.pratico.repository.SolicitanteRepository;
import com.teste.pratico.repository.VagaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
public class VagaService {


    @Autowired
    private VagaRepository vagaRepository;


    @Transactional
    public Vaga salvarVaga(Vaga vaga) {
        //validarAgendamento(agendamento);
        return vagaRepository.save(vaga);
    }


    /*public List<Solicitante> listarSolicitantes() {
        return solicitanteRepository.findAll();
    } */

}
