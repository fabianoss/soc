package br.com.soc.sistema.soap.business;

import br.com.soc.sistema.business.funcionario.FuncionarioBusiness;
import br.com.soc.sistema.soap.exception.FuncionarioException;
import br.com.soc.sistema.soap.mapper.FuncionarioMapper;
import br.com.soc.sistema.soap.response.funcionario.Funcionario;

public class WebServiceFuncionariosBusiness {

	private FuncionarioBusiness funcionarioBusiness;

	public WebServiceFuncionariosBusiness() {
		this.funcionarioBusiness = new FuncionarioBusiness();
	}

	public Funcionario buscaFuncionarioPorId(String codigo) {
		try {
			return FuncionarioMapper.voToResponse(funcionarioBusiness.buscarFuncionarioPor(codigo));
		} catch (Exception e) {
			throw new FuncionarioException(e.getMessage(), e.getMessage());
		}
	}

	public void inserirFuncionario(Funcionario funcionario) {
		try {
			funcionarioBusiness.salvarFuncionario(FuncionarioMapper.requestToVo(funcionario));
		} catch (Exception e) {
			throw new FuncionarioException(e.getMessage(), e.getMessage());
		}
	}

	public void alterarFuncionario(Funcionario funcionario) {
		try {
			funcionarioBusiness.atualizarFuncionario(FuncionarioMapper.requestToVo(funcionario));
		} catch (Exception e) {
			throw new FuncionarioException(e.getMessage(), e.getMessage());
		}

	}
	
	public void excluirFuncionarioPorId(String id) {
		try {
			funcionarioBusiness.excluirFuncionario(id);
		} catch (Exception e) {
			throw new FuncionarioException(e.getMessage(), e.getMessage());
		}

	}

}
