package br.com.romero.apibuscagatos;

import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@EnableRabbit
@SpringBootApplication
public class ApiBuscaGatosApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApiBuscaGatosApplication.class, args);
	}

}
