package br.com.soc.sistema.soap.service;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.jws.WebParam.Mode;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.Style;
import javax.jws.soap.SOAPBinding.Use;

import br.com.soc.sistema.soap.response.exame.ExameRealizado;

@WebService
@SOAPBinding(style = Style.RPC, use = Use.LITERAL)
public interface WebServiceExamesRealizados {

	@WebMethod(operationName = "buscaExameRealizadoPorId")
	@WebResult(name = "ExameRealizado")
	ExameRealizado buscaExameRealizadoPorId(@WebParam(mode = Mode.IN, name = "id") String id);

	@WebMethod(operationName = "agendarExame")
	void marcarExame(@WebParam(mode = Mode.IN, name = "exameRealizado") ExameRealizado exameRealizado);

	@WebMethod(operationName = "alterarExameRealizado")
	void alterarExameRealizado(@WebParam(mode = Mode.IN, name = "id") String id,
			@WebParam(mode = Mode.IN, name = "dataExame") String dataExame);

	@WebMethod(operationName = "excluirExameRealizadoPorId")
	void excluirExameRealizadoPorId(@WebParam(mode = Mode.IN, name = "id") String id);

}
