package com.nettuf.cursomc.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nettuf.cursomc.domain.Categoria;
import com.nettuf.cursomc.repositories.CategoriaRepository;
import com.nettuf.cursomc.services.exceptions.ObjectNotFoundException;

@Service
public class CategoriaService {
	
	@Autowired
	private CategoriaRepository repo;

	public Categoria buscar(Integer id) {
		Optional<Categoria> obj = repo.findById(id);
		return obj.orElseThrow(()-> new ObjectNotFoundException(
				"Object not found! id:"+id+", tipo:"+Categoria.class.getName()));
	}
}
