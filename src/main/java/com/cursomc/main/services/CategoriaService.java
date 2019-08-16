package com.cursomc.main.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cursomc.main.domain.Categoria;
import com.cursomc.main.repositories.CategoriaRepository;
import com.cursomc.main.services.exceptios.ObjectNotFoundException;

@Service
public class CategoriaService {

	@Autowired
	private CategoriaRepository repo;

	public Categoria buscar(Integer id) {
		Optional<Categoria> obj = repo.findById(id);
//		if(obj.get() == null) {
//			throw new ObjectNotFoundException("Objeto não encontrado, id:"+id+" Tipo: "+Categoria.class.getName());
//		}
//		else
		return obj.orElseThrow(()-> new ObjectNotFoundException("Objeto não encontrado, id:"+id+" Tipo: "+Categoria.class.getName()));
	}
}
