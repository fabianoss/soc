package br.com.soc.sistema.action.funcionario;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import br.com.soc.sistema.business.exame.FuncionarioExameBusiness;
import br.com.soc.sistema.business.funcionario.FuncionarioBusiness;
import br.com.soc.sistema.filter.funcionario.FuncionarioFilter;
import br.com.soc.sistema.infra.Action;
import br.com.soc.sistema.infra.funcionario.OpcoesComboBuscarFuncionario;
import br.com.soc.sistema.vo.funcionario.FuncionarioVo;

public class FuncionarioAction extends Action {
	private List<FuncionarioVo> funcionarios = new ArrayList<>();
	private FuncionarioBusiness business = new FuncionarioBusiness();
	private FuncionarioFilter filtrar = new FuncionarioFilter();
	private FuncionarioVo funcionarioVo = new FuncionarioVo();
	private FuncionarioExameBusiness funcionarioExameBusiness = new FuncionarioExameBusiness();

	private static final long serialVersionUID = 7436288026504612386L;

	public String todos() {

		funcionarios.addAll(business.trazerTodosOsFuncionarios());
		return SUCCESS;
	}

	public String filtrar() {
		if (filtrar.isNullOpcoesCombo())
			return REDIRECT;

		funcionarios = business.filtrarFuncionarios(filtrar);

		return SUCCESS;
	}

	public String novo() {
		if (funcionarioVo.getNome() == null)
			return INPUT;

		business.salvarFuncionario(funcionarioVo);

		return REDIRECT;
	}

	public String editar() {
		if (funcionarioVo.getRowid() == null)
			return REDIRECT;

		funcionarioVo = business.buscarFuncionarioPor(funcionarioVo.getRowid());

		return "atualizar";
	}

	public String salvar() {
		if (funcionarioVo.getNome() == null)
			return INPUT;

		business.atualizarFuncionario(funcionarioVo);

		return REDIRECT;
	}

	public String excluir() {
		if (funcionarioVo.getRowid() == null)
			return REDIRECT;

		funcionarioExameBusiness.excluirExameByFuncionario(funcionarioVo.getRowid());
		business.excluirFuncionario(funcionarioVo.getRowid());
		funcionarios.addAll(business.trazerTodosOsFuncionarios());

		return SUCCESS;
	}

	public List<OpcoesComboBuscarFuncionario> getListaOpcoesCombo() {
		return Arrays.asList(OpcoesComboBuscarFuncionario.values());
	}

	public List<FuncionarioVo> getFuncionarios() {
		return funcionarios;
	}

	public void setExames(List<FuncionarioVo> funcionarios) {
		this.funcionarios = funcionarios;
	}

	public FuncionarioFilter getFiltrar() {
		return filtrar;
	}

	public void setFiltrar(FuncionarioFilter filtrar) {
		this.filtrar = filtrar;
	}

	public FuncionarioVo getFuncionarioVo() {
		return funcionarioVo;
	}

	public void setFuncionarioVo(FuncionarioVo funcionarioVo) {
		this.funcionarioVo = funcionarioVo;
	}

}
