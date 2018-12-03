package br.usjt.ads.best.model.dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import br.usjt.ads.best.model.entity.JogoEfetivado;

public class JogoEfetivadoDAO {
	public void inserirJogo(JogoEfetivado jogo) throws IOException {
		int id = -1;
		String sql = "insert into campeonato.jogo_efetivado (data, time_visitante, placar_visitante, time_mandante, placar_mandante, campeonato_id) values (?, ?, ?, ?, ?, ?)";
		
		try(Connection conn = ConnectionFactory.getConnection();
			PreparedStatement pst = conn.prepareStatement(sql);){
			
			
			if(jogo.getData() != null) {
				pst.setDate(1, new java.sql.Date(jogo.getData().getTime()));
			} else {
				pst.setDate(1,  null);
			}
			pst.setInt(2, jogo.getTime_visitante().getIdTime());
			pst.setInt(3, jogo.getPlacar_visitante());
			
			pst.setInt(4, jogo.getTime_mandante().getIdTime());
			pst.setInt(5, jogo.getPlacar_mandante());
			pst.setInt(6, jogo.getCampeonato().getIdCampeonato());
			pst.execute();
	
			
		} catch (SQLException e) {
			e.printStackTrace();
			throw new IOException(e);
		}
	}
}
