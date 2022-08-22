package br.com.pizzaria.model;

import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * Classe responsavel pelos ingredientes substitudos da entidade pizza.
 * 
 * @author Gilberto Cunha
 *
 */
@Entity
@Table(name="SUBSTITUICAO_INGREDIENTE")
public class SubstituicaoIngrediente{
	
	@Id
	private Long id;
	
	@ManyToOne
	private Ingrediente ingredienteSubstituido;
	
	@ManyToOne
	private Ingrediente ingredienteSubstituidor;
	
	@ManyToOne
	@JoinColumn(name="item_pedido_id", nullable = false	)	
	private ItemPedido itemPedido;
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Ingrediente getIngredienteSubstituido() {
		return ingredienteSubstituido;
	}

	public void setIngredienteSubstituido(Ingrediente ingredienteSubstituido) {
		this.ingredienteSubstituido = ingredienteSubstituido;
	}

	public Ingrediente getIngredienteSubstituidor() {
		return ingredienteSubstituidor;
	}

	public void setIngredienteSubstituidor(Ingrediente ingredienteSubstituidor) {
		this.ingredienteSubstituidor = ingredienteSubstituidor;
	}

	
	public ItemPedido getItemPedido() {
		return itemPedido;
	}

	public void setItemPedido(ItemPedido itemPedido) {
		this.itemPedido = itemPedido;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, ingredienteSubstituido, ingredienteSubstituidor, itemPedido);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		SubstituicaoIngrediente other = (SubstituicaoIngrediente) obj;
		return Objects.equals(id, other.id) && Objects.equals(ingredienteSubstituido, other.ingredienteSubstituido)
				&& Objects.equals(ingredienteSubstituidor, other.ingredienteSubstituidor)
				&& Objects.equals(itemPedido, other.itemPedido);
	}

	
	
}
