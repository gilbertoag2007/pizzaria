package br.com.pizzaria.model;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *Classe responsavel por descrever os atributos da entidade pedido.
 *
 *
 * @author Gilberto Cunha
 *
 */
@Entity
@Table(name = "pedido")
public class Pedido {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	
	@Embedded
	private List<ItemPedido> listaItens;
	
	private LocalDateTime dataHoraPedido;
	
	private BigDecimal totalPedido;
	
	private String observacoes;


	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public List<ItemPedido> getListaItens() {
		return listaItens;
	}

	public void setListaItens(List<ItemPedido> listaItens) {
		this.listaItens = listaItens;
	}

	public LocalDateTime getDataHoraPedido() {
		return dataHoraPedido;
	}

	public void setDataHoraPedido(LocalDateTime dataHoraPedido) {
		this.dataHoraPedido = dataHoraPedido;
	}

	public BigDecimal getTotalPedido() {
		return totalPedido;
	}

	public void setTotalPedido(BigDecimal totalPedido) {
		this.totalPedido = totalPedido;
	}

	public String getObservacoes() {
		return observacoes;
	}

	public void setObservacoes(String observacoes) {
		this.observacoes = observacoes;
	}

	@Override
	public int hashCode() {
		return Objects.hash(dataHoraPedido, id, listaItens, observacoes, totalPedido);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Pedido other = (Pedido) obj;
		return Objects.equals(dataHoraPedido, other.dataHoraPedido) && Objects.equals(id, other.id)
				&& Objects.equals(listaItens, other.listaItens) && Objects.equals(observacoes, other.observacoes)
				&& Objects.equals(totalPedido, other.totalPedido);
	}

	
	
}
