package br.usjt.ads.best.model.entity;

import java.util.Date;

public class JogoEfetivado {
	private int id_sumula;
	private int turno;
	private Date data;
	private Time time_visitante;
	private int placar_visitante;
	private Time time_mandante;
	private int placar_mandante;
	private Campeonato campeonato;
	
	public int getId_sumula() {
		return id_sumula;
	}
	public void setId_sumula(int id_sumula) {
		this.id_sumula = id_sumula;
	}
	public Date getData() {
		return data;
	}
	public void setData(Date data) {
		this.data = data;
	}
	public Time getTime_visitante() {
		return time_visitante;
	}
	public void setTime_visitante(Time time_visitante) {
		this.time_visitante = time_visitante;
	}
	public int getPlacar_visitante() {
		return placar_visitante;
	}
	public void setPlacar_visitante(int placar_visitante) {
		this.placar_visitante = placar_visitante;
	}
	public Time getTime_mandante() {
		return time_mandante;
	}
	public void setTime_mandante(Time time_mandante) {
		this.time_mandante = time_mandante;
	}
	public int getPlacar_mandante() {
		return placar_mandante;
	}
	public void setPlacar_mandante(int placar_mandante) {
		this.placar_mandante = placar_mandante;
	}
	public Campeonato getCampeonato() {
		return campeonato;
	}
	public void setCampeonato(Campeonato campeonato) {
		this.campeonato = campeonato;
	}
	public int getTurno() {
		return turno;
	}
	public void setTurno(int turno) {
		this.turno = turno;
	}
	
	
	
	
}
