package br.usjt.ads.best.model.service;

import java.io.IOException;
import java.util.ArrayList;

import br.usjt.ads.best.model.dao.TimeCampeonatoDAO;
import br.usjt.ads.best.model.entity.TimeCampeonato;

public class TimeCampeonatoService {
	private TimeCampeonatoDAO dao;
	
	public TimeCampeonatoService(){
		this.dao = new TimeCampeonatoDAO();
	}
	
	public ArrayList<TimeCampeonato> listarTimeCampeonato() throws IOException {
		return dao.listarTimeCampeonato();
	}
	
	public int inserirTimeCampeonato(TimeCampeonato timeC) throws IOException {
		return dao.inserirTimeCampeonato(timeC);
	}
	
	public TimeCampeonato buscarTimeCampeonato(int id) throws IOException {
		return dao.buscarTimeCampeonato(id);
	}
}
