package br.usjt.ads.best.model.dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import br.usjt.ads.best.model.entity.Jogador;
import br.usjt.ads.best.model.entity.Time;

public class JogadorDAO {
	public int inserirJogador(Jogador jogador) throws IOException {
		int id = -1;
		String sql = "INSERT INTO campeonato.jogador (nome, nascimento_jogador) VALUES (?, ?)";
		
		try(Connection conn = ConnectionFactory.getConnection();
			PreparedStatement pst = conn.prepareStatement(sql);){
			
			pst.setString(1, jogador.getNomeJogador());
			if(jogador.getNascimento_jogador() != null) {
				pst.setDate(2, new java.sql.Date(jogador.getNascimento_jogador().getTime()));
			} else {
				pst.setDate(2,  null);
			}
			//pst.setInt(3, 1);	
			
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
	
	public int inserirJogadorETime(Jogador jogador) throws IOException {
		int id = -1;
		String sql = "INSERT INTO campeonato.jogador (nome, nascimento_jogador, time_id) VALUES (?, ?, ?)";
		
		try(Connection conn = ConnectionFactory.getConnection();
			PreparedStatement pst = conn.prepareStatement(sql);){
			
			pst.setString(1, jogador.getNomeJogador());
			if(jogador.getNascimento_jogador() != null) {
				pst.setDate(2, new java.sql.Date(jogador.getNascimento_jogador().getTime()));
			} else {
				pst.setDate(2,  null);
			}
			pst.setInt(3, jogador.getTime().getIdTime());	
			
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
					jogador.setNascimento_jogador(rs.getDate("nascimento_jogador"));
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
				jogador.setNascimento_jogador(rs.getDate("nascimento_jogador"));
				lista.add(jogador);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new IOException(e);
		}				
		return lista;
	}
	
	public ArrayList<Jogador> listarJogadorETime() throws IOException {
		ArrayList<Jogador> lista = new ArrayList<>();
		String sql = "select j.id, j.nome, j.nascimento_jogador, j.gols, j.time_id, t.nome from jogador j, campeonato.time t where j.time_id = t.id";
		try(Connection conn = ConnectionFactory.getConnection();
			PreparedStatement pst = conn.prepareStatement(sql);
			ResultSet rs = pst.executeQuery();){
			
			Time time;
			Jogador jogador;
			while(rs.next()) {
				jogador = new Jogador();
				
				jogador.setIdJogador(rs.getInt("j.id"));
				jogador.setNomeJogador(rs.getString("j.nome"));
				jogador.setNascimento_jogador(rs.getDate("j.nascimento_jogador"));
				jogador.setGols(rs.getInt("j.gols"));
				time = new Time();
				time.setIdTime(rs.getInt("j.time_id"));
				time.setNome(rs.getString("t.nome"));
				jogador.setTime(time);
				lista.add(jogador);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new IOException(e);
		}				
		return lista;
	}
	
	public void atualizar(Jogador jogador) {
		
		String sqlUpdate = "UPDATE campeonato.jogador SET nome=?, nascimento_jogador=? WHERE id=?";
		
		// usando o try with resources do Java 7, que fecha o que abriu
		try (Connection conn = ConnectionFactory.getConnection();
				PreparedStatement stm = conn.prepareStatement(sqlUpdate);) {
			
			stm.setString(1, jogador.getNomeJogador());
			
			if(jogador.getNascimento_jogador() != null) {
				stm.setDate(2, new java.sql.Date(jogador.getNascimento_jogador().getTime()));
			} else {
				stm.setDate(2,  null);
			}
			stm.setInt(3, jogador.getIdJogador());
			stm.execute();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void excluirJogador(Jogador jogador) {
		String sqlDelete = "DELETE FROM campeonato.jogador WHERE id = ?";
		// usando o try with resources do Java 7, que fecha o que abriu
		try (Connection conn = ConnectionFactory.getConnection();
				PreparedStatement stm = conn.prepareStatement(sqlDelete);) {
			int id = jogador.getIdJogador();
			stm.setInt(1, id);
			stm.execute();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public ArrayList<Jogador> buscarJogadorPeloTime(int id) throws IOException {
		ArrayList<Jogador> lista = new ArrayList<>();
		String sql = "select j.id, j.nome, j.nascimento_jogador, j.gols, j.time_id, t.nome from jogador j, campeonato.time t where j.time_id = t.id and j.time_id = ?";
		
		try(Connection conn = ConnectionFactory.getConnection();
			PreparedStatement pst = conn.prepareStatement(sql);){
			
			pst.setInt(1, id);
			try(ResultSet rs = pst.executeQuery();){
				Jogador jogador;
				Time time;
				while(rs.next()) {
					jogador = new Jogador();
					jogador.setIdJogador(rs.getInt("j.id"));
					jogador.setNomeJogador(rs.getString("j.nome"));
					jogador.setNascimento_jogador(rs.getDate("j.nascimento_jogador"));
					jogador.setGols(rs.getInt("j.gols"));
					time = new Time();
					time.setIdTime(rs.getInt("j.time_id"));
					time.setNome(rs.getString("t.nome"));
					jogador.setTime(time);
					lista.add(jogador);
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new IOException(e);
		}
				
		return lista;
	}
	
public void atualizarGolsJogador(Jogador jogador) {
		
		String sqlUpdate = "UPDATE campeonato.jogador SET gols=? WHERE id=?";
		
		// usando o try with resources do Java 7, que fecha o que abriu
		try (Connection conn = ConnectionFactory.getConnection();
				PreparedStatement stm = conn.prepareStatement(sqlUpdate);) {
			
			stm.setInt(1, jogador.getGols());
			stm.setInt(2, jogador.getIdJogador());
			stm.execute();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

public Jogador buscarJogador(int chave) throws IOException {
	Jogador jogador = new Jogador();
	String sql = "select * from campeonato.jogador where id like ?";
	try(Connection conn = ConnectionFactory.getConnection();
		PreparedStatement pst = conn.prepareStatement(sql);){
		
		pst.setInt(1, chave);
	
		try(ResultSet rs = pst.executeQuery();){
		
			while(rs.next()) {
				jogador = new Jogador();
				jogador.setIdJogador(rs.getInt("id"));
				jogador.setNomeJogador(rs.getString("nome"));
			}
		}
	} catch (SQLException e) {
		e.printStackTrace();
		throw new IOException(e);
	}
			
	return jogador;
}

}
