package com.teste.pratico.service;



import com.teste.pratico.model.Vaga;
import com.teste.pratico.repository.VagaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
public class VagaService {


    @Autowired
    private VagaRepository vagaRepository;


    @Transactional
    public Vaga salvarVaga(Vaga vaga) {
        return vagaRepository.save(vaga);
    }


    public List<Vaga> listarVagas() {
        return vagaRepository.findAll();
    }

}
