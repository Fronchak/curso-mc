package com.nelioalves.cursomc.resources;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nelioalves.cursomc.entities.Estado;
import com.nelioalves.cursomc.services.EstadoService;

@RestController
@RequestMapping(value="/estados")
public class EstadoResource {

	private EstadoService service;
	
	@GetMapping
	public ResponseEntity<List<Estado>> findAll() {
		List<Estado> list = service.findAll();
		return ResponseEntity.ok().body(list);
	}
}
