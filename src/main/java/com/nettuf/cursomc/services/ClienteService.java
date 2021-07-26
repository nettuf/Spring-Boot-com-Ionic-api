package com.nettuf.cursomc.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nettuf.cursomc.domain.Cliente;
import com.nettuf.cursomc.repositories.ClienteRepository;
import com.nettuf.cursomc.services.exceptions.ObjectNotFoundException;

@Service
public class ClienteService {
	
	@Autowired
	private ClienteRepository repo;

	public Cliente buscar(Integer id) {
		Optional<Cliente> obj = repo.findById(id);
		return obj.orElseThrow(()-> new ObjectNotFoundException(
				"Object not found! id:"+id+", tipo:"+Cliente.class.getName()));
	}
}
