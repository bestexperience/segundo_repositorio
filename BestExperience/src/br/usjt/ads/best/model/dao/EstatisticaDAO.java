package br.usjt.ads.best.model.dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import br.usjt.ads.best.model.entity.Estatistica;
import br.usjt.ads.best.model.entity.Jogos;
import br.usjt.ads.best.model.entity.Time;


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
	
	public ArrayList<Estatistica> listarEstatistica() throws IOException {
		ArrayList<Estatistica> lista = new ArrayList<>();
		String sql = "select e.id, e.score, e.chute_fora, e.saves, e.escanteios, e.faltas, e.laterais, e.passes_de_bola, e.defesas, e.bola_fora, e.time_id, e.jogos_id, t.nome, "
				+ "j.data, j.tempo_extra, j.turno, j.comentarios, j.periodo from estatistica e, time t, jogos j where e.time_id = t.id and e.jogos_id = j.id;";
		
		try(Connection conn = ConnectionFactory.getConnection();
			PreparedStatement pst = conn.prepareStatement(sql);
			ResultSet rs = pst.executeQuery();){
			
			Estatistica estatistica;
			Time time;
			Jogos jogos;
			while(rs.next()) {
				estatistica = new Estatistica();
				estatistica.setIdEstatistica(rs.getInt("e.id"));
				estatistica.setIdEstatistica(rs.getInt("e.score"));
				estatistica.setIdEstatistica(rs.getInt("e.chute_fora"));
				estatistica.setIdEstatistica(rs.getInt("e.saves"));
				estatistica.setIdEstatistica(rs.getInt("e.escanteios"));
				estatistica.setIdEstatistica(rs.getInt("e.faltas"));
				estatistica.setIdEstatistica(rs.getInt("e.laterais"));
				estatistica.setIdEstatistica(rs.getInt("e.passes_de_bola"));
				estatistica.setIdEstatistica(rs.getInt("e.defesas"));
				estatistica.setIdEstatistica(rs.getInt("e.bola_fora"));
				estatistica.setIdEstatistica(rs.getInt("e.time_id"));
				time = new Time();
				time.setIdTime(rs.getInt("e.time_id"));
				time.setNome(rs.getString("t.nome"));
				estatistica.setTime(time);
				
				jogos = new Jogos();
				
				jogos.setIdJogos(rs.getInt("e.jogos_id"));
				jogos.setData(rs.getDate("j.data"));
				jogos.setTempo_extra(rs.getInt("j.tempo_extra"));
				jogos.setTurno(rs.getInt("j.turno"));
				jogos.setComentarios(rs.getString("j.comentarios"));
				jogos.setPeriodo(rs.getString("j.periodo"));
				estatistica.setJogos(jogos);
				lista.add(estatistica);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new IOException(e);
		}				
		return lista;
	}
	
	
	

}
