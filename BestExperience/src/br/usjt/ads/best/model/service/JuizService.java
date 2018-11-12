package br.usjt.ads.best.model.service;

import java.io.IOException;
import java.util.ArrayList;

import br.usjt.ads.best.model.entity.Juiz;


public class JuizService {
private JuizService dao;
	
	public JuizService() {
		dao = new JuizService();
	}
	
	public ArrayList<Juiz> listarJuiz(String chave) throws IOException{
		return dao.listarJuiz(chave);
	}
	
	/*
	public ArrayList<Jogador> listarJogador() throws IOException{
		return dao.listarJogador();
	}*/
}
