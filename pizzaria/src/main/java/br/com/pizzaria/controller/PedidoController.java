package br.com.pizzaria.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.pizzaria.service.PedidoService;

@Controller
@RequestMapping("/pedido")
public class PedidoController {

	@Autowired
	PedidoService pedidoService;
	
	@GetMapping
	public String pedido(){
		
		return "/index.html";
	}
	
	
	
}
