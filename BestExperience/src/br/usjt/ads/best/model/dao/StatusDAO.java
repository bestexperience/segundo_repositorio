package br.usjt.ads.best.model.dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import br.usjt.ads.best.model.entity.Campeonato;
import br.usjt.ads.best.model.entity.Status;
import br.usjt.ads.best.model.entity.Usuario;


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
}
