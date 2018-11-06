package br.usjt.ads.best.model.dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import br.usjt.ads.best.model.entity.Usuario;


public class UsuarioDAO {
	public int inserirUsuario(Usuario usuario) throws IOException {
		int id = -1;
		String sql = "insert into campeonato.usuario (login, senha, nome, email) values (?,?,?,?)";
		
		try(Connection conn = ConnectionFactory.getConnection();
			PreparedStatement pst = conn.prepareStatement(sql);){
			
			pst.setString(1, usuario.getLogin());
			pst.setString(2, usuario.getSenha());
			pst.setString(3, usuario.getNome());
			pst.setString(4, usuario.getEmail());
			pst.execute();
			
			//obter o id criado
			String query = "select LAST_INSERT_ID()";
			try(PreparedStatement pst1 = conn.prepareStatement(query);
				ResultSet rs = pst1.executeQuery();){

				if (rs.next()) {
					id = rs.getInt(1);
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new IOException(e);
		}
		return id;
	}
	
	public Usuario buscarUsuario(Usuario usuario) throws IOException{
		Usuario usuAutenticado = null;
		
		String sql = "select * from usuario where login = ? and senha = ?";
		
		
		try(Connection conn = ConnectionFactory.getConnection();
				PreparedStatement pst = conn.prepareStatement(sql);){
			pst.setString(1, usuario.getLogin());
			pst.setString(2, usuario.getSenha());
			
			try(ResultSet rs = pst.executeQuery();){
		
				if(rs.next()) {
					usuAutenticado = new Usuario();
					usuAutenticado.setLogin(rs.getString("login"));
					usuAutenticado.setSenha(rs.getString("senha"));
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new IOException(e);
		}
		return usuAutenticado;
	}
	
	public Usuario buscarUsuarioId(Usuario usuario) throws IOException{
		String sql = "select * from usuario where login = ?";
		
		/*Validação do usuario*/
		String usu = usuario.getLogin();
		String password = usuario.getSenha();
		
		try(Connection conn = ConnectionFactory.getConnection();
				PreparedStatement pst = conn.prepareStatement(sql);){
			pst.setString(1, usuario.getLogin());
			
			try(ResultSet rs = pst.executeQuery();){
		
				while(rs.next()) {
					usuario.setId(rs.getInt("id"));
					usuario.setLogin(rs.getString("login"));
					usuario.setSenha(rs.getString("senha"));
					usuario.setNome(rs.getString("nome"));
					usuario.setEmail(rs.getString("email"));
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new IOException(e);
		}
		return usuario;
	}
}
