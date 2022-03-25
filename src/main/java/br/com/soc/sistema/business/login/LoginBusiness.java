package br.com.soc.sistema.business.login;

import br.com.soc.sistema.dao.login.LoginDao;
import br.com.soc.sistema.exception.BusinessException;
import br.com.soc.sistema.vo.login.UserVo;

public class LoginBusiness {

	private LoginDao dao;

	public LoginBusiness() {
		this.dao = new LoginDao();
	}

	public UserVo getUser(UserVo user) {
		UserVo vo = null;
		try {
			if (user == null) {
				return vo;
			}
			if (user.getUsername() == null || user.getUsername().isEmpty()) {
				return vo;
			}

			if (user.getPassword() == null || user.getPassword().isEmpty()) {
				return vo;
			}
			vo = dao.getUser(user.getUsername(), user.getPassword());
		} catch (Exception e) {
			throw new BusinessException("Nao foi possivel realizar login");
		}
		return vo;
	}

}
