package br.usjt.ads.best.model.service;

import java.io.IOException;
import java.util.ArrayList;

import br.usjt.ads.best.model.dao.CampeonatoDAO;
import br.usjt.ads.best.model.entity.Campeonato;
import br.usjt.ads.best.model.entity.Usuario;

	public class CampeonatoService {
		private CampeonatoDAO dao;
	
	public CampeonatoService() {
		dao = new CampeonatoDAO();
	}
	
	public int inserirCampeonato(Campeonato campeonato, Usuario usuario) throws IOException {
		return dao.inserirCampeonato(campeonato, usuario);
	}
	
	public Campeonato buscarCampeonato(Campeonato campeonato) throws IOException {
		return dao.buscarCampeonato(campeonato);
	}
	
	public Campeonato buscarCampeonatoPeloId(int chave) throws IOException{
		return dao.buscarCampeonatoPeloId(chave);
	}
	
	public Campeonato buscarCampeonato(String nome) throws IOException{
		return dao.buscarCampeonato(nome);
	}
	
	public void excluirCampeonato(Campeonato campeonato) {
		dao.excluirCampeonato(campeonato);
	}
	
	public void atualizarCampeonato(Campeonato campeonato) {
		dao.atualizarCampeonato(campeonato);
	}
	
	public ArrayList<Campeonato> listarCampeonatos(String chave) throws IOException{
		return dao.listarCampeonatos(chave);
	}
	
	public ArrayList<Campeonato> listarCampeonatos() throws IOException{
		return dao.listarCampeonatos();
	}
}
