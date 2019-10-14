package com.nelioalves.cursomc.resource;

import com.nelioalves.cursomc.domain.Produto;
import com.nelioalves.cursomc.service.ProdutoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/produtos")
@RequiredArgsConstructor
public class ProdutoResource {

	private final ProdutoService produtoService;
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<?> find(@PathVariable Integer id){
		Produto produto = produtoService.find(id);
		
		return ResponseEntity.ok().body(produto);
	}
}
