package br.com.pizzaria.model;

import java.math.BigDecimal;
import java.util.List;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * Classe que indica a pizza do pedido e subistituicoes de ingredientes.
 * 
 * @author Gilberto Cunha
 *
 */
@Table(name = "item_pedido")
@Entity
public class ItemPedido {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@ManyToOne
	private Pizza pizza;
	
	@ManyToOne
	private Pedido pedido;
	
	@Column(precision = 3, scale = 2)
	private BigDecimal preco;
	
	@Embedded
	private List<SubstituicaoIngrediente> substituicaoIngrediente;

	@Column(length = 1000)
	private String observacao;
	

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

	public List<SubstituicaoIngrediente> getSubstituicaoIngrediente() {
		return substituicaoIngrediente;
	}

	public void setSubstituicaoIngrediente(List<SubstituicaoIngrediente> substituicaoIngrediente) {
		this.substituicaoIngrediente = substituicaoIngrediente;
	}

	
	public BigDecimal getPreco() {
		return preco;
	}

	public void setPreco(BigDecimal preco) {
		this.preco = preco;
	}

	
	public Pedido getPedido() {
		return pedido;
	}

	public void setPedido(Pedido pedido) {
		this.pedido = pedido;
	}
	

	public String getObservacao() {
		return observacao;
	}

	public void setObservacao(String observacao) {
		this.observacao = observacao;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, observacao, pedido, pizza, preco, substituicaoIngrediente);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ItemPedido other = (ItemPedido) obj;
		return Objects.equals(id, other.id) && Objects.equals(observacao, other.observacao)
				&& Objects.equals(pedido, other.pedido) && Objects.equals(pizza, other.pizza)
				&& Objects.equals(preco, other.preco)
				&& Objects.equals(substituicaoIngrediente, other.substituicaoIngrediente);
	}

	
}
