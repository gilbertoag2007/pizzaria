package br.com.pizzaria.controller;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import br.com.pizzaria.controller.dto.IngredienteDto;
import br.com.pizzaria.model.Ingrediente;
import br.com.pizzaria.service.IngredienteService;

@RestController()
@RequestMapping("/ingredientes")
public class IngredienteController {
	
	@Autowired
	private IngredienteService ingredienteService;
		
	@GetMapping
	public List<IngredienteDto> listar() {
		return ingredienteService.listarTodos(); 
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<IngredienteDto> pesquisarPorId(@PathVariable Long id) {
		Optional<Ingrediente> optional = ingredienteService.pesquisarPorId(id);
		
		if (optional.isPresent()) {
			IngredienteDto ingredienteDto = new IngredienteDto(optional.get());
			return ResponseEntity.ok(ingredienteDto);
		}
		
		return ResponseEntity.notFound().build();
	}
	
	@PostMapping
	@Transactional
	public ResponseEntity<IngredienteDto> cadastrar(@RequestBody @Valid IngredienteDto formulario, UriComponentsBuilder uriBuilder) {
		
		IngredienteDto resultadoDto =  ingredienteService.cadastrar(formulario);
		URI uri = uriBuilder.path("/ingredientes/{id}").buildAndExpand(resultadoDto.getId()).toUri();
		
		return ResponseEntity.created(uri).body(resultadoDto);
	}
	
	@PutMapping("/{id}")
	@Transactional
	public ResponseEntity<IngredienteDto> atualizar(@RequestBody @Valid IngredienteDto formulario, UriComponentsBuilder uriBuilder) {
		
		IngredienteDto resultadoDto =  ingredienteService.atualizar(formulario);
		URI uri = uriBuilder.path("/ingredientes/{id}").buildAndExpand(resultadoDto.getId()).toUri();
		
		return ResponseEntity.created(uri).body(resultadoDto);
	}
	
	@DeleteMapping("/{id}")
	@Transactional
	public ResponseEntity<?> remover(@PathVariable Long id) {
		Optional<Ingrediente> optional = ingredienteService.deletar(id);
		
		if (optional.isPresent()) {
			return ResponseEntity.ok().build();
		}
		
		return ResponseEntity.notFound().build();
	}
	
}
