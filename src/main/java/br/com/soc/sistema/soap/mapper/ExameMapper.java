package br.com.soc.sistema.soap.mapper;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import br.com.soc.sistema.soap.response.exame.Exame;
import br.com.soc.sistema.vo.exame.ExameVo;

public class ExameMapper {

	public static Exame voToResponse(ExameVo vo) {
		if (vo == null) {
			return null;
		}
		Exame exame = new Exame();
		exame.setRowid(vo.getRowid());
		exame.setNome(vo.getNome());
		return exame;
	}

	public static List<Exame> listVoToListResponse(List<ExameVo> listVo) {
		if (listVo == null || listVo.isEmpty()) {
			return Collections.emptyList();
		}
		List<Exame> exames = new ArrayList<>();
		for (ExameVo exameVo : listVo) {
			exames.add(voToResponse(exameVo));
		}
		return exames;
	}
	
	public static ExameVo requestToVo(Exame request) {
		if (request == null) {
			return null;
		}
		ExameVo exameVo = new ExameVo();
		exameVo.setRowid(request.getRowid());
		exameVo.setNome(request.getNome());
		return exameVo;
	}

	public static List<ExameVo> listRequestToListVo(List<Exame> listRequest) {
		if (listRequest == null || listRequest.isEmpty()) {
			return Collections.emptyList();
		}
		List<ExameVo> exames = new ArrayList<>();
		for (Exame exame : listRequest) {
			exames.add(requestToVo(exame));
		}
		return exames;
	}

}
