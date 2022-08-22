package br.com.pizzaria.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.com.pizzaria.model.DisponibilidadeIngrediente;

@Repository
public interface DisponibilidadeIngredienteRepository extends JpaRepository<DisponibilidadeIngrediente, Long>{

	public List<DisponibilidadeIngrediente> findByIngredienteId(Long id);

	@Query ("SELECT d FROM DisponibilidadeIngrediente d WHERE d.ingrediente.id = :idIngrediente AND d.atual = 'SIM' ")
	public DisponibilidadeIngrediente pesquisarDisponibilidadeAtual (Long idIngrediente);
	
}
