package com.logone.teste.pratico.TestePraticoSpringBoot;

import com.teste.pratico.TestePraticoApplication;
import com.teste.pratico.model.Agendamento;
import com.teste.pratico.model.Solicitante;
import com.teste.pratico.repository.SolicitanteRepository;
import com.teste.pratico.service.AgendamentoService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@ExtendWith(SpringExtension.class)
@SpringBootTest(classes = TestePraticoApplication.class)
class TestePraticoSpringBootApplicationTests {

	@Test
	void contextLoads() {
	}



}
