package br.usjt.ads.best.model.entity;

import java.util.Date;

public class Jogador {
	private int idJogador;
	private String nomeJogador;
	private Date nascimento_jogador;
	private int gols;
	private Time time;
	
	public int getIdJogador() {
		return idJogador;
	}
	public void setIdJogador(int idJogador) {
		this.idJogador = idJogador;
	}
	public String getNomeJogador() {
		return nomeJogador;
	}
	public void setNomeJogador(String nomeJogador) {
		this.nomeJogador = nomeJogador;
	}
	public Time getTime() {
		return time;
	}
	public void setTime(Time time) {
		this.time = time;
	}
	public Date getNascimento_jogador() {
		return nascimento_jogador;
	}
	public void setNascimento_jogador(Date nascimento_jogador) {
		this.nascimento_jogador = nascimento_jogador;
	}
	public int getGols() {
		return gols;
	}
	public void setGols(int gols) {
		this.gols = gols;
	}
	
	
	
	
}
