package br.usjt.ads.best.model.entity;

import java.util.Date;

public class Juiz{
	private int idJuiz;
	private String nomeJuiz;
	private Date data_nascimento;
	private Cidade cidade;
	private Pais pais;
	
	public int getIdJuiz() {
		return idJuiz;
	}
	public void setIdJuiz(int idJuiz) {
		this.idJuiz = idJuiz;
	}
	public String getNomeJuiz() {
		return nomeJuiz;
	}
	public void setNomeJuiz(String nomeJuiz) {
		this.nomeJuiz = nomeJuiz;
	}
	public Date getData_nascimento() {
		return data_nascimento;
	}
	public void setData_nascimento(Date data_nascimento) {
		this.data_nascimento = data_nascimento;
	}
	public Cidade getCidade() {
		return cidade;
	}
	public void setCidade(Cidade cidade) {
		this.cidade = cidade;
	}
	public Pais getPais() {
		return pais;
	}
	public void setPais(Pais pais) {
		this.pais = pais;
	}
	
	
}
