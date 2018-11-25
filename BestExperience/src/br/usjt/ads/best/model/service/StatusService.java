package br.usjt.ads.best.model.service;

import java.io.IOException;
import java.util.ArrayList;

import br.usjt.ads.best.model.dao.StatusDAO;
import br.usjt.ads.best.model.entity.Resultados_definidos;
import br.usjt.ads.best.model.entity.Status;
	

public class StatusService {
	private StatusDAO dao;
	
	public StatusService(){
		this.dao = new StatusDAO();
	}
	public ArrayList<Status> listarStatus() throws IOException{
		return dao.listarStatus();
	}
	public int inserirPontos(int ponto, int id_campeonato, int id_status) throws IOException {
		int id = dao.inserirPontos(ponto, id_campeonato, id_status);
		return id;
	}
	public void excluirCampeonato(int resultados_definidos) {
		dao.excluirResultados(resultados_definidos);
	}
	
	public ArrayList<Resultados_definidos> listarResultadosDefinidos(int id) throws IOException {
		return dao.listarResultadosDefinidos(id);
	}
	public void atualizarResultados(int pontos, int id_pontos) {
		dao.atualizarResultados(pontos, id_pontos);
	}
}
