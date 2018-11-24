package br.usjt.ads.best.model.dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import br.usjt.ads.best.model.entity.Campeonato;
import br.usjt.ads.best.model.entity.Usuario;

public class CampeonatoDAO {
	public int inserirCampeonato(Campeonato campeonato, Usuario usuario) throws IOException {
		int id = -1;
		String sql = "insert into campeonato (nome, numeroRodadas, usuario_id) values (?,?,?)";
		
		try(Connection conn = ConnectionFactory.getConnection();
			PreparedStatement pst = conn.prepareStatement(sql);){
			
			pst.setString(1, campeonato.getNome());
			pst.setInt(2, campeonato.getNumeroRodadas());
			pst.setInt(3, usuario.getId());
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
	
	public Campeonato buscarCampeonato(Campeonato campeonato) throws IOException{
		String sql = "select c.id, c.nome, c.numeroRodadas, c.usuario_id, u.nome from campeonato c, "
				+ "usuario u where c.usuario_id = u.id and c.nome like ?";
		
		
		
		try(Connection conn = ConnectionFactory.getConnection();
				PreparedStatement pst = conn.prepareStatement(sql);){
			pst.setString(1, campeonato.getNome());
			
			try(ResultSet rs = pst.executeQuery();){
				Usuario usuario;
				while(rs.next()) {
					campeonato.setIdCampeonato(rs.getInt("c.id"));
					campeonato.setNome(rs.getString("c.nome"));
					campeonato.setNumeroRodadas(rs.getInt("c.numeroRodadas"));
					usuario = new Usuario();
					usuario.setId(rs.getInt("c.usuario_id"));
					usuario.setNome(rs.getString("u.nome"));
					campeonato.setUsuario(usuario);
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new IOException(e);
		}
		
		return campeonato;
	}
	
	public void excluirCampeonato(Campeonato campeonato) {
		String sqlDelete = "DELETE FROM campeonato.campeonato WHERE id = ?";
		// usando o try with resources do Java 7, que fecha o que abriu
		try (Connection conn = ConnectionFactory.getConnection();
				PreparedStatement stm = conn.prepareStatement(sqlDelete);) {
			int id = campeonato.getIdCampeonato();
			stm.setInt(1, id);
			stm.execute();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void atualizarCampeonato(Campeonato campeonato) {
		
		String sqlUpdate = "UPDATE futebol.campeonato SET nome=?, numeroRodadas=? WHERE id=?";
		
		// usando o try with resources do Java 7, que fecha o que abriu
		try (Connection conn = ConnectionFactory.getConnection();
				PreparedStatement stm = conn.prepareStatement(sqlUpdate);) {
			
			stm.setString(1, campeonato.getNome());
			stm.setInt(2, campeonato.getNumeroRodadas());
			stm.setInt(3, campeonato.getIdCampeonato());
			
			stm.execute();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public ArrayList<Campeonato> listarCampeonatos(String chave) throws IOException {
		ArrayList<Campeonato> lista = new ArrayList<>();
		String sql = "select c.id, c.nome, c.numeroRodadas, c.usuario_id, u.nome from campeonato c, "
				+ "usuario u where c.usuario_id = u.id and c.nome like ?";
		try(Connection conn = ConnectionFactory.getConnection();
			PreparedStatement pst = conn.prepareStatement(sql);){
			
			pst.setString(1, chave);
		
			try(ResultSet rs = pst.executeQuery();){
			
				Campeonato campeonato;
				Usuario usuario;
				while(rs.next()) {
					campeonato = new Campeonato();
					campeonato.setIdCampeonato(rs.getInt("c.id"));
					campeonato.setNome(rs.getString("c.nome"));
					campeonato.setNumeroRodadas(rs.getInt("c.numeroRodadas"));
					usuario = new Usuario();
					usuario.setId(rs.getInt("c.usuario_id"));
					usuario.setNome(rs.getString("u.nome"));
					campeonato.setUsuario(usuario);
					lista.add(campeonato);
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new IOException(e);
		}
				
		return lista;
	}

	public ArrayList<Campeonato> listarCampeonatos() throws IOException {
		ArrayList<Campeonato> lista = new ArrayList<>();
		String sql = "select c.id, c.nome, c.numeroRodadas, c.usuario_id, u.nome from campeonato c, usuario u where c.usuario_id = u.id";
		try(Connection conn = ConnectionFactory.getConnection();
			PreparedStatement pst = conn.prepareStatement(sql);
			ResultSet rs = pst.executeQuery();){
			
			Campeonato campeonato;
			Usuario usuario;
			while(rs.next()) {
				campeonato = new Campeonato();
				campeonato.setIdCampeonato(rs.getInt("c.id"));
				campeonato.setNome(rs.getString("c.nome"));
				campeonato.setNumeroRodadas(rs.getInt("c.numeroRodadas"));
				usuario = new Usuario();
				usuario.setId(rs.getInt("c.usuario_id"));
				usuario.setNome(rs.getString("u.nome"));
				campeonato.setUsuario(usuario);
				lista.add(campeonato);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new IOException(e);
		}				
		return lista;
	}
}
