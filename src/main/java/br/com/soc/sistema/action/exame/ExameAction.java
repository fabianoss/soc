package br.com.soc.sistema.action.exame;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import br.com.soc.sistema.business.exame.ExameBusiness;
import br.com.soc.sistema.business.exame.FuncionarioExameBusiness;
import br.com.soc.sistema.filter.exame.ExameFilter;
import br.com.soc.sistema.infra.Action;
import br.com.soc.sistema.infra.exame.OpcoesComboBuscarExames;
import br.com.soc.sistema.vo.exame.ExameVo;

public class ExameAction extends Action {
	private List<ExameVo> exames = new ArrayList<>();
	private ExameBusiness business = new ExameBusiness();
	private ExameFilter filtrar = new ExameFilter();
	private ExameVo exameVo = new ExameVo();	
	private FuncionarioExameBusiness funcionarioExameBusiness = new FuncionarioExameBusiness();
	
	public String todos() {
		
		exames.addAll(business.trazerTodosOsExames());
		return SUCCESS;
	}
	
	public String filtrar() {
		if(filtrar.isNullOpcoesCombo())
			return REDIRECT;
		
		exames = business.filtrarExames(filtrar);
		
		return SUCCESS;
	}
	
	public String novo() {
		if(exameVo.getNome() == null)
			return INPUT;
		
		business.salvarExame(exameVo);
		
		return REDIRECT;
	}
	
	public String editar() {
		if(exameVo.getRowid() == null)
			return REDIRECT;
		
		exameVo = business.buscarExamePor(exameVo.getRowid());
		
		return "atualizar";
	}
	
	public String salvar() {
		if(exameVo.getNome() == null)
			return INPUT;
		
		business.atualizarExame(exameVo);
		
		return REDIRECT;
	}
	
	public String excluir() {
		if(exameVo.getRowid() == null)
			return REDIRECT;
		
		if(!funcionarioExameBusiness.existeExameFuncionarioByExame(exameVo.getRowid())) {
			business.excluirExame(exameVo.getRowid());
		}
		exames.addAll(business.trazerTodosOsExames());
		return SUCCESS;
	}
	
	public List<OpcoesComboBuscarExames> getListaOpcoesCombo(){
		return Arrays.asList(OpcoesComboBuscarExames.values());
	}
	
	public List<ExameVo> getExames() {
		return exames;
	}

	public void setExames(List<ExameVo> exames) {
		this.exames = exames;
	}

	public ExameFilter getFiltrar() {
		return filtrar;
	}

	public void setFiltrar(ExameFilter filtrar) {
		this.filtrar = filtrar;
	}

	public ExameVo getExameVo() {
		return exameVo;
	}

	public void setExameVo(ExameVo exameVo) {
		this.exameVo = exameVo;
	}

}
