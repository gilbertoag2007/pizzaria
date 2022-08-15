package br.com.pizzaria.model;

import java.time.LocalDate;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;


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
	private Integer id;
	
	@ManyToOne
	@JoinColumn(name="ingrediente_id", nullable = false	)	
	private Ingrediente ingrediente;
	
	@Column(name = "DATA_INICIAL")
	LocalDate dataInicial;
	
	LocalDate dataFinal;
	
	SimNaoEnum atual;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
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
