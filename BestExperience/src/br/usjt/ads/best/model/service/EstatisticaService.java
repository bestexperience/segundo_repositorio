package br.usjt.ads.best.model.service;

import java.io.IOException;

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
}
