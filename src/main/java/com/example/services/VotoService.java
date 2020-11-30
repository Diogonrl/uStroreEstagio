package com.example.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.domain.Voto;
import com.example.repositories.VotoRepository;

@Service
public class VotoService {

	@Autowired
	private VotoRepository repo;

	public List<Voto> findAll() {
		return repo.findAll();
	}

	public Voto find(Integer id) {
		Optional<Voto> obj = repo.findById(id);
		return obj.orElse(null);
	}

	public Voto insert(Voto obj) {
		obj.setId(null);
		return repo.save(obj);
	}

}
