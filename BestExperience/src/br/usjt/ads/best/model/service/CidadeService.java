package br.usjt.ads.best.model.service;

import java.io.IOException;
import java.util.ArrayList;

import br.usjt.ads.best.model.dao.CidadeDAO;
import br.usjt.ads.best.model.entity.Cidade;


public class CidadeService {
private CidadeDAO dao;
	
	public CidadeService() {
		this.dao = new CidadeDAO();
	}
	
	public Cidade buscarCidade(int id) throws IOException {
		return dao.buscarCidade(id);
	}
	
	public ArrayList<Cidade> listarCidades() throws IOException{
		return dao.listarCidade();
	}

}
