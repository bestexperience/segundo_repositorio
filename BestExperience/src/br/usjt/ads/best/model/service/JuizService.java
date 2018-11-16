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
	
	public ArrayList<Juiz> listarJuiz(String chave) throws IOException{
		return dao.listarJuiz(chave);
	}
	
	/*
	public ArrayList<Jogador> listarJogador() throws IOException{
		return dao.listarJogador();
	}*/
}
