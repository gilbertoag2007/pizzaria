package br.com.pizzaria.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.pizzaria.model.SubstituicaoIngrediente;
import br.com.pizzaria.repository.SubstituicaoIngredienteRepository;

@Service
public class SubstituicaoIngredienteService {

	@Autowired
	SubstituicaoIngredienteRepository substituicaoIngredienteRepository;
	
	public void salvar(SubstituicaoIngrediente substituicaoIngrediente) {
		substituicaoIngredienteRepository.save(substituicaoIngrediente);
	}
	
	public void deletar(SubstituicaoIngrediente substituicaoIngrediente) {
		substituicaoIngredienteRepository.delete(substituicaoIngrediente);
	}
	
	public void listarTodos(SubstituicaoIngrediente substituicaoIngrediente) {
		substituicaoIngredienteRepository.findAll();
	}
	
	public Optional pesquisarPorId(Long id) {
		Optional<SubstituicaoIngrediente> substituicaoIngrediente =  substituicaoIngredienteRepository.findById(id);
		return substituicaoIngrediente;
	}
	
	
}
