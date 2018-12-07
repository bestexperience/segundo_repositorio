package br.usjt.ads.best.model.entity;

public class Campeonato {
	private int idCampeonato;
	private String nome;
	private int numeroRodadas;
	private String tipo;
	private Usuario usuario;
	
	public int getIdCampeonato() {
		return idCampeonato;
	}
	public void setIdCampeonato(int idCampeonato) {
		this.idCampeonato = idCampeonato;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public int getNumeroRodadas() {
		return numeroRodadas;
	}
	public void setNumeroRodadas(int numeroRodadas) {
		this.numeroRodadas = numeroRodadas;
	}
	public Usuario getUsuario() {
		return usuario;
	}
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	
	
}
