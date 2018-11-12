package br.usjt.ads.best.model.entity;

import java.util.Date;

public class Jogos {
	private int idJogos;
	private Date data;
	private int tempo_extra;
	private int turno;
	private String comentarios;
	private String periodo;
	private Campeonato campeonato;
	
	public int getIdJogos() {
		return idJogos;
	}
	public void setIdJogos(int idJogos) {
		this.idJogos = idJogos;
	}
	public Date getData() {
		return data;
	}
	public void setData(Date data) {
		this.data = data;
	}
	public int getTempo_extra() {
		return tempo_extra;
	}
	public void setTempo_extra(int tempo_extra) {
		this.tempo_extra = tempo_extra;
	}
	public int getTurno() {
		return turno;
	}
	public void setTurno(int turno) {
		this.turno = turno;
	}
	public String getComentarios() {
		return comentarios;
	}
	public void setComentarios(String comentarios) {
		this.comentarios = comentarios;
	}
	public String getPeriodo() {
		return periodo;
	}
	public void setPeriodo(String periodo) {
		this.periodo = periodo;
	}
	public Campeonato getCampeonato() {
		return campeonato;
	}
	public void setCampeonato(Campeonato campeonato) {
		this.campeonato = campeonato;
	}
	
	
	
}
