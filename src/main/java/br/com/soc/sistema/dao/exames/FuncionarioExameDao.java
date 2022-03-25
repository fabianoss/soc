package br.com.soc.sistema.dao.exames;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

import br.com.soc.sistema.dao.Dao;
import br.com.soc.sistema.infra.exame.OpcoesComboBuscarFuncionarioExames;
import br.com.soc.sistema.vo.exame.ExameVo;
import br.com.soc.sistema.vo.exame.FuncionarioExameVo;
import br.com.soc.sistema.vo.funcionario.FuncionarioVo;

public class FuncionarioExameDao extends Dao {

	public FuncionarioExameDao() {
		super();
	}

	public List<FuncionarioExameVo> findAllFuncionarioExames() {
		StringBuilder query = new StringBuilder(
				"select a.rowid, rowid_exame,rowid_funcionario,b.nm_exame,c.nome, a.data_exame from exame_funcionario a, exame b, funcionario c where a.rowid_exame = b.rowid and a.rowid_funcionario = c.rowid ");
		try (Connection con = getConexao();
				PreparedStatement ps = con.prepareStatement(query.toString());
				ResultSet rs = ps.executeQuery()) {
			List<FuncionarioExameVo> funcionariosExames = new ArrayList<>();
			while (rs.next()) {
				FuncionarioExameVo fe = new FuncionarioExameVo();
				fe.setRowid(rs.getString("rowid"));
				FuncionarioVo f = new FuncionarioVo();
				f.setRowid(rs.getString("rowid_funcionario"));
				f.setNome(rs.getString("nome"));
				ExameVo e = new ExameVo();
				e.setRowid(rs.getString("rowid_exame"));
				e.setNome(rs.getString("nm_exame"));
				fe.setFuncionario(f);
				fe.setExame(e);
				Date sqlDataexame = rs.getDate("data_exame");
				if (sqlDataexame != null) {
					java.util.Date dateUtil = new java.util.Date(sqlDataexame.getTime());
					SimpleDateFormat formatador = new SimpleDateFormat("dd/MM/yyyy");
					fe.setDateExame(formatador.format(dateUtil));
				}
				funcionariosExames.add(fe);
			}
			return funcionariosExames;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return Collections.emptyList();
	}

	public boolean validaExameFuncionario(FuncionarioExameVo funcionarioExameVo){
		StringBuilder query = new StringBuilder("select * from exame_funcionario a where a.rowid_exame = ? and a.rowid_funcionario = ? and a.data_exame = ? ");
		try(
			Connection con = getConexao();
			PreparedStatement  ps = con.prepareStatement(query.toString())){
			int i=1;
			ps.setString(i++, funcionarioExameVo.getExame().getRowid());
			ps.setString(i++, funcionarioExameVo.getFuncionario().getRowid());
			ps.setString(i++, funcionarioExameVo.getDateExame());
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				return true;
			}else {
				return false;
			}			
		}catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	public void insertExame(FuncionarioExameVo funcionarioExameVo) {
		StringBuilder query = new StringBuilder(
				"INSERT INTO exame_funcionario (rowid_exame,rowid_funcionario,data_exame) values (?,?,?)");
		try (Connection con = getConexao(); PreparedStatement ps = con.prepareStatement(query.toString())) {
			int i = 1;
			ps.setString(i++, funcionarioExameVo.getExame().getRowid());
			ps.setString(i++, funcionarioExameVo.getFuncionario().getRowid());						
			ps.setString(i++, funcionarioExameVo.getDateExame());
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void excluirExame(String rowid) {

		StringBuilder query = new StringBuilder("delete from exame_funcionario where rowid = ?");
		try (Connection con = getConexao(); PreparedStatement ps = con.prepareStatement(query.toString())) {

			int i = 1;
			ps.setString(i, rowid);
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void excluirExameByFuncionario(String rowid) {

		StringBuilder query = new StringBuilder("delete from exame_funcionario where rowid_funcionario = ?");
		try (Connection con = getConexao(); PreparedStatement ps = con.prepareStatement(query.toString())) {

			int i = 1;
			ps.setString(i, rowid);
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void atualizarExame(FuncionarioExameVo exameVo) {
		StringBuilder query = new StringBuilder("UPDATE exame_funcionario set data_exame = ? where rowid = ?");
		try (Connection con = getConexao(); PreparedStatement ps = con.prepareStatement(query.toString())) {
			int i = 1;
			ps.setString(i++, exameVo.getDateExame());
			ps.setString(i, exameVo.getRowid());
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public FuncionarioExameVo findByCodigo(Integer codigo) {
		StringBuilder query = new StringBuilder("select a.rowid, rowid_exame,rowid_funcionario,b.nm_exame,c.nome, a.data_exame from exame_funcionario a, exame b, funcionario c where a.rowid_exame = b.rowid and a.rowid_funcionario = c.rowid and a.rowid = ? ");
		FuncionarioExameVo fe = new FuncionarioExameVo();
		try (Connection con = getConexao(); PreparedStatement ps = con.prepareStatement(query.toString())) {
			int i = 1;
			ps.setInt(i, codigo);
			try (ResultSet rs = ps.executeQuery()) {
				while (rs.next()) {					
					fe.setRowid(rs.getString("rowid"));
					FuncionarioVo f = new FuncionarioVo();
					f.setRowid(rs.getString("rowid_funcionario"));
					f.setNome(rs.getString("nome"));
					ExameVo e = new ExameVo();
					e.setRowid(rs.getString("rowid_exame"));
					e.setNome(rs.getString("nm_exame"));
					fe.setFuncionario(f);
					fe.setExame(e);
					fe.setDateExame(rs.getString("data_exame"));					
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return fe;
	}

	public List<FuncionarioExameVo> findAllByNome(String valor, OpcoesComboBuscarFuncionarioExames opcao) {
		StringBuilder query = new StringBuilder("select a.rowid, rowid_exame,rowid_funcionario,b.nm_exame,c.nome, a.data_exame from exame_funcionario a, exame b, funcionario c where a.rowid_exame = b.rowid and a.rowid_funcionario = c.rowid ");
				switch (opcao) {
				case  NOME_EXAME:	
					query.append("and lower(b.nm_exame) like lower('%"+valor+"%') ");
					break;
				case  NOME_FUNCIONARIO:
					query.append("and lower(c.nome) like lower('%"+valor+"%') ");
					break;
				case DATA:
					query.append("and a.data_exame = '"+valor+"'");
					break;
				}


		try (Connection con = getConexao(); PreparedStatement ps = con.prepareStatement(query.toString())) {
			int i = 1;
			try (ResultSet rs = ps.executeQuery()) {				
				List<FuncionarioExameVo> funcionariosExames = new ArrayList<>();
				while (rs.next()) {
					FuncionarioExameVo fe = new FuncionarioExameVo();
					fe.setRowid(rs.getString("rowid"));
					FuncionarioVo f = new FuncionarioVo();
					f.setRowid(rs.getString("rowid_funcionario"));
					f.setNome(rs.getString("nome"));
					ExameVo e = new ExameVo();
					e.setRowid(rs.getString("rowid_exame"));
					e.setNome(rs.getString("nm_exame"));
					fe.setFuncionario(f);
					fe.setExame(e);
					Date sqlDataexame = rs.getDate("data_exame");
					if (sqlDataexame != null) {
						java.util.Date dateUtil = new java.util.Date(sqlDataexame.getTime());
						SimpleDateFormat formatador = new SimpleDateFormat("dd/MM/yyyy");
						fe.setDateExame(formatador.format(dateUtil));
					}
					funcionariosExames.add(fe);
				}
				return funcionariosExames;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return Collections.emptyList();
	}

	public boolean existeExameFuncionarioByExame(String rowid){
		StringBuilder query = new StringBuilder("select * from exame_funcionario a where a.rowid_exame = ? ");
		try(
			Connection con = getConexao();
			PreparedStatement  ps = con.prepareStatement(query.toString())){
			int i=1;
			ps.setString(i++,rowid);
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				return true;
			}else {
				return false;
			}			
		}catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
	
	public List<FuncionarioExameVo> findFuncionarioExamesByPeriodo(String dataInicial,String dataFinal) {
		StringBuilder query = new StringBuilder(
				"select a.rowid, rowid_exame,rowid_funcionario,b.nm_exame,c.nome, a.data_exame from exame_funcionario a, exame b, funcionario c where a.rowid_exame = b.rowid and a.rowid_funcionario = c.rowid and a.data_exame >= ? and a.data_exame <= ?  ");
		try (Connection con = getConexao();
				PreparedStatement ps = con.prepareStatement(query.toString())) {
			int i=1;
			ps.setString(i++,dataInicial);			
			ps.setString(i++,dataFinal);
			ResultSet rs = ps.executeQuery();
			List<FuncionarioExameVo> funcionariosExames = new ArrayList<>();
			while (rs.next()) {
				FuncionarioExameVo fe = new FuncionarioExameVo();
				fe.setRowid(rs.getString("rowid"));
				FuncionarioVo f = new FuncionarioVo();
				f.setRowid(rs.getString("rowid_funcionario"));
				f.setNome(rs.getString("nome"));
				ExameVo e = new ExameVo();
				e.setRowid(rs.getString("rowid_exame"));
				e.setNome(rs.getString("nm_exame"));
				fe.setFuncionario(f);
				fe.setExame(e);
				fe.setDateExame(rs.getString("data_exame"));				
				funcionariosExames.add(fe);
			}
			return funcionariosExames;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return Collections.emptyList();
	}	
}
