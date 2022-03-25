package br.com.soc.sistema.soap.business;

import br.com.soc.sistema.business.exame.ExameBusiness;
import br.com.soc.sistema.soap.exception.ExameException;
import br.com.soc.sistema.soap.mapper.ExameMapper;
import br.com.soc.sistema.soap.response.exame.Exame;

public class WebServiceExamesBusiness {

	private ExameBusiness exameBusiness;

	public WebServiceExamesBusiness() {
		this.exameBusiness = new ExameBusiness();
	}

	public Exame buscarExamePor(String codigo) {
		try {
			return ExameMapper.voToResponse(exameBusiness.buscarExamePor(codigo));
		} catch (Exception e) {
			throw new ExameException(e.getMessage(), e.getMessage());
		}
	}

	public void inserirExame(Exame exame) {
		try {
			exameBusiness.salvarExame(ExameMapper.requestToVo(exame));
		} catch (Exception e) {
			throw new ExameException(e.getMessage(), e.getMessage());
		}
	}

	public void alterarExame(Exame exame) {
		try {
			exameBusiness.atualizarExame(ExameMapper.requestToVo(exame));
		} catch (Exception e) {
			throw new ExameException(e.getMessage(), e.getMessage());
		}

	}
	
	public void excluirExamePorId(String id) {
		try {
			exameBusiness.excluirExame(id);
		} catch (Exception e) {
			throw new ExameException(e.getMessage(), e.getMessage());
		}

	}

}
