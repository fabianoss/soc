package br.com.soc.sistema.business.funcionario;

import java.util.ArrayList;
import java.util.List;

import br.com.soc.sistema.dao.funcionario.FuncionarioDao;
import br.com.soc.sistema.exception.BusinessException;
import br.com.soc.sistema.filter.funcionario.FuncionarioFilter;
import br.com.soc.sistema.vo.funcionario.FuncionarioVo;

public class FuncionarioBusiness {

	private static final String FOI_INFORMADO_CARACTER_NO_LUGAR_DE_UM_NUMERO = "Foi informado um caracter no lugar de um numero";
	private FuncionarioDao dao;
	

	public FuncionarioBusiness() {
		this.dao = new FuncionarioDao();
	}

	public List<FuncionarioVo> trazerTodosOsFuncionarios() {
		return dao.findAllFuncionarios();
	}

	public void salvarFuncionario(FuncionarioVo funcionarioVo) {
		try {
			if (funcionarioVo.getNome().isEmpty())
				throw new IllegalArgumentException("Nome nao pode ser em branco");

			dao.insertFuncionario(funcionarioVo);
		} catch (Exception e) {
			throw new BusinessException("Nao foi possivel realizar a inclusao do registro");
		}

	}

	public List<FuncionarioVo> filtrarFuncionarios(FuncionarioFilter filter) {
		List<FuncionarioVo> exames = new ArrayList<>();

		switch (filter.getOpcoesCombo()) {
		case ID:
			try {
				Integer codigo = Integer.parseInt(filter.getValorBusca());
				exames.add(dao.findByCodigo(codigo));
			} catch (NumberFormatException e) {
				throw new BusinessException(FOI_INFORMADO_CARACTER_NO_LUGAR_DE_UM_NUMERO);
			}
			break;

		case NOME:
			exames.addAll(dao.findAllByNome(filter.getValorBusca()));
			break;
		}

		return exames;
	}

	public FuncionarioVo buscarFuncionarioPor(String codigo) {
		try {
			Integer cod = Integer.parseInt(codigo);
			return dao.findByCodigo(cod);
		} catch (NumberFormatException e) {
			throw new BusinessException(FOI_INFORMADO_CARACTER_NO_LUGAR_DE_UM_NUMERO);
		}
	}

	public void atualizarFuncionario(FuncionarioVo funcionarioVo) {
		try {
			if (funcionarioVo.getNome().isEmpty())
				throw new IllegalArgumentException("Nome nao pode ser em branco");

			dao.atualizarFuncionario(funcionarioVo);
		} catch (Exception e) {
			throw new BusinessException("Nao foi possivel realizar a atualizacao do registro");
		}
	}

	public void excluirFuncionario(String rowid) {
		try {
			if (rowid == null || rowid.isEmpty())
				throw new IllegalArgumentException("ID não informado para exlusao do exame!");			
			dao.excluirFuncionario(rowid);
		} catch (Exception e) {
			throw new BusinessException("Nao foi possivel realizar a exclusao do registro");
		}
	}

}
