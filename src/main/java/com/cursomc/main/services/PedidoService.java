package com.cursomc.main.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cursomc.main.domain.Pedido;
import com.cursomc.main.repositories.PedidoRepository;
import com.cursomc.main.services.exceptios.ObjectNotFoundException;

@Service
public class PedidoService {

	@Autowired
	private PedidoRepository repo;

	public Pedido find(Integer id) {
		Optional<Pedido> obj = repo.findById(id);
		return obj.orElseThrow(()-> new ObjectNotFoundException("Objeto não encontrado, id:"+id+" Tipo: "+Pedido.class.getName()));
	}
	
	public List<Pedido> findAll() {
		return repo.findAll();
	}
	
}
