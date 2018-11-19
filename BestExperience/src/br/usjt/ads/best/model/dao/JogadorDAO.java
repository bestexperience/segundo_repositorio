package br.usjt.ads.best.model.dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import br.usjt.ads.best.model.entity.Jogador;

public class JogadorDAO {
	public int inserirJogador(Jogador jogador) throws IOException {
		int id = -1;
		String sql = "INSERT INTO campeonato.jogador (nome, time_id) VALUES (?, ?)";
		
		try(Connection conn = ConnectionFactory.getConnection();
			PreparedStatement pst = conn.prepareStatement(sql);){
			
			pst.setString(1, jogador.getNomeJogador());
			pst.setInt(2, 1);	
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
	
	
	
	public ArrayList<Jogador> listarJogador(String chave) throws IOException {
		ArrayList<Jogador> lista = new ArrayList<>();
		String sql = "select * from campeonato.jogador where nome like ?";
		try(Connection conn = ConnectionFactory.getConnection();
			PreparedStatement pst = conn.prepareStatement(sql);){
			
			pst.setString(1, chave);
		
			try(ResultSet rs = pst.executeQuery();){
			
				Jogador jogador;
				while(rs.next()) {
					jogador = new Jogador();
					jogador.setIdJogador(rs.getInt("id"));
					jogador.setNomeJogador(rs.getString("nome"));
					lista.add(jogador);
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new IOException(e);
		}
				
		return lista;
	}

	public ArrayList<Jogador> listarJogador() throws IOException {
		ArrayList<Jogador> lista = new ArrayList<>();
		String sql = "SELECT * FROM campeonato.jogador";
		try(Connection conn = ConnectionFactory.getConnection();
			PreparedStatement pst = conn.prepareStatement(sql);
			ResultSet rs = pst.executeQuery();){
			
			Jogador jogador;
			while(rs.next()) {
				jogador = new Jogador();
				jogador.setIdJogador(rs.getInt("id"));
				jogador.setNomeJogador(rs.getString("nome"));
				lista.add(jogador);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new IOException(e);
		}				
		return lista;
	}
}
