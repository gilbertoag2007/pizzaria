package br.com.pizzaria.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.pizzaria.model.Ingrediente;

/**
 * Interface com os metodos para persistencia das informacoes de um ingrediente.
 * 
 * @author Gilberto Cunha
 * 
 * */
@Repository
public interface IngredienteRepository extends JpaRepository<Ingrediente, Long> {

}
