package br.com.soc.sistema.soap.mapper;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import br.com.soc.sistema.soap.response.exame.ExameRealizado;
import br.com.soc.sistema.vo.exame.ExameVo;
import br.com.soc.sistema.vo.exame.FuncionarioExameVo;
import br.com.soc.sistema.vo.funcionario.FuncionarioVo;

public class ExameRealizadoMapper {

	public static ExameRealizado voToResponse(FuncionarioExameVo vo) {
		if (vo == null) {
			return null;
		}
		ExameRealizado exameRealizado = new ExameRealizado();
		exameRealizado.setRowid(vo.getRowid());
		exameRealizado.setRowidExame(vo.getExame().getRowid());
		exameRealizado.setRowidFuncionario(vo.getFuncionario().getRowid());
		exameRealizado.setDataExame(vo.getDateExame());
		return exameRealizado;
	}

	public static List<ExameRealizado> listVoToListResponse(List<FuncionarioExameVo> listVo) {
		if (listVo == null || listVo.isEmpty()) {
			return Collections.emptyList();
		}
		List<ExameRealizado> exames = new ArrayList<>();
		for (FuncionarioExameVo exameVo : listVo) {
			exames.add(voToResponse(exameVo));
		}
		return exames;
	}

	public static FuncionarioExameVo requestToVo(ExameRealizado request) {
		if (request == null) {
			return null;
		}
		FuncionarioExameVo funcionarioExameVo = new FuncionarioExameVo();
		funcionarioExameVo.setRowid(request.getRowid());
		ExameVo exameVo = new ExameVo();
		exameVo.setRowid(request.getRowidExame());
		funcionarioExameVo.setExame(exameVo);
		FuncionarioVo funcionarioVo = new FuncionarioVo();
		funcionarioVo.setRowid(request.getRowidFuncionario());
		funcionarioExameVo.setFuncionario(funcionarioVo);
		funcionarioExameVo.setDateExame(request.getDataExame());
		return funcionarioExameVo;
	}

	public static List<FuncionarioExameVo> listRequestToListVo(List<ExameRealizado> listRequest) {
		if (listRequest == null || listRequest.isEmpty()) {
			return Collections.emptyList();
		}
		List<FuncionarioExameVo> exames = new ArrayList<>();
		for (ExameRealizado exame : listRequest) {
			exames.add(requestToVo(exame));
		}
		return exames;
	}

}
