package br.com.pizzaria;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;

@SpringBootApplication
public class PizzariaApplication {

	
	
	public static void main(String[] args) {
		SpringApplication.run(PizzariaApplication.class, args);
	}

	@GetMapping
	public String index() {
		
		
		
		
		
		
		return "/index";
	}
	
}
