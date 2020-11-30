package com.example.domain.enums;

public enum TipoCandidato {

	PRESIDENTE(1, "presidente"), SENADOR(2, "senador"), GOVERNADOR(3, "governador"), DEPESTADUAL(4, "deputado estadual"), DEPFEDERAL(5, "deupatado federal");

	private int cod;
	private String cargo;
	private TipoCandidato(int cod, String cargo) {
		this.cod = cod;
		this.cargo = cargo;
	}
	public int getCod() {
		return cod;
	}
	public void setCod(int cod) {
		this.cod = cod;
	}
	public String getCargo() {
		return cargo;
	}
	public void setCargo(String cargo) {
		this.cargo = cargo;
	}

	public static TipoCandidato toEnum(Integer cod) {

		if (cod == null) {
			return null;
		}
		for (TipoCandidato x : TipoCandidato.values()) {
			if (cod.equals(x.getCod())) {
				return x;
			}
		}
		throw new IllegalArgumentException("Id inválido: " + cod);
	}

	
}
