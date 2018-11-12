package br.usjt.ads.best.model.dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import br.usjt.ads.best.model.entity.Jogador;

public class JogadorDAO {
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
