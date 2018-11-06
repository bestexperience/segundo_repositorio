package br.usjt.ads.best.model.service;

import java.io.IOException;
import java.util.ArrayList;

import br.usjt.ads.best.model.dao.StatusDAO;
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
}
