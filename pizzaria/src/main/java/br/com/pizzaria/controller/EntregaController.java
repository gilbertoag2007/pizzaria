package br.com.pizzaria.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.pizzaria.service.EntregaService;

@Controller
@RequestMapping("/entrega")
public class EntregaController {

	@Autowired
	private EntregaService service;
	
	@GetMapping
	public String entrega() {		
		return "/index.html";
	}

}