package br.com.pizzaria.model;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import br.com.pizzaria.controller.dto.DisponibilidadeIngredienteDto;
import br.com.pizzaria.service.IngredienteService;
import br.com.pizzaria.util.FormatadorData;


/**
 * Classe que define o periodo que um ingrediente ficou disponivel ou indisponivel. Historico de disponibilidades.
 * 
 * @version 1.0
 * 
 * @author Gilberto Cunha
 * */
@Entity
@Table(name = "disponibilidade_ingrediente")
public class DisponibilidadeIngrediente {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@ManyToOne
	@JoinColumn(name="ingrediente_id", nullable = false	)	
	private Ingrediente ingrediente;
	
	LocalDate dataInicial;
	
	LocalDate dataFinal;
	
	@Enumerated(EnumType.STRING)
	@Column(length = 3)
	SimNaoEnum atual;

	public DisponibilidadeIngrediente() {
		
	}
	
	public DisponibilidadeIngrediente(Ingrediente ingrediente, LocalDate dataInicial, LocalDate dataFinal,
			SimNaoEnum atual) {
	
		this.ingrediente = ingrediente;
		
		LocalDate hoje = LocalDate.now();
		DateTimeFormatter formatador = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		String data = hoje.format(formatador);
		LocalDate dataFormatada = LocalDate.parse(data, formatador);
		
		this.dataInicial = dataFormatada;
		this.atual = atual;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Ingrediente getIngrediente() {
		return ingrediente;
	}

	public void setIngrediente(Ingrediente ingrediente) {
		this.ingrediente = ingrediente;
	}

	public LocalDate getDataInicial() {
		return dataInicial;
	}

	public void setDataInicial(LocalDate dataInicial) {
		this.dataInicial = dataInicial;
	}

	public LocalDate getDataFinal() {
		return dataFinal;
	}

	public void setDataFinal(LocalDate dataFinal) {
		this.dataFinal = dataFinal;
	}

	public SimNaoEnum getAtual() {
		return atual;
	}

	public void setAtual(SimNaoEnum atual) {
		this.atual = atual;
	}

	@Override
	public int hashCode() {
		return Objects.hash(atual, dataFinal, dataInicial, id, ingrediente);
	}

	public DisponibilidadeIngredienteDto converterParaDto() {
		DisponibilidadeIngredienteDto dto = new DisponibilidadeIngredienteDto();
		dto.setId(this.id);
		dto.setDataInicial(FormatadorData.LocalDateParaString(this.dataInicial));
		dto.setDataFinal(FormatadorData.LocalDateParaString(this.dataFinal));
		dto.setAtual(this.atual);		
		
		if(this.ingrediente != null) {
			dto.setIdIngrediente(this.ingrediente.getId());
		}
		
		return dto;
	}
	

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		DisponibilidadeIngrediente other = (DisponibilidadeIngrediente) obj;
		return atual == other.atual && Objects.equals(dataFinal, other.dataFinal)
				&& Objects.equals(dataInicial, other.dataInicial) && Objects.equals(id, other.id)
				&& Objects.equals(ingrediente, other.ingrediente);
	}

	
}
