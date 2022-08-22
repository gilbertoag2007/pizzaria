package br.com.pizzaria.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.pizzaria.model.Pizza;
import br.com.pizzaria.repository.PizzaRepository;

@Service
public class PizzaService {

	@Autowired
	PizzaRepository pizzaRepository;
	
	public void salvar(Pizza pizza) {
		pizzaRepository.save(pizza);
	}
	
	public void deletar(Pizza pizza) {
		pizzaRepository.delete(pizza);
	}
	
	public void listarTodos(Pizza pizza) {
		pizzaRepository.findAll();
	}
	
	public Optional pesquisarPorId(Long id) {
		Optional<Pizza> pizza =  pizzaRepository.findById(id);
		return pizza;
	}
	
}
