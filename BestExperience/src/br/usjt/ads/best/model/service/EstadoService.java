package br.usjt.ads.best.model.service;

import java.io.IOException;
import java.util.ArrayList;

import br.usjt.ads.best.model.dao.EstadoDAO;
import br.usjt.ads.best.model.entity.Estado;


public class EstadoService {
private EstadoDAO dao;
	
	public EstadoService() {
		this.dao = new EstadoDAO();
	}
	
	public Estado buscarCidade(int id) throws IOException {
		return dao.buscarEstado(id);
	}
	
	public ArrayList<Estado> listarEstados() throws IOException{
		return dao.listarEstados();
	}
}
