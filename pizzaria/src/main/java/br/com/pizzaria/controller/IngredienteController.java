package br.com.pizzaria.controller;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.pizzaria.model.DisponibilidadeIngrediente;
import br.com.pizzaria.model.Ingrediente;
import br.com.pizzaria.model.SimNaoEnum;
import br.com.pizzaria.service.IngredienteService;

@Controller
@RequestMapping("/ingrediente")
public class IngredienteController {
	
	@Autowired
	private IngredienteService service;
	
	
	@GetMapping
	public String ingrediente() {
		
		Ingrediente ingrediente = new Ingrediente();
		ingrediente.setNome("Camarão Camarão  ");
		ingrediente.setAtivo(SimNaoEnum.SIM);
		
		DisponibilidadeIngrediente disponibilidade = new DisponibilidadeIngrediente();
		disponibilidade.setAtual(SimNaoEnum.SIM);
		disponibilidade.setDataInicial(LocalDate.now());
		disponibilidade.setIngrediente(ingrediente);
		
		List<DisponibilidadeIngrediente> listaDisponibilidade = new ArrayList<DisponibilidadeIngrediente>();
		listaDisponibilidade.add(disponibilidade);
		ingrediente.setHistoricoDisponibilidade(listaDisponibilidade);
		
	
		
		service.salvar(ingrediente);
		
		System.out.println("ingrediente salvo");
	return "/index.html";
	}
	
}
