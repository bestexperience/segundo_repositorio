package br.usjt.ads.best.model.dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

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
	
	public Campeonato buscarUsuario(Campeonato campeonato) throws IOException{
		String sql = "select * from campeonato where nome = ?;";
		
		/*Validação do usuario*/
		
		try(Connection conn = ConnectionFactory.getConnection();
				PreparedStatement pst = conn.prepareStatement(sql);){
			pst.setString(1, campeonato.getNome());
			
			try(ResultSet rs = pst.executeQuery();){
				while(rs.next()) {
					campeonato.setIdCampeonato(rs.getInt("idCampeonato"));
					campeonato.setNome(rs.getString("nome"));
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new IOException(e);
		}
		
		return campeonato;
	}
	
	public void excluirCampeonato(Campeonato campeonato) {
		String sqlDelete = "DELETE FROM campeonato WHERE idCampeonato = ?";
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
		
		String sqlUpdate = "UPDATE futebol.campeonato SET nome=? WHERE id=?";
		
		// usando o try with resources do Java 7, que fecha o que abriu
		try (Connection conn = ConnectionFactory.getConnection();
				PreparedStatement stm = conn.prepareStatement(sqlUpdate);) {
			
			stm.setString(1, campeonato.getNome());
			stm.setInt(2, campeonato.getIdCampeonato());
			
			stm.execute();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
