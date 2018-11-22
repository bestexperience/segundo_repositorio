package br.usjt.ads.best.model.service;

import java.io.IOException;
import java.util.ArrayList;

import br.usjt.ads.best.model.dao.JogadorDAO;
import br.usjt.ads.best.model.entity.Jogador;


public class JogadorService {
private JogadorDAO dao;
	
	public JogadorService(){
		this.dao = new JogadorDAO();
	}

	public ArrayList<Jogador> listarJogador(String chave) throws IOException{
		return dao.listarJogador(chave);
	}
	
	public ArrayList<Jogador> listarJogador() throws IOException{
		return dao.listarJogador();
	}
	
	public int inserirJogador(Jogador jogador) throws IOException {
		return dao.inserirJogador(jogador);
	}
	
	public void atualizar(Jogador jogador) {
		dao.atualizar(jogador);
	}
	
	public void excluirJogador(Jogador jogador){
		dao.excluirJogador(jogador);
	}
}
