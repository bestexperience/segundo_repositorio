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
	public int inserirJuiz(Juiz juiz) throws IOException {
		int id = -1;
		String sql = "INSERT INTO campeonato.juiz (nome, data_nascimento, descricao, cidade_id, estado_id) VALUES (?, ?, ?, ?, ?)";
		
		try(Connection conn = ConnectionFactory.getConnection();
			PreparedStatement pst = conn.prepareStatement(sql);){
			
			pst.setString(1, juiz.getNomeJuiz());
			if(juiz.getData_nascimento() != null) {
				pst.setDate(2, new java.sql.Date(juiz.getData_nascimento().getTime()));
			} else {
				pst.setDate(2,  null);
			}
			pst.setString(3, juiz.getDescricao());
			pst.setInt(4, juiz.getCidade().getIdCidade());	
			pst.setInt(5, juiz.getEstado().getIdEstado());	
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
	
	public Juiz buscarJuiz(int id) throws IOException {
		Juiz juiz = null;
		String sql = "select j.id, j.nome, j.data_nascimento, j.descricao, j.cidade_id, j.estado_id, c.nome, e.nome from juiz j, cidade c, estado e where j.cidade_id = c.id and j.estado_id = e.id and j.id like ?";
		try(Connection conn = ConnectionFactory.getConnection();
			PreparedStatement pst = conn.prepareStatement(sql);){
			
			pst.setInt(1, id);
			
			try(ResultSet rs = pst.executeQuery();){
			
				Cidade cidade;
				Estado estado;
				while(rs.next()) {
					juiz = new Juiz();
					juiz.setIdJuiz(rs.getInt("j.id"));
					juiz.setNomeJuiz(rs.getString("j.nome"));
					juiz.setData_nascimento(rs.getDate("j.data_nascimento"));
					juiz.setDescricao(rs.getString("j.descricao"));
					cidade = new Cidade();
					cidade.setIdCidade(rs.getInt("j.cidade_id"));
					cidade.setNomeCidade(rs.getString("c.nome"));
					juiz.setCidade(cidade);
					estado = new Estado();
					estado.setIdEstado(rs.getInt("j.estado_id"));
					estado.setNomeEstado(rs.getString("e.nome"));
					juiz.setEstado(estado);
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new IOException(e);
		}
		
		return juiz;
	}
	
	
	
	public ArrayList<Juiz> listarJuiz(String chave) throws IOException {
		ArrayList<Juiz> lista = new ArrayList<>();
		String sql = "select j.id, j.nome, j.data_nascimento, j.descricao, j.cidade_id, j.estado_id, c.nome, e.nome from juiz j, cidade c, estado e where j.cidade_id = c.id and j.estado_id = e.id and j.nome like ?";
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
					juiz.setDescricao(rs.getString("j.descricao"));
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

	
	public ArrayList<Juiz> listarJuiz() throws IOException {
		ArrayList<Juiz> lista = new ArrayList<>();
		String sql = "select j.id, j.nome, j.data_nascimento, j.descricao, j.cidade_id, j.estado_id, c.nome, e.nome from juiz j, cidade c, estado e where j.cidade_id = c.id and j.estado_id = e.id";
		
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
				juiz.setDescricao(rs.getString("j.descricao"));
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
	}
	
	
	
public void atualizarJuiz(Juiz juiz) {
		
		String sqlUpdate = "UPDATE campeonato.juiz SET nome=?, data_nascimento=?, descricao=?, cidade_id=?, estado_id=? WHERE id=?";
		
		// usando o try with resources do Java 7, que fecha o que abriu
		try (Connection conn = ConnectionFactory.getConnection();
				PreparedStatement stm = conn.prepareStatement(sqlUpdate);) {
			
			stm.setString(1, juiz.getNomeJuiz());
			
			if(juiz.getData_nascimento() != null) {
				stm.setDate(2, new java.sql.Date(juiz.getData_nascimento().getTime()));
			} else {
				stm.setDate(2,  null);
			}
			stm.setString(3, juiz.getDescricao());
			stm.setInt(4, juiz.getCidade().getIdCidade());
			stm.setInt(5, juiz.getEstado().getIdEstado());
			stm.setInt(6, juiz.getIdJuiz());
			stm.execute();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void excluirJuiz(Juiz juiz) {
		String sqlDelete = "DELETE FROM campeonato.juiz WHERE id = ?";
		// usando o try with resources do Java 7, que fecha o que abriu
		try (Connection conn = ConnectionFactory.getConnection();
				PreparedStatement stm = conn.prepareStatement(sqlDelete);) {
			int id = juiz.getIdJuiz();
			stm.setInt(1, id);
			stm.execute();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
