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
	
	public void inserirTime(Time time) throws IOException{
		dao.inserirTime(time);
	}
	
	public ArrayList<Time> listarTime(int chave) throws IOException {
		return dao.listarTime(chave);
	}
	
	public void inserirTimeNome(Time time) throws IOException{
		dao.inserirTimeNome(time);
	}
	
	
	public ArrayList<Time> listarTime(String chave) throws IOException{
		return dao.listarTime(chave);
	}
	
	public ArrayList<Time> listarTime() throws IOException{
		return dao.listarTime();
	}
	/////////////////////////////////////////////////////////
	public void atualizarTime(Time time) {
		dao.atualizarTime(time);
	}
	
	public void excluirTime(Time time) {
		dao.excluirTime(time);
	}
	
	public Time buscarTime(int id) throws IOException {
		return dao.buscarTime(id);
	}
}	
