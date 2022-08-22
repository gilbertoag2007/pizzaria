package br.com.pizzaria.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import br.com.pizzaria.model.Pizza;

/**
 * Interface com os metodos para persistencia das informacoes da pizza.
 * 
 * @author Gilberto Cunha
 * 
 * */

@Repository
public interface PizzaRepository extends PagingAndSortingRepository<Pizza, Long>{

}
