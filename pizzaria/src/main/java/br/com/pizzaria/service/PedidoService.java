package br.com.pizzaria.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.pizzaria.model.Pedido;
import br.com.pizzaria.repository.PedidoRepository;

/**
 * Classe de servicos relacionado aos pedidos.
 * 
 * @author Gilberto Cunha
 *
 */
@Service
public class PedidoService {

	@Autowired
	PedidoRepository pedidoRepository;
	
	public void salvar(Pedido pedido) {
		pedidoRepository.save(pedido);
	}
	
	public void deletar(Pedido pedido) {
		pedidoRepository.delete(pedido);
	}
	
	public void listarTodos(Pedido pedido) {
		pedidoRepository.findAll();
	}
	
	public Optional pesquisarPorId(Long id) {
		Optional<Pedido> pedido =  pedidoRepository.findById(id);
		return pedido;
	}
	
}
