package br.com.soc.sistema.soap.service;

import javax.jws.WebService;

import br.com.soc.sistema.soap.business.WebServiceExamesBusiness;
import br.com.soc.sistema.soap.response.exame.Exame;

@WebService(endpointInterface = "br.com.soc.sistema.soap.service.WebServiceExames")
public class WebServiceExamesImpl implements WebServiceExames {

	private WebServiceExamesBusiness business;

	public WebServiceExamesImpl() {
		this.business = new WebServiceExamesBusiness();
	}

	@Override
	public Exame buscaExamePorId(String codigo) {
		return business.buscarExamePor(codigo);
	}

	@Override
	public void inserirExame(Exame exame) {
		business.inserirExame(exame);
	}

	@Override
	public void alterarExame(Exame exame) {
		business.alterarExame(exame);
	}

	@Override
	public void excluirExamePorId(String id) {
		business.excluirExamePorId(id);
	}

}
