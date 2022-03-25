package br.com.soc.sistema.action.relatorio;

import java.util.ArrayList;
import java.util.List;

import br.com.soc.sistema.business.exame.FuncionarioExameBusiness;
import br.com.soc.sistema.infra.Action;
import br.com.soc.sistema.vo.exame.FuncionarioExameVo;

public class RelatorioAction extends Action {

	private static final long serialVersionUID = -5288750868577115814L;

	private List<FuncionarioExameVo> funcionariosExames = new ArrayList<>();
	private String dataInicial;
	private String dataFinal;
	private boolean relatorio = false;
	private FuncionarioExameBusiness business = new FuncionarioExameBusiness();

	public String index() {
		return SUCCESS;
	}

	public String pesquisar() {
		if (dataInicial == null || dataInicial.isEmpty() || dataFinal == null || dataFinal.isEmpty()) {
			return REDIRECT;
		}
		funcionariosExames = business.findFuncionarioExamesByPeriodo(dataInicial, dataFinal);
		relatorio = true;
		return SUCCESS;
	}

	public List<FuncionarioExameVo> getFuncionariosExames() {
		return funcionariosExames;
	}

	public void setFuncionariosExames(List<FuncionarioExameVo> funcionariosExames) {
		this.funcionariosExames = funcionariosExames;
	}

	public String getDataInicial() {
		return dataInicial;
	}

	public void setDataInicial(String dataInicial) {
		this.dataInicial = dataInicial;
	}

	public String getDataFinal() {
		return dataFinal;
	}

	public void setDataFinal(String dataFinal) {
		this.dataFinal = dataFinal;
	}

	public boolean isRelatorio() {
		return relatorio;
	}

	public void setRelatorio(boolean relatorio) {
		this.relatorio = relatorio;
	}

}
