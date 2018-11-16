package br.usjt.ads.best.model.entity;

public class ComissaoExecutiva {
	private int idComissao;
	private String nomeComissao;
	private Cidade cidade;
	private Estado pais;
	private Funcao funcao;
	
	public int getIdComissao() {
		return idComissao;
	}
	public void setIdComissao(int idComissao) {
		this.idComissao = idComissao;
	}
	public String getNomeComissao() {
		return nomeComissao;
	}
	public void setNomeComissao(String nomeComissao) {
		this.nomeComissao = nomeComissao;
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
