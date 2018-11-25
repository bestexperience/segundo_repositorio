package br.usjt.ads.best.model.dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import br.usjt.ads.best.model.entity.Campeonato;
import br.usjt.ads.best.model.entity.Resultados_definidos;
import br.usjt.ads.best.model.entity.Status;


public class StatusDAO {
	public ArrayList<Status> listarStatus() throws IOException {
		ArrayList<Status> statusArray = new ArrayList<>();
		String sql = "select id, nome from status order by id";

		try (Connection conn = ConnectionFactory.getConnection();
				PreparedStatement pst = conn.prepareStatement(sql);
				ResultSet rs = pst.executeQuery();) {

			while (rs.next()) {
				Status status = new Status();
				status.setId(rs.getInt("id"));
				status.setNome(rs.getString("nome"));
				statusArray.add(status);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new IOException(e);
		}
		return statusArray;
	}
	
	
	public ArrayList<Resultados_definidos> listarResultadosDefinidos(int id) throws IOException {
		ArrayList<Resultados_definidos> lista = new ArrayList<>();
		String sql = "select r.id, r.pontos, r.campeonato_id, r.status_id, c.nome, s.nome from resultados_definidos r, campeonato c, status s where"
				+ " r.campeonato_id = c.id and r.status_id = s.id and r.campeonato_id like ? order by status_id;";
		try(Connection conn = ConnectionFactory.getConnection();
			PreparedStatement pst = conn.prepareStatement(sql);){
			
			pst.setInt(1, id);
		
			try(ResultSet rs = pst.executeQuery();){
			
				Resultados_definidos resultados;
				Campeonato campeonato;
				Status status = new Status();
				while(rs.next()) {
					resultados = new Resultados_definidos();
					resultados.setId(rs.getInt("r.id"));
					resultados.setPontos(rs.getInt("r.pontos"));
					campeonato = new Campeonato();
					campeonato.setIdCampeonato(rs.getInt("r.campeonato_id"));
					campeonato.setNome(rs.getString("c.nome"));
					resultados.setCampeonato(campeonato);
					status = new Status();
					status.setId(rs.getInt("status_id"));
					status.setNome(rs.getString("s.nome"));
					resultados.setStatus(status);
					lista.add(resultados);
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new IOException(e);
		}
				
		return lista;
	}
	
	public int inserirPontos(int ponto, int id_campeonato, int id_status) throws IOException {
		int id = -1;
		String sql = "insert into resultados_definidos (pontos, campeonato_id, status_id) values (?,?,?)";
		
		try(Connection conn = ConnectionFactory.getConnection();
			PreparedStatement pst = conn.prepareStatement(sql);){
			
			pst.setInt(1, ponto);
			pst.setInt(2, id_campeonato);
			pst.setInt(3, id_status);
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
	
public void atualizarResultados(int pontos, int id_pontos) {
		
		String sqlUpdate = "UPDATE campeonato.resultados_definidos SET pontos=? WHERE status_id=?";
		
		// usando o try with resources do Java 7, que fecha o que abriu
		try (Connection conn = ConnectionFactory.getConnection();
				PreparedStatement stm = conn.prepareStatement(sqlUpdate);) {
			
			stm.setInt(1, pontos);
			stm.setInt(2, id_pontos);
			
			stm.execute();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void excluirResultados(int resultados_definidos) {
		String sqlDelete = "DELETE FROM campeonato.resultados_definidos WHERE campeonato_id = ?";
		// usando o try with resources do Java 7, que fecha o que abriu
		try (Connection conn = ConnectionFactory.getConnection();
				PreparedStatement stm = conn.prepareStatement(sqlDelete);) {
			stm.setInt(1, resultados_definidos);
			stm.execute();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}
