package br.usjt.ads.best.model.service;

import java.io.IOException;

import br.usjt.ads.best.model.dao.JogosDAO;
import br.usjt.ads.best.model.entity.Jogos;

public class JogosService {
	private JogosDAO dao;
	
	public JogosService(){
		this.dao = new JogosDAO();
	}
	
	public int inserirJogos(Jogos jogos) throws IOException {
		return dao.inserirJogos(jogos);
	}

}
