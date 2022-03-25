package br.com.soc.sistema.soap.mapper;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import br.com.soc.sistema.soap.response.funcionario.Funcionario;
import br.com.soc.sistema.vo.funcionario.FuncionarioVo;

public class FuncionarioMapper {

	public static Funcionario voToResponse(FuncionarioVo vo) {
		if (vo == null) {
			return null;
		}
		Funcionario funcionario = new Funcionario();
		funcionario.setRowid(vo.getRowid());
		funcionario.setNome(vo.getNome());
		return funcionario;
	}

	public static List<Funcionario> listVoToListResponse(List<FuncionarioVo> listVo) {
		if (listVo == null || listVo.isEmpty()) {
			return Collections.emptyList();
		}
		List<Funcionario> funcionarios = new ArrayList<>();
		for (FuncionarioVo funcionarioVo : listVo) {
			funcionarios.add(voToResponse(funcionarioVo));
		}
		return funcionarios;
	}

	public static FuncionarioVo requestToVo(Funcionario request) {
		if (request == null) {
			return null;
		}
		FuncionarioVo funcionario = new FuncionarioVo();
		funcionario.setRowid(request.getRowid());
		funcionario.setNome(request.getNome());
		return funcionario;
	}

	public static List<FuncionarioVo> listResquestToListVo(List<Funcionario> listRequest) {
		if (listRequest == null || listRequest.isEmpty()) {
			return Collections.emptyList();
		}
		List<FuncionarioVo> funcionarios = new ArrayList<>();
		for (Funcionario funcionario : listRequest) {
			funcionarios.add(requestToVo(funcionario));
		}
		return funcionarios;
	}

}
