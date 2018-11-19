package br.usjt.ads.best.model.dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import br.usjt.ads.best.model.entity.Cidade;


public class CidadeDAO {
	public Cidade buscarCidade(int id) throws IOException {
		Cidade cidade = null;
		String sql = "select id, nome from cidade where id=?";

		try (Connection conn = ConnectionFactory.getConnection(); 
				PreparedStatement pst = conn.prepareStatement(sql);) {

			pst.setInt(1, id);
			try (ResultSet rs = pst.executeQuery();) {

				if (rs.next()) {
					cidade = new Cidade();
					cidade.setIdCidade(rs.getInt("id"));
					cidade.setNomeCidade(rs.getString("nome"));
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new IOException(e);
		}
		return cidade;
	}

	public ArrayList<Cidade> listarCidade() throws IOException {
		ArrayList<Cidade> cidades = new ArrayList<>();
		String sql = "select id, nome from cidade order by nome";

		try (Connection conn = ConnectionFactory.getConnection();
				PreparedStatement pst = conn.prepareStatement(sql);
				ResultSet rs = pst.executeQuery();) {

			while (rs.next()) {
				Cidade cidade = new Cidade();
				cidade.setIdCidade(rs.getInt("id"));
				cidade.setNomeCidade(rs.getString("nome"));
				cidades.add(cidade);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new IOException(e);
		}
		return cidades;
	}
}
