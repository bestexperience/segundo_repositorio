package br.usjt.ads.best.model.service;

import java.io.IOException;
import java.util.ArrayList;

import br.usjt.ads.best.model.dao.JogoEfetivadoDAO;
import br.usjt.ads.best.model.entity.JogoEfetivado;

public class JogoEfetivadoService {
	private JogoEfetivadoDAO dao;
	
	public JogoEfetivadoService(){
		this.dao = new JogoEfetivadoDAO(); 
	}
	
	public void inserirJogo(JogoEfetivado jogo) throws IOException {
		dao.inserirJogo(jogo);
	}
	
	public ArrayList<JogoEfetivado> listarJogosEfetivado(int chave) throws IOException {
		return dao.listarJogosEfetivado(chave);
	}
	
	public void excluirJogo(int id) {
		dao.excluirJogo(id);
	}
}
