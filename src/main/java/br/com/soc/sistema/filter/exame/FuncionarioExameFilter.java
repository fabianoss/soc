package br.com.soc.sistema.filter.exame;

import br.com.soc.sistema.infra.exame.OpcoesComboBuscarFuncionarioExames;

public class FuncionarioExameFilter {
	private OpcoesComboBuscarFuncionarioExames opcoesCombo;
	private String valorBusca;

	public String getValorBusca() {
		return valorBusca;
	}

	public FuncionarioExameFilter setValorBusca(String valorBusca) {
		this.valorBusca = valorBusca;
		return this;
	}

	public OpcoesComboBuscarFuncionarioExames getOpcoesCombo() {
		return opcoesCombo;
	}

	public FuncionarioExameFilter setOpcoesCombo(String codigo) {
		this.opcoesCombo = OpcoesComboBuscarFuncionarioExames.buscarPor(codigo);
		return this;
	}	
	
	public boolean isNullOpcoesCombo() {
		return this.getOpcoesCombo() == null;
	}
	
	public static FuncionarioExameFilter builder() {
		return new FuncionarioExameFilter();
	}
}
