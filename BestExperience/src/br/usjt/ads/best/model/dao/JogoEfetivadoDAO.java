package br.usjt.ads.best.model.dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import br.usjt.ads.best.model.entity.Campeonato;
import br.usjt.ads.best.model.entity.JogoEfetivado;
import br.usjt.ads.best.model.entity.Time;

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
	
	public ArrayList<JogoEfetivado> listarJogosEfetivado(int chave) throws IOException {
		ArrayList<JogoEfetivado> lista = new ArrayList<>();
		String sql = "select jf.id_sumula, jf.data, jf.time_mandante, jf.placar_mandante, jf.time_visitante, jf.placar_visitante, jf.campeonato_id, t.nome, t2.nome from jogo_efetivado jf, time t, time t2 where  jf.time_mandante = t.id and  jf.time_visitante = t2.id and jf.campeonato_id like ?;";
		try(Connection conn = ConnectionFactory.getConnection();
			PreparedStatement pst = conn.prepareStatement(sql);){
			
			pst.setInt(1, chave);
		
			try(ResultSet rs = pst.executeQuery();){
			
				JogoEfetivado jf;
				Time time_visitante;
				Time time_mandante;
				Campeonato campeonato;
				while(rs.next()) {
					jf = new JogoEfetivado();
					jf.setId_sumula(rs.getInt("jf.id_sumula"));
					jf.setData(rs.getDate("jf.data"));
					
					/*Time mandante*/
					time_mandante = new Time();
					time_mandante.setIdTime(rs.getInt("jf.time_mandante"));
					time_mandante.setNome(rs.getString("t.nome"));
					jf.setTime_mandante(time_mandante);
					
					jf.setPlacar_mandante(rs.getInt("jf.placar_mandante"));
					/*FIM*/
					
					/*Time visitante*/
					time_visitante = new Time();
					time_visitante.setIdTime(rs.getInt("jf.time_visitante"));
					time_visitante.setNome(rs.getString("t2.nome"));
					jf.setTime_visitante(time_visitante);
					
					jf.setPlacar_visitante(rs.getInt("jf.placar_visitante"));
					/*FIM*/
					
					campeonato = new Campeonato();
					campeonato.setIdCampeonato(rs.getInt("jf.campeonato_id"));
					jf.setCampeonato(campeonato);
					lista.add(jf);
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new IOException(e);
		}
				
		return lista;
	}
}
