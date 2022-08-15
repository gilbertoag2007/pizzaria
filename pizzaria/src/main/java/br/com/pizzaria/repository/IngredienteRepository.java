package br.com.pizzaria.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import br.com.pizzaria.model.Ingrediente;

@Repository
public interface IngredienteRepository extends PagingAndSortingRepository<Ingrediente, Integer> {

}
