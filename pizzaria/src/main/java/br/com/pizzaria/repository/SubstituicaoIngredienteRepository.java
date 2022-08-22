package br.com.pizzaria.repository;

import org.springframework.data.repository.PagingAndSortingRepository;

import br.com.pizzaria.model.SubstituicaoIngrediente;

/**
 * Interface com os metodos para persistencia das informacoes de substituicao de iingredientes de uma pizza dentro de uma pedido.
 * 
 * @author Gilberto Cunha
 * 
 * */
public interface SubstituicaoIngredienteRepository extends PagingAndSortingRepository<SubstituicaoIngrediente
, Long> {

}
