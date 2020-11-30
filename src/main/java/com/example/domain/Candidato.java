package com.example.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

import com.example.domain.enums.TipoCandidato;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Candidato implements Serializable {

	private static final long serialVersionUID = 1L;
	@JsonIgnore
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String nome;

	@JsonIgnore
	private Integer tipo;
	private Integer numCand;

	@JsonIgnore
	@ManyToMany(mappedBy = "candidatos")
	private List<Voto> votos= new ArrayList<>();
	
	private int qntVoto;
	
	
	public Candidato() {
	}

	public Candidato(Integer id, String nome, TipoCandidato tipo, int numCand) {
		super();
		this.id=id;
		this.nome = nome;
		this.tipo = (tipo == null) ? null : tipo.getCod();
		this.numCand = numCand;

	}
	public int getqntVoto() {
		this.qntVoto=this.votos.size();
		return qntVoto;
		}
	public void setqntVoto() {
		this.qntVoto=getqntVoto()+1;
	}

	public List<Voto> getVotos() {
		return votos;
	}

	public void setVotos(List<Voto> votos) {
		this.votos = votos;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getNumCand() {
		return numCand;
	}

	public void setNumCand(Integer numCand) {
		this.numCand = numCand;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public TipoCandidato getTipo() {
		return TipoCandidato.toEnum(tipo);
	}

	public void setTipo(TipoCandidato tipo) {
		this.tipo = tipo.getCod();
	}

}
