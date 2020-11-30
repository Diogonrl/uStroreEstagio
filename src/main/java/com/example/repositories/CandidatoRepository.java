package com.example.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.domain.Candidato;

@Repository
public interface CandidatoRepository extends JpaRepository<Candidato,Integer> {

}
