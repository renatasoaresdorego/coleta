package br.com.fiap.fase5.capitulo4.coleta;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "br.com.fiap.fase5.capitulo4.coleta")
public class ColetaApplication {

	public static void main(String[] args) {
		SpringApplication.run(ColetaApplication.class, args);
	}

}
