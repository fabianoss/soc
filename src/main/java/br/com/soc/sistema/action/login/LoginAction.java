package br.com.soc.sistema.action.login;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import br.com.soc.sistema.business.login.LoginBusiness;
import br.com.soc.sistema.vo.login.UserVo;

public class LoginAction extends ActionSupport implements SessionAware, ModelDriven<UserVo> {

	private static final long serialVersionUID = -3369875299120377549L;

	private UserVo user = new UserVo();
	private Map<String, Object> sessionAttributes = null;
	private LoginBusiness loginBusiness = new LoginBusiness();

	@Override
	public String execute() {
		System.out.println("inside execute");
		UserVo userLogger = loginBusiness.getUser(user);
		if (userLogger != null) {
			sessionAttributes.put("USER", user);
			return SUCCESS;
		}
		return INPUT;
	}

	@Override
	public void setSession(Map<String, Object> sessionAttributes) {
		this.sessionAttributes = sessionAttributes;
	}

	@Override
	public UserVo getModel() {
		return user;
	}
		
	public String index() {
		return SUCCESS;		
	}

}
