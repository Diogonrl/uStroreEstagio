package com.example.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

import com.example.domain.Eleitor;


@Repository
public interface EleitorRepository extends JpaRepository<Eleitor, Integer> {

}
