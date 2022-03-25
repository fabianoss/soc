package br.com.soc.sistema.action.exame;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import br.com.soc.sistema.business.exame.FuncionarioExameBusiness;
import br.com.soc.sistema.filter.exame.FuncionarioExameFilter;
import br.com.soc.sistema.infra.Action;
import br.com.soc.sistema.infra.exame.OpcoesComboBuscarFuncionarioExames;
import br.com.soc.sistema.vo.exame.ExameVo;
import br.com.soc.sistema.vo.exame.FuncionarioExameVo;
import br.com.soc.sistema.vo.funcionario.FuncionarioVo;

public class FuncionarioExameAction extends Action {

	private static final long serialVersionUID = -5288750868577115814L;
	private List<FuncionarioExameVo> funcionarioExames = new ArrayList<>();
	private FuncionarioExameBusiness business = new FuncionarioExameBusiness();	
	private FuncionarioExameFilter filtrar = new FuncionarioExameFilter();
	private FuncionarioExameVo funcionarioExameVo = new FuncionarioExameVo();
	private List<String> violations = new ArrayList<String>();

	public String todos() {
		funcionarioExames.addAll(business.trazerTodosOsExames());
		return SUCCESS;
	}

	public String filtrar() {
		if (filtrar.isNullOpcoesCombo())
			return REDIRECT;

		funcionarioExames = business.filtrarExames(filtrar);

		return SUCCESS;
	}

	public String novo() {
		if (funcionarioExameVo.getFuncionario() == null)
			return INPUT;

		business.salvarExame(funcionarioExameVo);

		return REDIRECT;
	}

	public String editar() {
		if (funcionarioExameVo.getRowid() == null)
			return REDIRECT;

		funcionarioExameVo = business.buscarExamePor(funcionarioExameVo.getRowid());

		return "atualizar";
	}

	public String salvar() {
		if (funcionarioExameVo.getRowid() == null)
			return INPUT;

		business.atualizarExame(funcionarioExameVo);

		return REDIRECT;
	}

	public String excluir() {
		if (funcionarioExameVo.getRowid() == null)
			return REDIRECT;

		business.excluirExame(funcionarioExameVo.getRowid());
		funcionarioExames.addAll(business.trazerTodosOsExames());

		return SUCCESS;
	}

	public List<OpcoesComboBuscarFuncionarioExames> getListaOpcoesCombo() {
		return Arrays.asList(OpcoesComboBuscarFuncionarioExames.values());
	}

	public List<FuncionarioExameVo> getFuncionarioExames() {
		return funcionarioExames;
	}

	public void setFuncionarioExames(List<FuncionarioExameVo> funcionarioExames) {
		this.funcionarioExames = funcionarioExames;
	}

	public FuncionarioExameFilter getFiltrar() {
		return filtrar;
	}

	public void setFiltrar(FuncionarioExameFilter filtrar) {
		this.filtrar = filtrar;
	}

	public FuncionarioExameVo getFuncionarioExameVo() {
		return funcionarioExameVo;
	}

	public void setFuncionarioExameVo(FuncionarioExameVo funcionarioExameVo) {
		this.funcionarioExameVo = funcionarioExameVo;
	}
	
	public List<ExameVo> getListaOpcoesComboExame() {
		return business.listAllExames();
	}
	
	public List<FuncionarioVo> getListaOpcoesComboFuncionario() {
		return business.listAllFuncionario();
	}

	public List<String> getViolations() {
		return violations;
	}

	public void setViolations(List<String> violations) {
		this.violations = violations;
	}
	
}
