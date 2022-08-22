package br.com.pizzaria.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.pizzaria.controller.dto.IngredienteDto;
import br.com.pizzaria.model.DisponibilidadeIngrediente;
import br.com.pizzaria.model.Ingrediente;
import br.com.pizzaria.model.SimNaoEnum;
import br.com.pizzaria.repository.IngredienteRepository;

@Service
public class IngredienteService {

	@Autowired
	private IngredienteRepository ingredienteRepository;
		
	public IngredienteDto cadastrar(IngredienteDto ingredienteDto) {
				
		Ingrediente ingrediente = new Ingrediente();
		ingrediente.setNome(ingredienteDto.getNome());
		ingrediente.setAtivo(SimNaoEnum.SIM);
			
		ingrediente.setHistoricoDisponibilidade(new ArrayList<DisponibilidadeIngrediente>());
		ingrediente.getHistoricoDisponibilidade()
		.add(new DisponibilidadeIngrediente(ingrediente,LocalDate.now(), null, SimNaoEnum.SIM ));
		
		ingredienteRepository.save(ingrediente);
		
		return  ingrediente.converterParaDto();
	}
	
	
	public IngredienteDto atualizar(IngredienteDto ingredienteDto) {
		
		Ingrediente ingrediente = ingredienteDto.converterParaEntidade(this);
		ingredienteRepository.save(ingrediente);
		
		return  ingrediente.converterParaDto();
	}
	
		
	public Optional<Ingrediente> deletar(Long id) {
	
		Optional<Ingrediente> ingrediente  = ingredienteRepository.findById(id);
		ingredienteRepository.delete(ingrediente.get());
			
		return ingrediente;
	
	}
	
	public List<IngredienteDto> listarTodos() {
		   List<Ingrediente> listaIngredientes =  ingredienteRepository.findAll();
		   List<IngredienteDto> listaDto = new ArrayList<IngredienteDto>();
		   listaIngredientes.stream().forEach(i -> listaDto.add(i.converterParaDto()));
	
		return listaDto;
	}
	
	public Optional<Ingrediente> pesquisarPorId(Long id) {
		Optional<Ingrediente> ingrediente =  ingredienteRepository.findById(id);
		return ingrediente;
	}
	

	
}
