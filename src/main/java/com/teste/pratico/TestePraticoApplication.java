package com.teste.pratico;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication //(scanBasePackages = "com.teste.pratico")
@EnableAutoConfiguration
@ComponentScan(basePackages = {"com.teste.pratico"})
public class TestePraticoApplication {

	public static void main(String[] args) {
		SpringApplication.run(TestePraticoApplication.class, args);
	}

}