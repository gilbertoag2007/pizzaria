package br.com.pizzaria.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.pizzaria.model.Ingrediente;
import br.com.pizzaria.repository.IngredienteRepository;

@Service
public class IngredienteService {

	@Autowired
	private IngredienteRepository repository;
	
	public void salvar(Ingrediente ingrediente) {
		repository.save(ingrediente);
		
	}
	
	
	
}
