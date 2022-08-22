package br.com.pizzaria.controller.dto;

import java.util.Optional;

import br.com.pizzaria.model.DisponibilidadeIngrediente;
import br.com.pizzaria.model.Ingrediente;
import br.com.pizzaria.model.SimNaoEnum;
import br.com.pizzaria.service.IngredienteService;
import br.com.pizzaria.util.FormatadorData;

public class DisponibilidadeIngredienteDto {

	private Long id;
	
	private Long IdIngrediente;
	
	private String dataInicial;
	
	private String dataFinal;
	
	private SimNaoEnum atual;

	public DisponibilidadeIngredienteDto() {
	}
	
	public DisponibilidadeIngredienteDto(String dataInicial, String dataFinal, SimNaoEnum atual) {
		this.dataInicial = dataInicial;
		this.dataFinal = dataFinal;
		this.atual = atual;
	}

	public DisponibilidadeIngredienteDto(DisponibilidadeIngrediente disponibilidadeIngrediente) {
		this.setDataInicial(FormatadorData.LocalDateParaString(disponibilidadeIngrediente.getDataInicial()));
		this.setDataFinal(FormatadorData.LocalDateParaString(disponibilidadeIngrediente.getDataFinal()));
		this.setAtual(disponibilidadeIngrediente.getAtual());	
	}
	
	public String getDataInicial() {
		return dataInicial;
	}

	public void setDataInicial(String dataInicial) {
		this.dataInicial = dataInicial;
	}

	public String getDataFinal() {
		return dataFinal;
	}

	public void setDataFinal(String dataFinal) {
		this.dataFinal = dataFinal;
	}

	public SimNaoEnum getAtual() {
		return atual;
	}

	public void setAtual(SimNaoEnum atual) {
		this.atual = atual;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getIdIngrediente() {
		return IdIngrediente;
	}

	public void setIdIngrediente(Long idIngrediente) {
		IdIngrediente = idIngrediente;
	}

	public DisponibilidadeIngrediente converterParaEntidade(IngredienteService ingredienteService) {
		
		DisponibilidadeIngrediente disponibilidadeIngrediente = new DisponibilidadeIngrediente();
		disponibilidadeIngrediente.setDataInicial(FormatadorData.StringParaLocalDate(this.dataInicial));
		disponibilidadeIngrediente.setDataFinal(FormatadorData.StringParaLocalDate(this.dataFinal));
		disponibilidadeIngrediente.setAtual(this.atual);
		
		if (this.IdIngrediente != null) {
			
			Optional<Ingrediente> optional = ingredienteService.pesquisarPorId(this.IdIngrediente);
		
		if (optional.isPresent()) {
			
			Ingrediente ingrediente = optional.get();
			
			disponibilidadeIngrediente.setIngrediente(ingrediente);
			
		}
	}
		
	return disponibilidadeIngrediente;
	
	}
	
}
