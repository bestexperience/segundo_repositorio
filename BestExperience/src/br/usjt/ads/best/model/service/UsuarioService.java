package br.usjt.ads.best.model.service;

import java.io.IOException;

import br.usjt.ads.best.model.dao.UsuarioDAO;
import br.usjt.ads.best.model.entity.Usuario;

public class UsuarioService {
	private UsuarioDAO dao;
	
	public UsuarioService() {
		dao = new UsuarioDAO();
	}
	
	public Usuario consultarLogin(Usuario usuario) throws IOException{
		usuario = dao.buscarUsuario(usuario);
		return usuario;
	}
	public int inserirUsuario(Usuario usuario) throws IOException {
		int id = dao.inserirUsuario(usuario);
		return id;
	}
	
	public Usuario buscarUsuarioId(Usuario usuario) throws IOException {
		return dao.buscarUsuarioId(usuario);
	}
}
