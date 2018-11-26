package br.usjt.ads.best.model.dao;

import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import br.usjt.ads.best.model.entity.Usuario;


public class UsuarioDAO {
	public int inserirUsuario(Usuario usuario) throws IOException {
		int id = -1;
		String sql = "insert into campeonato.usuario (login, senha, nome, email) values (?,?,?,?)";
		
		String senha = usuario.getSenha();
		
		try(Connection conn = ConnectionFactory.getConnection();
			PreparedStatement pst = conn.prepareStatement(sql);){
			
			MessageDigest md = MessageDigest.getInstance("SHA-256");
			byte messageDigest[] = md.digest(senha.getBytes("UTF-8"));
			
			StringBuilder sb = new StringBuilder();
			
			for(byte b : messageDigest){
				sb.append(String.format("%02X", 0xFF & b));
			}
			
			String senhaHex = sb.toString();
			
			pst.setString(1, usuario.getLogin());
			pst.setString(2, senhaHex);
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
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return id;
	}
	
	public Usuario buscarUsuario(Usuario usuario) throws IOException{
		Usuario usuAutenticado = null;
		String senha = usuario.getSenha();
		String sql = "select * from usuario where login = ? and senha = ?";
		
		
		try(Connection conn = ConnectionFactory.getConnection();
				PreparedStatement pst = conn.prepareStatement(sql);){
			
			
			MessageDigest md = MessageDigest.getInstance("SHA-256");
			byte messageDigest[] = md.digest(senha.getBytes("UTF-8"));
			
			StringBuilder sb = new StringBuilder();
			
			for(byte b : messageDigest){
				sb.append(String.format("%02X", 0xFF & b));
			}
			
			String senhaHex = sb.toString();
			
			
			pst.setString(1, usuario.getLogin());
			pst.setString(2, senhaHex);
			
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
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
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
	
	public Usuario buscarUsuarioId2(Usuario usuario) throws IOException{
		String sql = "select * from usuario where id = ?";
		
		/*Validação do usuario*/
		String usu = usuario.getLogin();
		String password = usuario.getSenha();
		
		try(Connection conn = ConnectionFactory.getConnection();
				PreparedStatement pst = conn.prepareStatement(sql);){
			pst.setInt(1, usuario.getId());
			
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
	
	public Usuario buscarUsuarioPeloEmail(Usuario usuario) throws IOException{
		String sql = "select * from usuario where login = ? and email = ?";
		
		/*Validação do usuario*/
		String usu = usuario.getLogin();
		String email = usuario.getEmail();
		
		try(Connection conn = ConnectionFactory.getConnection();
				PreparedStatement pst = conn.prepareStatement(sql);){
			pst.setString(1, usu);
			pst.setString(2, email);
			
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
	
	public void atualizarUsuario(Usuario usuario) {
		
		String sqlUpdate = "UPDATE campeonato.usuario SET login=?, senha=?, nome=?, email=? WHERE id=?";
		String senha = usuario.getSenha();
		
		// usando o try with resources do Java 7, que fecha o que abriu
		try (Connection conn = ConnectionFactory.getConnection();
				PreparedStatement stm = conn.prepareStatement(sqlUpdate);) {
			
			MessageDigest md = MessageDigest.getInstance("SHA-256");
			byte messageDigest[] = md.digest(senha.getBytes("UTF-8"));
			
			StringBuilder sb = new StringBuilder();
			
			for(byte b : messageDigest){
				sb.append(String.format("%02X", 0xFF & b));
			}
			
			String senhaHex = sb.toString();
			
			
			stm.setString(1, usuario.getLogin());
			stm.setString(2, senhaHex);
			stm.setString(3, usuario.getNome());
			stm.setString(4, usuario.getEmail());
			stm.setInt(5, usuario.getId());

			stm.execute();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
