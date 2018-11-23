package br.usjt.ads.best.model.entity;

import java.util.Date;

public class Juiz{
	private int idJuiz;
	private String nomeJuiz;
	private Date data_nascimento;
	private String descricao;
	private Cidade cidade;
	private Estado estado;
	
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
	public Estado getEstado() {
		return estado;
	}
	public void setEstado(Estado estado) {
		this.estado = estado;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	
	
}
