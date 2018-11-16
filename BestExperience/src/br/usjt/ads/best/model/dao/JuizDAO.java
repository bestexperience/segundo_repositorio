package br.usjt.ads.best.model.dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import br.usjt.ads.best.model.entity.Cidade;
import br.usjt.ads.best.model.entity.Juiz;
import br.usjt.ads.best.model.entity.Estado;


public class JuizDAO {
	public ArrayList<Juiz> listarJuiz(String chave) throws IOException {
		ArrayList<Juiz> lista = new ArrayList<>();
		String sql = "select j.id, j.nome, j.data_nascimento, j.cidade_id, j.estado_id, c.nome, e.nome from juiz j, cidade c, estado e where j.cidade_id = c.id and j.estado_id = e.id and j.nome like ?";
		try(Connection conn = ConnectionFactory.getConnection();
			PreparedStatement pst = conn.prepareStatement(sql);){
			
			pst.setString(1, chave);
		
			try(ResultSet rs = pst.executeQuery();){
			
				Juiz juiz;
				Cidade cidade;
				Estado estado;
				while(rs.next()) {
					juiz = new Juiz();
					juiz.setIdJuiz(rs.getInt("j.id"));
					juiz.setNomeJuiz(rs.getString("j.nome"));
					juiz.setData_nascimento(rs.getDate("j.data_nascimento"));
					cidade = new Cidade();
					cidade.setIdCidade(rs.getInt("j.cidade_id"));
					cidade.setNomeCidade(rs.getString("c.nome"));
					juiz.setCidade(cidade);
					estado = new Estado();
					estado.setIdEstado(rs.getInt("j.estado_id"));
					estado.setNomeEstado(rs.getString("e.nome"));
					juiz.setEstado(estado);
					lista.add(juiz);
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new IOException(e);
		}
				
		return lista;
	}
/*
	public ArrayList<Juiz> listarJogador() throws IOException {
		ArrayList<Juiz> lista = new ArrayList<>();
		String sql = "SELECT * FROM campeonato.juiz";
		try(Connection conn = ConnectionFactory.getConnection();
			PreparedStatement pst = conn.prepareStatement(sql);
			ResultSet rs = pst.executeQuery();){
			
			Juiz juiz;
			Cidade cidade;
			Estado estado;
			while(rs.next()) {
				juiz = new Juiz();
				juiz.setIdJuiz(rs.getInt("j.id"));
				juiz.setNomeJuiz(rs.getString("j.nome"));
				juiz.setData_nascimento(rs.getDate("j.data_nascimento"));
				cidade = new Cidade();
				cidade.setIdCidade(rs.getInt("j.cidade_id"));
				cidade.setNomeCidade(rs.getString("c.nome"));
				juiz.setCidade(cidade);
				estado = new Estado();
				estado.setIdEstado(rs.getInt("j.estado_id"));
				estado.setNomeEstado(rs.getString("e.nome"));
				juiz.setEstado(estado);
				lista.add(juiz);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new IOException(e);
		}				
		return lista;
	}*/
}
