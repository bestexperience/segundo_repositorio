package br.usjt.ads.best.model.dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import br.usjt.ads.best.model.entity.Time;


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
}
