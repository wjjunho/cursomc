package com.nelioalves.cursomc.resource;

import com.nelioalves.cursomc.domain.Categoria;
import com.nelioalves.cursomc.service.CategoriaService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/categorias")
@RequiredArgsConstructor
public class CategoriaResource {

	private final CategoriaService categoriaService;
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<?> find(@PathVariable Integer id) {
		
		Categoria cat = categoriaService.find(id);
		
		return ResponseEntity.ok().body(cat);
	}
}
