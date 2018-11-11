package br.usjt.ads.best.model.dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import br.usjt.ads.best.model.entity.Campeonato;
import br.usjt.ads.best.model.entity.Time;
import br.usjt.ads.best.model.entity.Usuario;


public class TimeDAO {
	public void inserirTime(String time) throws IOException {
		int id = -1;
		String sql = "insert into campeonato.time (nome) values (?)";
		
		try(Connection conn = ConnectionFactory.getConnection();
			PreparedStatement pst = conn.prepareStatement(sql);){
			
			pst.setString(1, time);
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
}
