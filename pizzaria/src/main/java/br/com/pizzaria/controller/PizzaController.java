package br.com.pizzaria.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.pizzaria.model.Ingrediente;
import br.com.pizzaria.model.Pizza;
import br.com.pizzaria.model.TamanhoPizzaEnum;
import br.com.pizzaria.service.IngredienteService;
import br.com.pizzaria.service.PizzaService;

@Controller
@RequestMapping("/pizza")
public class PizzaController {

	@Autowired
	PizzaService pizzaService;
	
	@Autowired
	IngredienteService ingredienteService;
	
	public String pizza() {
		
		Pizza pizza = new Pizza();
		pizza.setNome("Peperone");
		pizza.setTamanho(TamanhoPizzaEnum.FAMILIA);
		
		
		
		
	return "/index.html";
	
	}
	
}
