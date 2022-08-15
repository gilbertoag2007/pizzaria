package br.com.pizzaria.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/home")
public class HomeController {


	
	@GetMapping
	public String Home() {
		/*
		 * String resposta = service.listarEntregas(); System.out.println(resposta);
		 * 
		 * 
		 * 
		 * Entrega entrega = new Entrega();
		 * 
		 * Ingrediente ig1 = new Ingrediente(); ig1.setNome("Peperone");
		 * ig1.setAtivo(SimNaoEnum.SIM);;
		 * 
		 * Ingrediente ig2 = new Ingrediente(); ig1.setNome("Calabresa");
		 * ig1.setAtivo(SimNaoEnum.SIM);
		 * 
		 * List<Ingrediente> listaIngredientes = new ArrayList<Ingrediente>();
		 * listaIngredientes.add(ig1); listaIngredientes.add(ig2);
		 * 
		 * Pizza pizza1 = new Pizza(); pizza1.setNome("Peperrone com calabresa");
		 * pizza1.setTamanho(TamanhoPizzaEnum.FAMILIA);
		 * pizza1.setIngredientes(listaIngredientes);
		 * 
		 * List<Pizza> pizzasProntas = new ArrayList<Pizza>();
		 * entrega.setPizza(pizzasProntas); entrega.setCEP(21361560);
		 * entrega.setEndereco("Rua Lopes Ferreira"); entrega.setNumero("484");
		 * entrega.setBairro("Iraja");
		 * 
		 * 
		 * 
		 * service.salvar(entrega);
		 * 
		 * 
		 */
		
		return "/index.html";
	
		
	
	}
	
}
