package br.usjt.ads.best.model.service;

import java.io.IOException;
import java.util.ArrayList;

import br.usjt.ads.best.model.dao.TimeDAO;
import br.usjt.ads.best.model.entity.Time;

public class TimeService {
	private TimeDAO dao;
	
	public TimeService(){
		this.dao = new TimeDAO();
	}
	
	public void inserirUsuario(String time) throws IOException{
		dao.inserirTime(time);
	}
	
	public ArrayList<Time> listarTime(String chave) throws IOException{
		return dao.listarTime(chave);
	}
	
	public ArrayList<Time> listarTime() throws IOException{
		return dao.listarTime();
	}
}	
