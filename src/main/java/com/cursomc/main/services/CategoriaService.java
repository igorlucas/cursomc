package com.cursomc.main.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.cursomc.main.DTO.CategoriaDTO;
import com.cursomc.main.domain.Categoria;
import com.cursomc.main.repositories.CategoriaRepository;
import com.cursomc.main.services.exceptios.DataIntegrityException;
import com.cursomc.main.services.exceptios.ObjectNotFoundException;

@Service
public class CategoriaService {

	@Autowired
	private CategoriaRepository repo;

	public Categoria find(Integer id) {
		Optional<Categoria> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado, id:" + id + " Tipo: " + Categoria.class.getName()));
	}

	public List<Categoria> findAll() {
		return repo.findAll();

	}

	public Categoria insert(Categoria obj) {
		obj.setId(null);
		return repo.save(obj);
	}

	public Categoria update(Categoria obj) {
		Optional<Categoria> newObj  = repo.findById(obj.getId());
		updateData(newObj.get(), obj);
		return repo.save(newObj.get());
	}

	private void updateData(Categoria newObj, Categoria obj) {
		newObj.setNome(obj.getNome());
	}

	public void delete(Integer id) {

		find(id);
		try {
			repo.deleteById(id);
		} catch (DataIntegrityViolationException e) {
			throw new DataIntegrityException("Não é possível excluir uma categoria que possue produto");
		}
	}

	public Page<Categoria> findPage(Integer page, Integer linesPerPage, String direction, String orderBy) {
		PageRequest pageRequest = PageRequest.of(page, linesPerPage, Direction.valueOf(direction), orderBy);
		return repo.findAll(pageRequest);
	}

	public Categoria fromDto(CategoriaDTO obj) {
		return new Categoria(obj.getId(), obj.getNome());
	}

}
