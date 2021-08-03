package com.nettuf.cursomc.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nettuf.cursomc.domain.Pedido;
import com.nettuf.cursomc.repositories.PedidoRepository;
import com.nettuf.cursomc.services.exceptions.ObjectNotFoundException;

@Service
public class PedidoService {
	
	@Autowired
	private PedidoRepository repo;

	public Pedido buscar(Integer id) {
		Optional<Pedido> obj = repo.findById(id);
		return obj.orElseThrow(()-> new ObjectNotFoundException(
				"Object not found! id:"+id+", tipo:"+Pedido.class.getName()));
	}
}
