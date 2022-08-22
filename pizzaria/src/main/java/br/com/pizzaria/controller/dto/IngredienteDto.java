package br.com.pizzaria.controller.dto;

import java.util.ArrayList;
import java.util.List;

import org.springframework.lang.NonNull;

import br.com.pizzaria.model.DisponibilidadeIngrediente;
import br.com.pizzaria.model.Ingrediente;
import br.com.pizzaria.model.SimNaoEnum;
import br.com.pizzaria.service.IngredienteService;

public class IngredienteDto {


	private Long id;

	@NonNull
	private String nome;
	
	private SimNaoEnum ativo;
	
	private List<DisponibilidadeIngredienteDto> disponibilidadeIngrediente;
	
	public IngredienteDto() {	
	}
			
	public IngredienteDto(Long id, String nome, List<DisponibilidadeIngrediente> disponibilidadeIngrediente, SimNaoEnum ativo) {
	
		this.id = id;
		this.nome = nome;
		this.disponibilidadeIngrediente = new ArrayList<DisponibilidadeIngredienteDto>();
		disponibilidadeIngrediente.stream().forEach(d -> this.disponibilidadeIngrediente.add(d.converterParaDto()));
		this.ativo = ativo;
	}

	public IngredienteDto(Ingrediente ingrediente) {
		this.setId(ingrediente.getId());
		this.setNome(ingrediente.getNome());
		this.setAtivo(SimNaoEnum.SIM);
		this.disponibilidadeIngrediente = new ArrayList<DisponibilidadeIngredienteDto>();
		
		ingrediente.getHistoricoDisponibilidade().forEach(d -> this.disponibilidadeIngrediente.add(d.converterParaDto()));			
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public List<DisponibilidadeIngredienteDto> getDisponibilidadeIngrediente() {
		return disponibilidadeIngrediente;
	}

	public void setDisponibilidadeIngrediente(List<DisponibilidadeIngredienteDto> disponibilidadeIngrediente) {
		this.disponibilidadeIngrediente = disponibilidadeIngrediente;
	}

	public SimNaoEnum getAtivo() {
		return ativo;
	}
	public void setAtivo(SimNaoEnum ativo) {
		this.ativo = ativo;
	}
	
	public Ingrediente converterParaEntidade(IngredienteService ingredienteService) {
		
		Ingrediente ingrediente = new Ingrediente();
		
		ingrediente.setId(this.id);
		ingrediente.setNome(this.nome);
		ingrediente.setAtivo(this.ativo);
		ingrediente.setHistoricoDisponibilidade(new ArrayList<DisponibilidadeIngrediente>());
		
		this.disponibilidadeIngrediente.forEach(d-> ingrediente.getHistoricoDisponibilidade().add(d.converterParaEntidade(ingredienteService)));
		
		return ingrediente;
	}
	
}
