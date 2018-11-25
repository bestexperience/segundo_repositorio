package br.usjt.ads.best.model.dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import br.usjt.ads.best.model.entity.Estatistica;


public class EstatisticaDAO {
	public int inserirEstatistica(Estatistica estatistica) throws IOException {
		int id = -1;
		String sql = "INSERT INTO campeonato.estatistica (score, chute_fora, saves, escanteios, faltas, laterais, passes_de_bola, "
				+ "defesas, bola_fora, time_id, jogos_id) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
		
		try(Connection conn = ConnectionFactory.getConnection();
			PreparedStatement pst = conn.prepareStatement(sql);){
			
			pst.setInt(1, estatistica.getScore());
			pst.setInt(2, estatistica.getChute_fora());
			pst.setInt(3, estatistica.getSaves());
			pst.setInt(4, estatistica.getEscanteios());
			pst.setInt(5, estatistica.getFaltas());
			pst.setInt(6, estatistica.getLaterais());
			pst.setInt(7, estatistica.getPasses_de_bola());
			pst.setInt(8, estatistica.getDefesas());
			pst.setInt(9, estatistica.getBola_fora());
			pst.setInt(10, estatistica.getTime().getIdTime());
			pst.setInt(11, estatistica.getJogos().getIdJogos());
			
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
