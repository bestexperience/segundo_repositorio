package br.usjt.ads.best.model.dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import br.usjt.ads.best.model.entity.Campeonato;
import br.usjt.ads.best.model.entity.Time;
import br.usjt.ads.best.model.entity.TimeCampeonato;

public class TimeCampeonatoDAO {
	public ArrayList<TimeCampeonato> listarTimeCampeonato() throws IOException {
		ArrayList<TimeCampeonato> lista = new ArrayList<>();
		String sql = "select tc.classificacao, tc.time_id, tc.pontos, tc.jogos, tc.vitorias, tc.empates, tc.derrotas, tc.gols_marcados, tc.gols_sofridos, tc.saldo_de_gols, tc.aproveitamento, t.id, t.nome, t.campeonato_id from time_campeonato tc, time t where tc.time_id = t.id";
		
		try(Connection conn = ConnectionFactory.getConnection();
			PreparedStatement pst = conn.prepareStatement(sql);
			ResultSet rs = pst.executeQuery();){
			
			Time time;
			TimeCampeonato timeC;
			Campeonato campeonato;
			while(rs.next()) {
				timeC = new TimeCampeonato();
				timeC.setClassificacao(rs.getInt("tc.classificacao"));
				time = new Time();
				time.setIdTime(rs.getInt("tc.time_id"));
				time.setNome(rs.getString("t.nome"));
				campeonato = new Campeonato();
				campeonato.setIdCampeonato(rs.getInt("t.campeonato_id"));
				time.setCampeonato(campeonato);
				
				timeC.setTime(time);
				timeC.setPontos(rs.getInt("tc.pontos"));
				timeC.setJogos(rs.getInt("tc.jogos"));
				timeC.setVitorias(rs.getInt("tc.vitorias"));
				timeC.setEmpates(rs.getInt("tc.empates"));
				timeC.setDerrotas(rs.getInt("tc.derrotas"));
				timeC.setGols_marcados(rs.getInt("tc.gols_marcados"));
				timeC.setGols_sofridos(rs.getInt("tc.gols_sofridos"));
				timeC.setSaldo_de_gols(rs.getInt("tc.saldo_de_gols"));
				timeC.setAproveitamento(rs.getDouble("tc.aproveitamento"));
				lista.add(timeC);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new IOException(e);
		}				
		return lista;
	}
	
	
	public int inserirTimeCampeonato(TimeCampeonato timeC) throws IOException {
		int id = -1;
		String sql = "INSERT INTO campeonato.time_campeonato (time_id, pontos, jogos, vitorias, empates, derrotas, gols_marcados, gols_sofridos, saldo_de_gols, aproveitamento) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
		
		try(Connection conn = ConnectionFactory.getConnection();
			PreparedStatement pst = conn.prepareStatement(sql);){
			
			pst.setInt(1, timeC.getTime().getIdTime());
			pst.setInt(2, timeC.getPontos());
			pst.setInt(3, timeC.getJogos());
			pst.setInt(4, timeC.getVitorias());
			pst.setInt(5, timeC.getEmpates());
			pst.setInt(6, timeC.getDerrotas());
			pst.setInt(7, timeC.getGols_marcados());
			pst.setInt(8, timeC.getGols_sofridos());
			pst.setInt(9, timeC.getSaldo_de_gols());
			pst.setDouble(10, timeC.getAproveitamento());
			
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
	
	public TimeCampeonato buscarTimeCampeonato(int id) throws IOException {
		TimeCampeonato timeC = null;
		Time time = null;
		String sql = "select tc.time_id, tc.pontos, tc.jogos, tc.vitorias, tc.empates, tc.derrotas, tc.gols_marcados, tc.gols_sofridos, tc.saldo_de_gols, tc.aproveitamento, t.id, t.nome from time_campeonato tc, time t where tc.time_id = t.id and tc.time_id like ?";
		
		try(Connection conn = ConnectionFactory.getConnection();
			PreparedStatement pst = conn.prepareStatement(sql);){
			
			pst.setInt(1, id);
			
			try(ResultSet rs = pst.executeQuery();){
			
				while(rs.next()) {
					timeC = new TimeCampeonato();
					time = new Time();
					time.setIdTime(rs.getInt("tc.time_id"));
					time.setNome(rs.getString("t.nome"));
					timeC.setTime(time);
					timeC.setPontos(rs.getInt("tc.pontos"));
					timeC.setJogos(rs.getInt("tc.jogos"));
					timeC.setVitorias(rs.getInt("tc.vitorias"));
					timeC.setEmpates(rs.getInt("tc.empates"));
					timeC.setDerrotas(rs.getInt("tc.derrotas"));
					timeC.setGols_marcados(rs.getInt("tc.gols_marcados"));
					timeC.setGols_sofridos(rs.getInt("tc.gols_sofridos"));
					timeC.setSaldo_de_gols(rs.getInt("tc.saldo_de_gols"));
					timeC.setAproveitamento(rs.getDouble("tc.aproveitamento"));
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new IOException(e);
		}
		
		return timeC;
	}
	
public void atualizarTimeCampeonato(TimeCampeonato timeC) {
		
		String sqlUpdate = "UPDATE campeonato.time_campeonato SET pontos=?, jogos=?, vitorias=?, empates=?, derrotas=?, gols_marcados=?, gols_sofridos=?, saldo_de_gols=?, aproveitamento=? WHERE time_id=?";
		
		// usando o try with resources do Java 7, que fecha o que abriu
		try (Connection conn = ConnectionFactory.getConnection();
				PreparedStatement stm = conn.prepareStatement(sqlUpdate);) {
			
			stm.setInt(1, timeC.getPontos());
			stm.setInt(2, timeC.getJogos());
			stm.setInt(3, timeC.getVitorias());
			stm.setInt(4, timeC.getEmpates());
			stm.setInt(5, timeC.getDerrotas());
			stm.setInt(6, timeC.getGols_marcados());
			stm.setInt(7, timeC.getGols_sofridos());
			stm.setInt(8, timeC.getSaldo_de_gols());
			stm.setDouble(9, timeC.getAproveitamento());
			stm.setInt(10, timeC.getTime().getIdTime());
			stm.execute();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
