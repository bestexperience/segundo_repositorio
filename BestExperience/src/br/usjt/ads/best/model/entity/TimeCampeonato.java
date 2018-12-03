package br.usjt.ads.best.model.entity;

public class TimeCampeonato {
	private int classificacao;
	private Time time;
	private int pontos;
	private int jogos;
	private int vitorias;
	private int empates;
	private int derrotas;
	private int gols_marcados;
	private int gols_sofridos;
	private int saldo_de_gols;
	private double aproveitamento;
	
	public int getClassificacao() {
		return classificacao;
	}
	public void setClassificacao(int classificacao) {
		this.classificacao = classificacao;
	}
	public Time getTime() {
		return time;
	}
	public void setTime(Time time) {
		this.time = time;
	}
	public int getPontos() {
		return pontos;
	}
	public void setPontos(int pontos) {
		this.pontos = pontos;
	}
	public int getJogos() {
		return jogos;
	}
	public void setJogos(int jogos) {
		this.jogos = jogos;
	}
	public int getVitorias() {
		return vitorias;
	}
	public void setVitorias(int vitorias) {
		this.vitorias = vitorias;
	}
	public int getEmpates() {
		return empates;
	}
	public void setEmpates(int empates) {
		this.empates = empates;
	}
	public int getDerrotas() {
		return derrotas;
	}
	public void setDerrotas(int derrotas) {
		this.derrotas = derrotas;
	}
	public int getGols_marcados() {
		return gols_marcados;
	}
	public void setGols_marcados(int gols_marcados) {
		this.gols_marcados = gols_marcados;
	}
	public int getGols_sofridos() {
		return gols_sofridos;
	}
	public void setGols_sofridos(int gols_sofridos) {
		this.gols_sofridos = gols_sofridos;
	}
	public int getSaldo_de_gols() {
		return saldo_de_gols;
	}
	public void setSaldo_de_gols(int saldo_de_gols) {
		this.saldo_de_gols = saldo_de_gols;
	}
	public double getAproveitamento() {
		return aproveitamento;
	}
	public void setAproveitamento(double aproveitamento) {
		this.aproveitamento = aproveitamento;
	}
	
	
}
