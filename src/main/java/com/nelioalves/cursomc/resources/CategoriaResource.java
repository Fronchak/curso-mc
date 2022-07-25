package com.nelioalves.cursomc.resources;

import java.util.Arrays;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.nelioalves.cursomc.entities.Categoria;
import com.nelioalves.cursomc.services.CategoriaService;

@RestController
@RequestMapping(value = "/categorias")
public class CategoriaResource {

	private CategoriaService service;
	
	@RequestMapping(method=RequestMethod.GET)
	public List<Categoria> testar() {
		Categoria cat1 = new Categoria(1, "INformática");
		Categoria cat2 = new Categoria(2, "Escritório");
		List<Categoria> list = Arrays.asList(cat1, cat2);
		return list;
	}
	/*
	@GetMapping
	public ResponseEntity<List<Categoria>> findAll() {
		List<Categoria> list = service.findAll();
		return ResponseEntity.ok().body(list);
	}
	*/
	
}
