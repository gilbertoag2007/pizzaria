package br.com.pizzaria.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.pizzaria.model.DisponibilidadeIngrediente;
import br.com.pizzaria.repository.DisponibilidadeIngredienteRepository;

@Service
public class DisponibilidadeIngredienteService {

	@Autowired
	DisponibilidadeIngredienteRepository disponibilidadeIngredienteRepository;
	
	public void inativar(Long idIngrediente) {
	
		DisponibilidadeIngrediente disponibilidadeIngrediente = disponibilidadeIngredienteRepository.pesquisarDisponibilidadeAtual(idIngrediente);
		disponibilidadeIngrediente.setDataFinal(LocalDate.now());
		disponibilidadeIngredienteRepository.save(disponibilidadeIngrediente);
	
	}
	
	public DisponibilidadeIngrediente pesquisarPorId(Long id) {
		return disponibilidadeIngredienteRepository.findById(id).get();
				
	}
	
	public List<DisponibilidadeIngrediente> pesquisarPorIngrediente(Long idIngrediente){
		return disponibilidadeIngredienteRepository.findByIngredienteId(idIngrediente);
	}
	
	
}
