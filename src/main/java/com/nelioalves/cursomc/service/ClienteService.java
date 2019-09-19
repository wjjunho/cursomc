package com.nelioalves.cursomc.service;

import com.nelioalves.cursomc.domain.Cliente;
import com.nelioalves.cursomc.exception.ObjectNotFoundException;
import com.nelioalves.cursomc.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ClienteService {

	@Autowired
	private ClienteRepository clienteRepository;
	
	public Cliente find(Integer id) {
		
		Optional<Cliente> clientes = clienteRepository.findById(id);
		
		return clientes.orElseThrow(() -> new ObjectNotFoundException(
								"Objeto não encontrado! Id: " + id + ", Objeto: " + Cliente.class.getName()));
	}
}
