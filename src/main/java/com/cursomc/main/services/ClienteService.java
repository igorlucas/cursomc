package com.cursomc.main.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cursomc.main.domain.Cliente;
import com.cursomc.main.repositories.ClienteRepository;
import com.cursomc.main.services.exceptios.ObjectNotFoundException;

@Service
public class ClienteService {

	@Autowired
	private ClienteRepository repo;

	public Cliente buscar(Integer id) {
		Optional<Cliente> obj = repo.findById(id);

		return obj.orElseThrow(()-> new ObjectNotFoundException("Objeto não encontrado, id:"+id+" Tipo: "+Cliente.class.getName()));
	}
}
