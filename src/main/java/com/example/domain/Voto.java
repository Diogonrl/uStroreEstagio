package com.example.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

@Entity
public class Voto implements Serializable {

	private static final long serialVersionUID = 1L;


	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	

	private Date horaVoto;


	@ManyToOne
	@JoinColumn(name = "eleitor_id")
	private Eleitor eleitor;
	
	@ManyToMany
	@JoinTable(name = "CANDIDATOS_VOTOS", 
	joinColumns = @JoinColumn(name = "voto_id"), 
	inverseJoinColumns = @JoinColumn(name = "candidato_id")
	)
	private List<Candidato> candidatos= new ArrayList<>();

	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Date getHoraVoto() {
		return horaVoto;
	}
	public void setHoraVoto(Date horaVoto) {
		this.horaVoto = horaVoto;
	}

	public Eleitor getEleitor() {
		return eleitor;
	}
	public void setEleitor(Eleitor eleitor) {
		this.eleitor = eleitor;
	}
	public List<Candidato> getCandidatos() {
		return candidatos;
	}
	public void setCandidatos(List<Candidato> candidatos) {
		this.candidatos = candidatos;
	}
	public Voto(Integer id, Date horaVoto, Eleitor eleitor) {
		super();
		this.id=id;
		this.horaVoto = horaVoto;
		this.eleitor = eleitor;
	}
	public Voto() {}


	
}
