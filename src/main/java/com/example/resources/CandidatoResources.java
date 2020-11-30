package com.example.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.domain.Candidato;
import com.example.services.CandidatoService;

@RestController
@RequestMapping(value = "/candidato")
public class CandidatoResources {

	@Autowired
	private CandidatoService service;

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<List<Candidato>> findTipo(@PathVariable Integer id) {
		List<Candidato> list = service.findTipo(id);
		return ResponseEntity.ok().body(list);

	}
	
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<Candidato>> findAll() {
		List<Candidato> list = service.findAll();
		return ResponseEntity.ok().body(list);

	}
	

	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	public ResponseEntity<Void> update(@RequestBody Candidato candidato, @PathVariable Integer id) {
		
		candidato.setNumCand(id);
		candidato = service.update(candidato);
		return ResponseEntity.noContent().build();

	}
	
}
