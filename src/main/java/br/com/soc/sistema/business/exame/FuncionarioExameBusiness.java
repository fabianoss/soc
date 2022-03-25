package br.com.soc.sistema.business.exame;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import br.com.soc.sistema.business.funcionario.FuncionarioBusiness;
import br.com.soc.sistema.dao.exames.FuncionarioExameDao;
import br.com.soc.sistema.exception.BusinessException;
import br.com.soc.sistema.filter.exame.FuncionarioExameFilter;
import br.com.soc.sistema.vo.exame.ExameVo;
import br.com.soc.sistema.vo.exame.FuncionarioExameVo;
import br.com.soc.sistema.vo.funcionario.FuncionarioVo;

public class FuncionarioExameBusiness {

	private static final String FOI_INFORMADO_CARACTER_NO_LUGAR_DE_UM_NUMERO = "Foi informado um caracter no lugar de um numero";
	private FuncionarioExameDao dao;
	private ExameBusiness exameBusiness;
	private FuncionarioBusiness funcionarioBusiness;

	public FuncionarioExameBusiness() {
		this.dao = new FuncionarioExameDao();
		this.exameBusiness = new ExameBusiness();
		this.funcionarioBusiness = new FuncionarioBusiness();
	}

	public List<FuncionarioExameVo> trazerTodosOsExames() {
		return dao.findAllFuncionarioExames();
	}

	public void salvarExame(FuncionarioExameVo funcionarioFuncionarioExameVo) {
		try {
			if (funcionarioFuncionarioExameVo == null || funcionarioFuncionarioExameVo.getExame() == null
					|| funcionarioFuncionarioExameVo.getExame().getRowid() == null
					|| funcionarioFuncionarioExameVo.getExame().getRowid().isEmpty()
					|| funcionarioFuncionarioExameVo.getFuncionario().getRowid() == null
					|| funcionarioFuncionarioExameVo.getFuncionario().getRowid().isEmpty()) {
				throw new IllegalArgumentException("Dados incorretos");
			}

			if (!dao.validaExameFuncionario(funcionarioFuncionarioExameVo)) {
				dao.insertExame(funcionarioFuncionarioExameVo);
			}
		} catch (Exception e) {
			throw new BusinessException("Nao foi possivel realizar a inclusao do registro");
		}

	}

	public List<FuncionarioExameVo> filtrarExames(FuncionarioExameFilter filter) {
		List<FuncionarioExameVo> exames = new ArrayList<>();

		switch (filter.getOpcoesCombo()) {
		case ID:
			try {
				Integer codigo = Integer.parseInt(filter.getValorBusca());
				exames.add(dao.findByCodigo(codigo));
			} catch (NumberFormatException e) {
				throw new BusinessException(FOI_INFORMADO_CARACTER_NO_LUGAR_DE_UM_NUMERO);
			}
			break;
		case NOME_EXAME:
		case NOME_FUNCIONARIO:
		case DATA:
			exames.addAll(dao.findAllByNome(filter.getValorBusca(), filter.getOpcoesCombo()));
			break;
		}

		return exames;
	}

	public FuncionarioExameVo buscarExamePor(String codigo) {
		try {
			Integer cod = Integer.parseInt(codigo);
			return dao.findByCodigo(cod);
		} catch (NumberFormatException e) {
			throw new BusinessException(FOI_INFORMADO_CARACTER_NO_LUGAR_DE_UM_NUMERO);
		}
	}

	public void atualizarExame(FuncionarioExameVo exameVo) {
		try {
			if (exameVo.getRowid().isEmpty()) {
				throw new IllegalArgumentException("Nome nao pode ser em branco");
			}

			if (!dao.validaExameFuncionario(exameVo)) {
				dao.atualizarExame(exameVo);
			}

		} catch (Exception e) {
			throw new BusinessException("Nao foi possivel realizar a atualizacao do registro");
		}

	}

	public void excluirExame(String rowid) {
		try {
			if (rowid == null || rowid.isEmpty())
				throw new IllegalArgumentException("ID não informado para exlusao do exame!");
			dao.excluirExame(rowid);
		} catch (Exception e) {
			throw new BusinessException("Nao foi possivel realizar a exclusao do registro");
		}

	}

	public void excluirExameByFuncionario(String rowid) {
		try {
			if (rowid == null || rowid.isEmpty())
				throw new IllegalArgumentException("ID não informado para exlusao do exame!");
			dao.excluirExameByFuncionario(rowid);
		} catch (Exception e) {
			throw new BusinessException("Nao foi possivel realizar a exclusao do registro");
		}
	}

	public boolean existeExameFuncionarioByExame(String rowid) {
		boolean ret = false;
		try {
			if (rowid == null || rowid.isEmpty())
				throw new IllegalArgumentException("ID não informado para exlusao do exame!");
			ret = dao.existeExameFuncionarioByExame(rowid);
		} catch (Exception e) {
			throw new BusinessException("Nao foi possivel realizar a exclusao do registro");
		}
		return ret;
	}

	public List<ExameVo> listAllExames() {
		return exameBusiness.trazerTodosOsExames();
	}

	public List<FuncionarioVo> listAllFuncionario() {
		return funcionarioBusiness.trazerTodosOsFuncionarios();
	}

	public List<FuncionarioExameVo> findFuncionarioExamesByPeriodo(String dataInicial, String dataFinal) {
		List<FuncionarioExameVo> exames = Collections.emptyList();
		try {
			SimpleDateFormat formatador = new SimpleDateFormat("yyyy-MM-dd");
			java.util.Date dtInicial = formatador.parse(dataFinal);
			java.util.Date dtFinal = formatador.parse(dataFinal);
			if (dtInicial.after(dtFinal)) {
				return Collections.emptyList();
			}
			exames = dao.findFuncionarioExamesByPeriodo(dataInicial, dataFinal);
		} catch (Exception e) {
			throw new BusinessException("Nao foi possivel realizar a busca dos registro");
		}
		return exames;
	}

}
