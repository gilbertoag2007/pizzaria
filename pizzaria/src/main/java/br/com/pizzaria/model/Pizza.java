package br.com.pizzaria.model;

import java.util.List;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;


/**
 *  Classe responsavel por definir os atributos da entidade pizza.
 *  
 * @author Gilberto Cunha
 *
 */
@Entity
@Table(name = "pizza")
public class Pizza {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	
	private String nome;
	
	private TamanhoPizzaEnum tamanho;
	
	@ManyToMany
	private List<Ingrediente> ingredientes;
	
	@OneToMany
	private List <PrecoPizza> historicoPrecos;

	
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
	
	public List<Ingrediente> getIngredientes() {
		return ingredientes;
	}
	
	public void setIngredientes(List<Ingrediente> ingredientes) {
		this.ingredientes = ingredientes;
	}
	
	public TamanhoPizzaEnum getTamanho() {
		return tamanho;
	}
	
	public void setTamanho(TamanhoPizzaEnum tamanho) {
		this.tamanho = tamanho;
	}

	public List<PrecoPizza> getHistoricoPrecos() {
		return historicoPrecos;
	}

	public void setHistoricoPrecos(List<PrecoPizza> historicoPrecos) {
		this.historicoPrecos = historicoPrecos;
	}

	@Override
	public int hashCode() {
		return Objects.hash(historicoPrecos, id, ingredientes, nome, tamanho);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Pizza other = (Pizza) obj;
		return Objects.equals(historicoPrecos, other.historicoPrecos) && Objects.equals(id, other.id)
				&& Objects.equals(ingredientes, other.ingredientes) && Objects.equals(nome, other.nome)
				&& tamanho == other.tamanho;
	}

	@Override
	public String toString() {
		return "Pizza [id=" + id + ", nome=" + nome + ", tamanho=" + tamanho + ", ingredientes=" + ingredientes
				+ ", historicoPrecos=" + historicoPrecos + "]";
	}


	
}
