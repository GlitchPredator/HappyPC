package com.example.InferentaSistemeExpert;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.IOException;

@SpringBootApplication
public class ProiectConfigurarePcSeApplication {

	public static void main(String[] args) throws IOException {
		SpringApplication.run(ProiectConfigurarePcSeApplication.class, args);

		PcKnowledgeBase.sendGET();
	}
}
