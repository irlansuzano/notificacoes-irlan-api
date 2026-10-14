package br.edu.infnet.notificacoes_irlan_api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class NotificacoesIrlanApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(NotificacoesIrlanApiApplication.class, args);
	}

}
