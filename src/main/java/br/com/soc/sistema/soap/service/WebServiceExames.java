package br.com.soc.sistema.soap.service;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebParam.Mode;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.Style;
import javax.jws.soap.SOAPBinding.Use;

import br.com.soc.sistema.soap.response.exame.Exame;

@WebService
@SOAPBinding(style = Style.RPC, use = Use.LITERAL)
public interface WebServiceExames {

	@WebMethod(operationName = "buscaExamePorId")
	@WebResult(name = "Exame")  
	Exame buscaExamePorId(@WebParam(mode = Mode.IN, name = "id") String id);

	@WebMethod(operationName = "inserirExame")
	void inserirExame(@WebParam(mode = Mode.IN, name = "exame") Exame exame);

	@WebMethod(operationName = "alterarExame")
	void alterarExame(@WebParam(mode = Mode.IN, name = "exame") Exame exame);

	@WebMethod(operationName = "excluirExamePorId")
	void excluirExamePorId(@WebParam(mode = Mode.IN, name = "id") String id);

}
