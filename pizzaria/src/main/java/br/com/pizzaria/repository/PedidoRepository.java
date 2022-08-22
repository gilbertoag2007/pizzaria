package br.com.pizzaria.repository;

import org.springframework.data.repository.PagingAndSortingRepository;

import br.com.pizzaria.model.Pedido;


/**
 * Interface com os metodos para persistencia das informacoes de um pedido.
 * 
 * @author Gilberto Cunha
 * 
 * */
public interface PedidoRepository extends PagingAndSortingRepository<Pedido, Long> {

}
