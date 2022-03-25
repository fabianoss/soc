package br.com.soc.sistema.soap.service;

import javax.jws.WebService;

import br.com.soc.sistema.soap.business.WebServiceFuncionariosBusiness;
import br.com.soc.sistema.soap.response.funcionario.Funcionario;

@WebService(endpointInterface = "br.com.soc.sistema.soap.service.WebServiceFuncionarios")
public class WebServiceFuncionariosImpl implements WebServiceFuncionarios {

	private WebServiceFuncionariosBusiness business;

	public WebServiceFuncionariosImpl() {
		this.business = new WebServiceFuncionariosBusiness();
	}

	@Override
	public Funcionario buscaFuncionarioPorId(String id) {
		return business.buscaFuncionarioPorId(id);
	}

	@Override
	public void inserirFuncionario(Funcionario funcionario) {
		business.inserirFuncionario(funcionario);
	}

	@Override
	public void alterarFuncionario(Funcionario funcionario) {
		business.alterarFuncionario(funcionario);
	}

	@Override
	public void excluirFuncionarioPorId(String id) {
		business.excluirFuncionarioPorId(id);
	}

}
