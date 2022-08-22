package br.com.pizzaria.repository;

import org.springframework.data.repository.PagingAndSortingRepository;

import br.com.pizzaria.model.Entrega;


/**
 * Interface com os metodos para persistencia das informacoes de uma entrega.
 * 
 * @author Gilberto Cunha
 * 
 * */
public interface EntregaRepository extends PagingAndSortingRepository<Entrega, Long>{

}
