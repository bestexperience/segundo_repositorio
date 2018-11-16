package br.usjt.ads.best.model.entity;

public class Auxiliares {
	private int idAuxiliar;
	private String nomeAuxiliar;
	private Cidade cidade;
	private Estado pais;
	private Funcao funcao;
	
	public int getIdAuxiliar() {
		return idAuxiliar;
	}
	public void setIdAuxiliar(int idAuxiliar) {
		this.idAuxiliar = idAuxiliar;
	}
	public String getNomeAuxiliar() {
		return nomeAuxiliar;
	}
	public void setNomeAuxiliar(String nomeAuxiliar) {
		this.nomeAuxiliar = nomeAuxiliar;
	}
	public Cidade getCidade() {
		return cidade;
	}
	public void setCidade(Cidade cidade) {
		this.cidade = cidade;
	}
	public Estado getPais() {
		return pais;
	}
	public void setPais(Estado pais) {
		this.pais = pais;
	}
	public Funcao getFuncao() {
		return funcao;
	}
	public void setFuncao(Funcao funcao) {
		this.funcao = funcao;
	}
	
	
	
	
}
