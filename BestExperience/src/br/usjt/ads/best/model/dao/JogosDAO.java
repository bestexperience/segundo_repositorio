package br.usjt.ads.best.model.dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import br.usjt.ads.best.model.entity.Campeonato;
import br.usjt.ads.best.model.entity.Jogos;


public class JogosDAO {
	public int inserirJogos(Jogos jogos) throws IOException {
		int id = -1;
		String sql = "INSERT INTO campeonato.jogos (data, tempo_extra, turno, comentarios, periodo, campeonato_id) VALUES (?, ?, ?, ?, ?, ?)";
		
		try(Connection conn = ConnectionFactory.getConnection();
			PreparedStatement pst = conn.prepareStatement(sql);){
			
			if(jogos.getData() != null) {
				pst.setDate(1, new java.sql.Date(jogos.getData().getTime()));
			} else {
				pst.setDate(1,  null);
			}
			pst.setInt(2, jogos.getTempo_extra());
			pst.setInt(3, jogos.getTurno());	
			pst.setString(4, jogos.getComentarios());
			pst.setString(5, jogos.getPeriodo());
			pst.setInt(6, jogos.getCampeonato().getIdCampeonato());
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
	
	public Jogos buscarJogos(int chave) throws IOException {
		Jogos jogos = null;
		//String sql = "select j.id, j.data, j.tempo_extra, j.turno, j.comentarios, j.periodo, campeonato_id where e.time_id = t.id and e.jogos_id = j.id and e.id like ?";
		String sql = "SELECT * FROM campeonato.jogos where campeonato_id = ?";
		try(Connection conn = ConnectionFactory.getConnection();
			PreparedStatement pst = conn.prepareStatement(sql);){
			
			pst.setInt(1, chave);
		
			try(ResultSet rs = pst.executeQuery();){
				Campeonato campeonato;
				while(rs.next()) {
					jogos = new Jogos();
					jogos.setIdJogos(rs.getInt("id"));
					jogos.setData(rs.getDate("data"));
					jogos.setTempo_extra(rs.getInt("tempo_extra"));
					jogos.setTurno(rs.getInt("turno"));
					jogos.setComentarios(rs.getString("comentarios"));
					jogos.setPeriodo(rs.getString("periodo"));
					campeonato = new Campeonato();
					campeonato.setIdCampeonato(rs.getInt("campeonato_id"));
					jogos.setCampeonato(campeonato);
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new IOException(e);
		}
				
		return jogos;
	}
}
