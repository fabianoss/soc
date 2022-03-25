package br.com.soc.sistema.soap.business;

import java.text.SimpleDateFormat;
import java.util.Date;

import br.com.soc.sistema.business.exame.FuncionarioExameBusiness;
import br.com.soc.sistema.soap.exception.ExameRealizadoException;
import br.com.soc.sistema.soap.mapper.ExameRealizadoMapper;
import br.com.soc.sistema.soap.response.exame.ExameRealizado;

public class WebServiceExamesRealizadosBusiness {

	private FuncionarioExameBusiness exameBusiness;

	public WebServiceExamesRealizadosBusiness() {
		this.exameBusiness = new FuncionarioExameBusiness();
	}

	public ExameRealizado buscarExamePor(String codigo) {
		ExameRealizado response = new ExameRealizado();
		try {
			response = ExameRealizadoMapper.voToResponse(exameBusiness.buscarExamePor(codigo));
			if(response != null && response.getDataExame() != null && !response.getDataExame().isEmpty()) {
				try {				
					SimpleDateFormat formatador = new SimpleDateFormat("yyyy-MM-dd");
					Date dateUtil = formatador.parse(response.getDataExame());
					formatador = new SimpleDateFormat("dd/MM/yyyy");
					response.setDataExame(formatador.format(dateUtil));
				} catch (Exception e) {
					throw new ExameRealizadoException("Erro ao buscar Exame entre em contato com analista! ","Erro ao buscar Exame entre em contato com analista! ");
				}
			}
		} catch (Exception e) {
			throw new ExameRealizadoException(e.getMessage(), e.getMessage());
		}
		return response;
	}

	public void inserirExame(ExameRealizado exameRealizado) {
		try {
			exameBusiness.salvarExame(ExameRealizadoMapper.requestToVo(exameRealizado));
		} catch (Exception e) {
			throw new ExameRealizadoException(e.getMessage(), e.getMessage());
		}
	}

	public void alterarExame(String id, String dataExame) {
		
		if(id == null || id.isEmpty()) {
			throw new ExameRealizadoException("O campo id deve ser informado!", "O campo id deve ser informado!");
		}
		
		if(dataExame == null || dataExame.isEmpty()) {
			throw new ExameRealizadoException("O campo dataExame deve ser informado!", "O campo dataExame deve ser informado!");
		}
		
		if(dataExame.length() != 10) {
			throw new ExameRealizadoException("O campo dataExame está no formato inválido, formato(dd/MM/yyyy)", "O campo dataExame está no formato inválido, formato(dd/MM/yyyy)");
		}
		
		try {			
			SimpleDateFormat formatador = new SimpleDateFormat("dd/MM/yyyy");
			Date dateUtil = formatador.parse(dataExame);
			formatador = new SimpleDateFormat("yyyy-MM-dd");
			dataExame = formatador.format(dateUtil);
		} catch (Exception e) {
			throw new ExameRealizadoException("dataExame informada inválida! ","dataExame informada inválida! ");
		}
		
		try {
			ExameRealizado request = new ExameRealizado();
			request.setRowid(id);
			request.setDataExame(dataExame);
			exameBusiness.atualizarExame(ExameRealizadoMapper.requestToVo(request));
		} catch (Exception e) {
			throw new ExameRealizadoException(e.getMessage(), e.getMessage());
		}

	}

	public void excluirExamePorId(String id) {
		try {
			exameBusiness.excluirExame(id);
		} catch (Exception e) {
			throw new ExameRealizadoException(e.getMessage(), e.getMessage());
		}

	}

}
