package br.com.soc.sistema.soap.service;

import javax.jws.WebService;

import br.com.soc.sistema.soap.business.WebServiceExamesRealizadosBusiness;
import br.com.soc.sistema.soap.response.exame.ExameRealizado;

@WebService(endpointInterface = "br.com.soc.sistema.soap.service.WebServiceExamesRealizados")
public class WebServiceExamesRealizadosImpl implements WebServiceExamesRealizados {

	private WebServiceExamesRealizadosBusiness business;

	public WebServiceExamesRealizadosImpl() {
		this.business = new WebServiceExamesRealizadosBusiness();
	}

	@Override
	public ExameRealizado buscaExameRealizadoPorId(String id) {
		return business.buscarExamePor(id);
	}

	@Override
	public void marcarExame(ExameRealizado exameRealizado) {
		business.inserirExame(exameRealizado);
	}

	@Override
	public void alterarExameRealizado(String id, String dataExame) {
		business.alterarExame(id, dataExame);
	}

	@Override
	public void excluirExameRealizadoPorId(String id) {
		business.excluirExamePorId(id);
	}

}
