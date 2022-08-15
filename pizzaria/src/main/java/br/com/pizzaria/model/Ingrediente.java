package br.com.pizzaria.model;

import java.util.List;
import java.util.Objects;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;


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
	private Integer id;
	
	@Column
	private String nome;
	
	private SimNaoEnum ativo;
	
	@OneToMany(mappedBy = "ingrediente", cascade = CascadeType.ALL)
	private List<DisponibilidadeIngrediente> historicoDisponibilidade;
		
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
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
