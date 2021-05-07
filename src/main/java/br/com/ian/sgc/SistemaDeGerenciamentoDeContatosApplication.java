package br.com.ian.sgc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
public class SistemaDeGerenciamentoDeContatosApplication {

	public static void main(String[] args) {
		SpringApplication.run(SistemaDeGerenciamentoDeContatosApplication.class, args);
		System.out.println("✔️ Run!!");
	}
}
