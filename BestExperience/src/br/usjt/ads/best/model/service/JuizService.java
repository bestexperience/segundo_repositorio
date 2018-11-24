package br.usjt.ads.best.model.service;

import java.io.IOException;
import java.util.ArrayList;

import br.usjt.ads.best.model.dao.JuizDAO;
import br.usjt.ads.best.model.entity.Juiz;

public class JuizService {
	private JuizDAO dao;
	
	public JuizService() {
		this.dao = new JuizDAO();
	}
	
	public Juiz buscarJuiz(int id) throws IOException {
		return dao.buscarJuiz(id);
	}
	
	public ArrayList<Juiz> listarJuiz(String chave) throws IOException{
		return dao.listarJuiz(chave);
	}
	
	public ArrayList<Juiz> listarJuiz() throws IOException{
		return dao.listarJuiz();
	}
	
	public int inserirJuiz(Juiz juiz) throws IOException {
		return dao.inserirJuiz(juiz);
	}
	
	public void atualizarJuiz(Juiz juiz){
		dao.atualizarJuiz(juiz);
	}
	
	public void excluirJuiz(Juiz juiz) {
		dao.excluirJuiz(juiz);
	}
}
