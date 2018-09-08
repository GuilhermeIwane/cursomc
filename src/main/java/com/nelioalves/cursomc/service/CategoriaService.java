package com.nelioalves.cursomc.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nelioalves.cursomc.domain.Categoria;
import com.nelioalves.cursomc.exception.ObjectNotFoundException;
import com.nelioalves.cursomc.repository.CategoriaRepository;


@Service
public class CategoriaService {

	CategoriaRepository repo;
	
	@Autowired
	public CategoriaService(final CategoriaRepository categoriaRepository) {
		this.repo = categoriaRepository;
	}
	
	public Categoria buscar(Integer id) {
		Optional<Categoria> obj = repo.findById(id);
		return obj.orElse(null);
	}
	
	public Categoria find(Integer id) {
		Optional<Categoria> optional = repo.findById(id);
		return optional.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! Id: " + id + ", Tipo: " + Categoria.class.getSimpleName()));
	}
}
