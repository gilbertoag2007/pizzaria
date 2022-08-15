package br.com.pizzaria.model;

import java.math.BigDecimal;
import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * Classe que define os atributos do historico de precos da pizza
 * 
 * @author Gilberto Cunha
 *
 */
@Entity
@Table(name = "historico_preco_pizza")
public class PrecoPizza {

	@Id
	@GeneratedValue(strategy =  GenerationType.AUTO)
	private Long id;
	
	@ManyToOne
	@JoinColumn(name = "idPizza")
	private Pizza pizza;
	
	private BigDecimal preco;
	
	private LocalDate data;
	
	private SimNaoEnum atual;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Pizza getPizza() {
		return pizza;
	}

	public void setPizza(Pizza pizza) {
		this.pizza = pizza;
	}

	public BigDecimal getPreco() {
		return preco;
	}

	public void setPreco(BigDecimal preco) {
		this.preco = preco;
	}

	public LocalDate getData() {
		return data;
	}

	public void setData(LocalDate data) {
		this.data = data;
	}

	public SimNaoEnum getAtual() {
		return atual;
	}

	public void setAtual(SimNaoEnum atual) {
		this.atual = atual;
	}

	

}
