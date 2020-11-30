package com.example.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.domain.Candidato;
import com.example.repositories.CandidatoRepository;

@Service
public class CandidatoService {

	@Autowired
	private CandidatoRepository repo;
	

	public List<Candidato> findTipo(Integer id) {
		List<Candidato> lista = repo.findAll();
		List<Candidato> lista1= new ArrayList<>();
		for(int i=0; i<lista.size();i++) {
			if(lista.get(i).getTipo().getCod()==id) {
				lista1.add(lista.get(i));
			}
		}
		
		return lista1;
	} 
	
	public List<Candidato> findAll() {
		return repo.findAll();
	}
	
	public Candidato update(Candidato obj) {
		Candidato newObj = find(obj.getNumCand());
		return repo.save(newObj);
	}

	public Candidato find(Integer id) {
		 Optional<Candidato> obj = repo.findById(id);
		return obj.orElse(null);
		} 

 
}
