package br.com.pizzaria.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.pizzaria.model.Entrega;
import br.com.pizzaria.repository.EntregaRepository;

@Service
public class EntregaService {

	
	@Autowired
	EntregaRepository entregaRepository;
	
	public void salvar(Entrega entrega) {
		entregaRepository.save(entrega);
	}
	
	public void deletar(Entrega entrega) {
		entregaRepository.delete(entrega);
	}
	
	public void listarTodos(Entrega entrega) {
		entregaRepository.findAll();
	}
	
	public Optional pesquisarPorId(Long id) {
		Optional<Entrega> entrega =  entregaRepository.findById(id);
		return entrega;
	}
}
