package br.usjt.ads.best.model.service;

import java.io.IOException;
import java.util.ArrayList;

import br.usjt.ads.best.model.dao.EstatisticaDAO;
import br.usjt.ads.best.model.entity.Estatistica;

public class EstatisticaService {
	private EstatisticaDAO dao;
	
	public EstatisticaService(){
		this.dao = new EstatisticaDAO();
	}
	
	public int inserirEstatistica(Estatistica estatistica) throws IOException {
		return dao.inserirEstatistica(estatistica);
	}
	
	public ArrayList<Estatistica> listarEstatistica() throws IOException {
		return dao.listarEstatistica();
	}
	
	public ArrayList<Estatistica> listarEstatistica(int chave) throws IOException {
		return dao.listarEstatistica(chave);
	}
	public Estatistica listarEstatistica2(int chave) throws IOException {
		return dao.listarEstatistica2(chave);
	}
	
	public void atualizarEstatistica(Estatistica estatistica) {
		dao.atualizarEstatistica(estatistica);
	}
}
