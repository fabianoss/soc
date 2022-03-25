package br.com.soc.sistema.soap.service;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import javax.jws.WebParam.Mode;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.Style;
import javax.jws.soap.SOAPBinding.Use;

import br.com.soc.sistema.soap.response.funcionario.Funcionario;

@WebService
@SOAPBinding(style = Style.RPC, use = Use.LITERAL)
public interface WebServiceFuncionarios {

	@WebMethod(operationName = "buscaFuncionarioPorId")
	Funcionario buscaFuncionarioPorId(@WebParam(mode = Mode.IN, name = "id") String id);

	@WebMethod(operationName = "inserirFuncionario")
	void inserirFuncionario(@WebParam(mode = Mode.IN, name = "funcionario") Funcionario funcionario);

	@WebMethod(operationName = "alterarFuncionario")
	void alterarFuncionario(@WebParam(mode = Mode.IN, name = "funcionario") Funcionario funcionario);

	@WebMethod(operationName = "excluirFuncionarioPorId")
	void excluirFuncionarioPorId(@WebParam(mode = Mode.IN, name = "id") String id);

}
