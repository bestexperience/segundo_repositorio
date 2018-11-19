package br.usjt.ads.best.model.dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import br.usjt.ads.best.model.entity.Estado;

public class EstadoDAO {
	public Estado buscarEstado(int id) throws IOException {
		Estado estado = null;
		String sql = "select id, nome from estado where id=?";

		try (Connection conn = ConnectionFactory.getConnection(); 
				PreparedStatement pst = conn.prepareStatement(sql);) {

			pst.setInt(1, id);
			try (ResultSet rs = pst.executeQuery();) {

				if (rs.next()) {
					estado = new Estado();
					estado.setIdEstado(rs.getInt("id"));
					estado.setNomeEstado(rs.getString("nome"));
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new IOException(e);
		}
		return estado;
	}

	public ArrayList<Estado> listarEstados() throws IOException {
		ArrayList<Estado> estados = new ArrayList<>();
		String sql = "select id, nome from estado order by nome";

		try (Connection conn = ConnectionFactory.getConnection();
				PreparedStatement pst = conn.prepareStatement(sql);
				ResultSet rs = pst.executeQuery();) {

			while (rs.next()) {
				Estado estado = new Estado();
				estado.setIdEstado(rs.getInt("id"));
				estado.setNomeEstado(rs.getString("nome"));
				estados.add(estado);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new IOException(e);
		}
		return estados;
	}
}
