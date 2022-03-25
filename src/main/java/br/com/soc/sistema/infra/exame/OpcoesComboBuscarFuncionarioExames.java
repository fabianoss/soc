package br.com.soc.sistema.infra.exame;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import br.com.soc.sistema.exception.BusinessException;

public enum OpcoesComboBuscarFuncionarioExames {
	ID("1", "ID"), 
	NOME_EXAME("2", "NOME DO EXAME"),
	NOME_FUNCIONARIO("3", "NOME DO FUNCIONARIO"),
	DATA("4", "DATA DO EXAME");
	
	private String codigo;
	private String descricao;
	private final static Map<String, OpcoesComboBuscarFuncionarioExames> opcoes = new HashMap<>();
	
	static {
		Arrays.asList(OpcoesComboBuscarFuncionarioExames.values())
		.forEach(
			opcao -> opcoes.put(opcao.getCodigo(), opcao)
		);
	}
	
	private OpcoesComboBuscarFuncionarioExames(String codigo, String descricao) {
		this.codigo = codigo;
		this.descricao = descricao;
	}
	
	public static OpcoesComboBuscarFuncionarioExames buscarPor(String codigo) throws IllegalArgumentException {
		if(codigo == null)
			throw new IllegalArgumentException("informe um codigo valido");
		
		OpcoesComboBuscarFuncionarioExames opcao = getOpcao(codigo)
				.orElseThrow(() -> new BusinessException("Codigo informado nao existe"));
		
		return opcao;
	}
	
	private static Optional<OpcoesComboBuscarFuncionarioExames> getOpcao(String codigo){
		return Optional.ofNullable(opcoes.get(codigo));
	}
	
	public String getCodigo() {
		return codigo;
	}
	
	public String getDescricao() {
		return descricao;
	}
}