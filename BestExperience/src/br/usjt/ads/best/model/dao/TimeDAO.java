package br.usjt.ads.best.model.dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import br.usjt.ads.best.model.entity.Time;


public class TimeDAO {
	public void inserirTime(Time time) throws IOException {
		int id = -1;
		String sql = "insert into campeonato.time (nome, campeonato_id) values (?, ?)";
		
		try(Connection conn = ConnectionFactory.getConnection();
			PreparedStatement pst = conn.prepareStatement(sql);){
			
			
				pst.setString(1, time.getNome());
				pst.setInt(2, time.getCampeonato().getIdCampeonato());
				pst.execute();
	
			
		} catch (SQLException e) {
			e.printStackTrace();
			throw new IOException(e);
		}
	}
	
	public void inserirTimeNome(Time time) throws IOException {
		int id = -1;
		String sql = "insert into campeonato.time (nome) values (?)";
		
		try(Connection conn = ConnectionFactory.getConnection();
			PreparedStatement pst = conn.prepareStatement(sql);){
			
			
				pst.setString(1, time.getNome());
				pst.execute();
	
			
		} catch (SQLException e) {
			e.printStackTrace();
			throw new IOException(e);
		}
	}
	
	public ArrayList<Time> listarTime(String chave) throws IOException {
		ArrayList<Time> lista = new ArrayList<>();
		String sql = "select * from campeonato.time where nome like ?";
		try(Connection conn = ConnectionFactory.getConnection();
			PreparedStatement pst = conn.prepareStatement(sql);){
			
			pst.setString(1, chave);
		
			try(ResultSet rs = pst.executeQuery();){
			
				Time time;
				while(rs.next()) {
					time = new Time();
					time.setIdTime(rs.getInt("id"));
					time.setNome(rs.getString("nome"));
					lista.add(time);
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new IOException(e);
		}
				
		return lista;
	}
	
	
	public ArrayList<Time> listarTime(int chave) throws IOException {
		ArrayList<Time> lista = new ArrayList<>();
		String sql = "select * from campeonato.time where campeonato_id like ?";
		try(Connection conn = ConnectionFactory.getConnection();
			PreparedStatement pst = conn.prepareStatement(sql);){
			
			pst.setInt(1, chave);
		
			try(ResultSet rs = pst.executeQuery();){
			
				Time time;
				while(rs.next()) {
					time = new Time();
					time.setIdTime(rs.getInt("id"));
					time.setNome(rs.getString("nome"));
					lista.add(time);
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new IOException(e);
		}
				
		return lista;
	}

	public ArrayList<Time> listarTime() throws IOException {
		ArrayList<Time> lista = new ArrayList<>();
		String sql = "SELECT * FROM campeonato.time";
		try(Connection conn = ConnectionFactory.getConnection();
			PreparedStatement pst = conn.prepareStatement(sql);
			ResultSet rs = pst.executeQuery();){
			
			Time time;
			while(rs.next()) {
				time = new Time();
				time.setIdTime(rs.getInt("id"));
				time.setNome(rs.getString("nome"));
				lista.add(time);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new IOException(e);
		}				
		return lista;
	}
	
public void atualizarTime(Time time) {
		
		String sqlUpdate = "UPDATE campeonato.time SET nome=? WHERE id=?";
		
		// usando o try with resources do Java 7, que fecha o que abriu
		try (Connection conn = ConnectionFactory.getConnection();
				PreparedStatement stm = conn.prepareStatement(sqlUpdate);) {
			
			stm.setString(1, time.getNome());
			stm.setInt(2, time.getIdTime());

			stm.execute();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void excluirTime(Time time) {
		String sqlDelete = "DELETE FROM campeonato.time WHERE id = ?";
		// usando o try with resources do Java 7, que fecha o que abriu
		try (Connection conn = ConnectionFactory.getConnection();
				PreparedStatement stm = conn.prepareStatement(sqlDelete);) {
			int id = time.getIdTime();
			stm.setInt(1, id);
			stm.execute();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public Time buscarTime(int id) throws IOException {
		Time time = null;
		String sql = "select * from campeonato.time where id like ?";
		try(Connection conn = ConnectionFactory.getConnection();
			PreparedStatement pst = conn.prepareStatement(sql);){
			
			pst.setInt(1, id);
			
			try(ResultSet rs = pst.executeQuery();){
			
				while(rs.next()) {
					time = new Time();
					time.setIdTime(rs.getInt("id"));
					time.setNome(rs.getString("nome"));
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new IOException(e);
		}
		
		return time;
	}
	
	
}
