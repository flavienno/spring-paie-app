package dev.paie;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import dev.paie.exec.InsererBulletin;

@SpringBootApplication
public class PaieAppApplication {
	public static void main(String[] args) {
		// Récupération du contexte Spring créé par Spring Boot
		// La classe de configuration initiale de Spring est PaieAppApplication
		ConfigurableApplicationContext context = SpringApplication.run(PaieAppApplication.class, args);
		// Récupération d'un bean de type Runnable
		Runnable exec = context.getBean(InsererBulletin.class);
		// exécution
		exec.run();
	}
}
