package br.usjt.ads.best.model.entity;

public class Estatistica {
	private int idEstatistica;
	private int score;
	private int chute_fora;
	private int saves;
	private int escanteios;
	private int faltas;
	private int laterais;
	private int passes_de_bola;
	private int defesas;
	private int bola_fora;
	private Time time;
	private Jogos jogos;
	
	public int getIdEstatistica() {
		return idEstatistica;
	}
	public void setIdEstatistica(int idEstatistica) {
		this.idEstatistica = idEstatistica;
	}
	public int getScore() {
		return score;
	}
	public void setScore(int score) {
		this.score = score;
	}
	public int getChute_fora() {
		return chute_fora;
	}
	public void setChute_fora(int chute_fora) {
		this.chute_fora = chute_fora;
	}
	public int getSaves() {
		return saves;
	}
	public void setSaves(int saves) {
		this.saves = saves;
	}
	public int getEscanteios() {
		return escanteios;
	}
	public void setEscanteios(int escanteios) {
		this.escanteios = escanteios;
	}
	public int getFaltas() {
		return faltas;
	}
	public void setFaltas(int faltas) {
		this.faltas = faltas;
	}
	public int getLaterais() {
		return laterais;
	}
	public void setLaterais(int laterais) {
		this.laterais = laterais;
	}
	public int getPasses_de_bola() {
		return passes_de_bola;
	}
	public void setPasses_de_bola(int passes_de_bola) {
		this.passes_de_bola = passes_de_bola;
	}
	public int getDefesas() {
		return defesas;
	}
	public void setDefesas(int defesas) {
		this.defesas = defesas;
	}
	public int getBola_fora() {
		return bola_fora;
	}
	public void setBola_fora(int bola_fora) {
		this.bola_fora = bola_fora;
	}
	public Time getTime() {
		return time;
	}
	public void setTime(Time time) {
		this.time = time;
	}
	public Jogos getJogos() {
		return jogos;
	}
	public void setJogos(Jogos jogos) {
		this.jogos = jogos;
	}
	
	
}
