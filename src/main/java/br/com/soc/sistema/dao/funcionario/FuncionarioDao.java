package br.com.soc.sistema.dao.funcionario;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import br.com.soc.sistema.dao.Dao;
import br.com.soc.sistema.vo.funcionario.FuncionarioVo;

public class FuncionarioDao extends Dao {
	
	public void insertFuncionario(FuncionarioVo funcionarioVo){
		StringBuilder query = new StringBuilder("INSERT INTO funcionario (nome) values (?)");
		try(
			Connection con = getConexao();
			PreparedStatement  ps = con.prepareStatement(query.toString())){
			
			int i=1;
			ps.setString(i++, funcionarioVo.getNome());
			ps.executeUpdate();
		}catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public List<FuncionarioVo> findAllFuncionarios(){
		StringBuilder query = new StringBuilder("SELECT rowid id, nome FROM funcionario");
		try(
			Connection con = getConexao();
			PreparedStatement  ps = con.prepareStatement(query.toString());
			ResultSet rs = ps.executeQuery()){
			
			FuncionarioVo vo =  null;
			List<FuncionarioVo> funcionarios = new ArrayList<>();
			while (rs.next()) {
				vo = new FuncionarioVo();
				vo.setRowid(rs.getString("id"));
				vo.setNome(rs.getString("nome"));	
				
				funcionarios.add(vo);
			}
			return funcionarios;
		}catch (SQLException e) {
			e.printStackTrace();
		}
		
		return Collections.emptyList();
	}
	
	public List<FuncionarioVo> findAllByNome(String nome){
		StringBuilder query = new StringBuilder("SELECT rowid id, nome FROM funcionario ")
								.append("WHERE lower(nome) like lower(?)");
		
		try(Connection con = getConexao();
			PreparedStatement ps = con.prepareStatement(query.toString())){
			int i = 1;
			
			ps.setString(i, "%"+nome+"%");
			
			try(ResultSet rs = ps.executeQuery()){
				FuncionarioVo vo =  null;
				List<FuncionarioVo> funcionarios = new ArrayList<>();
				
				while (rs.next()) {
					vo = new FuncionarioVo();
					vo.setRowid(rs.getString("id"));
					vo.setNome(rs.getString("nome"));	
					
					funcionarios.add(vo);
				}
				return funcionarios;
			}
		}catch (SQLException e) {
			e.printStackTrace();
		}		
		return Collections.emptyList();
	}
	
	public FuncionarioVo findByCodigo(Integer codigo){
		StringBuilder query = new StringBuilder("SELECT rowid id, nome FROM funcionario ")
								.append("WHERE rowid = ?");
		
		try(Connection con = getConexao();
			PreparedStatement ps = con.prepareStatement(query.toString())){
			int i = 1;
			
			ps.setInt(i, codigo);
			
			try(ResultSet rs = ps.executeQuery()){
				FuncionarioVo vo =  null;
				
				while (rs.next()) {
					vo = new FuncionarioVo();
					vo.setRowid(rs.getString("id"));
					vo.setNome(rs.getString("nome"));	
				}
				return vo;
			}
		}catch (SQLException e) {
			e.printStackTrace();
		}		
		return null;
	}
	
	public void atualizarFuncionario(FuncionarioVo funcionarioVo){
		
		StringBuilder query = new StringBuilder("UPDATE funcionario set nome = ? where rowid = ?");
		try(
			Connection con = getConexao();
			PreparedStatement  ps = con.prepareStatement(query.toString())){
			
			int i=1;
			ps.setString(i++, funcionarioVo.getNome());
			ps.setString(i, funcionarioVo.getRowid());
			ps.executeUpdate();
		}catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void excluirFuncionario(String rowid){
		
		StringBuilder query = new StringBuilder("delete from funcionario where rowid = ?");
		try(
			Connection con = getConexao();
			PreparedStatement  ps = con.prepareStatement(query.toString())){
			
			int i=1;			
			ps.setString(i, rowid);
			ps.executeUpdate();
		}catch (SQLException e) {
			e.printStackTrace();
		}
	}
}