package br.com.soc.sistema.dao.login;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import br.com.soc.sistema.dao.Dao;
import br.com.soc.sistema.vo.login.UserVo;

public class LoginDao extends Dao {

	public UserVo getUser(String username, String password) {
		UserVo vo = null;
		StringBuilder query = new StringBuilder("select * from usuario where username = ? and password = ?");
		try (Connection con = getConexao(); PreparedStatement ps = con.prepareStatement(query.toString())) {
			int i = 1;
			ps.setString(i++, username);
			ps.setString(i, password);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				vo = new UserVo();
				vo.setId(rs.getInt("rowid"));
				vo.setUsername(rs.getString("username"));
				vo.setPassword(rs.getString("password"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return vo;
	}

}
