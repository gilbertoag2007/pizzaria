package br.com.pizzaria.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import br.com.pizzaria.controller.dto.DisponibilidadeIngredienteDto;
import br.com.pizzaria.controller.dto.IngredienteDto;


/**
 * Classe responsavel por definifir os atributos do ingrediante da pizza.
 * 
 * @author Gilberto Cunha
 *
 */
@Entity
@Table(name = "ingrediente")
public class Ingrediente {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@Column(length = 300)
	private String nome;
	
	@Enumerated(EnumType.STRING)
	@Column(length = 3)
	private SimNaoEnum ativo;
	
	@OneToMany(mappedBy = "ingrediente", cascade = CascadeType.ALL)
	private List<DisponibilidadeIngrediente> historicoDisponibilidade;

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

	public SimNaoEnum getAtivo() {
		return ativo;
	}

	public void setAtivo(SimNaoEnum ativo) {
		this.ativo = ativo;
	}

	public List<DisponibilidadeIngrediente> getHistoricoDisponibilidade() {
		return historicoDisponibilidade;
	}

	public void setHistoricoDisponibilidade(List<DisponibilidadeIngrediente> historicoDisponibilidade) {
		this.historicoDisponibilidade = historicoDisponibilidade;
	}
	
	public IngredienteDto converterParaDto() {
		
		IngredienteDto dto = new IngredienteDto();
		
		dto.setId(this.id);
		dto.setNome(this.nome);
		dto.setDisponibilidadeIngrediente(new ArrayList<DisponibilidadeIngredienteDto>());
		this.historicoDisponibilidade.forEach(d -> dto.getDisponibilidadeIngrediente().add(d.converterParaDto()));
		dto.setAtivo(this.ativo);
		
		return dto;
	}
	

	@Override
	public int hashCode() {
		return Objects.hash(ativo, historicoDisponibilidade, id, nome);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Ingrediente other = (Ingrediente) obj;
		return ativo == other.ativo && Objects.equals(historicoDisponibilidade, other.historicoDisponibilidade)
				&& Objects.equals(id, other.id) && Objects.equals(nome, other.nome);
	}

	@Override
	public String toString() {
		return "Ingrediente [id=" + id + ", nome=" + nome + ", ativo=" + ativo + ", historicoDisponibilidade="
				+ historicoDisponibilidade + "]";
	}



	
}
