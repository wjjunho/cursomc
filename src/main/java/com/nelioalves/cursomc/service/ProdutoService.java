package com.nelioalves.cursomc.service;

import com.nelioalves.cursomc.domain.Produto;
import com.nelioalves.cursomc.exception.ObjectNotFoundException;
import com.nelioalves.cursomc.repository.ProdutoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ProdutoService {

	private final ProdutoRepository produtoRepository;
	
	public Produto find(Integer id){
		Optional<Produto> produtos = produtoRepository.findById(id);
		
		return produtos.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! Id: " + id + ", Objjeto: " + Produto.class.getName()));
	}
}
