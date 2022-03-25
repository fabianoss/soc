package br.com.soc.sistema.vo.exame;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;

import br.com.soc.sistema.vo.funcionario.FuncionarioVo;

public class FuncionarioExameVo {

	private String rowid;

	private FuncionarioVo funcionario;

	private ExameVo exame;

	private String dateExame;

	public FuncionarioExameVo() {
		super();
	}

	public String getRowid() {
		return rowid;
	}

	public void setRowid(String rowid) {
		this.rowid = rowid;
	}

	public FuncionarioVo getFuncionario() {
		return funcionario;
	}

	public void setFuncionario(FuncionarioVo funcionario) {
		this.funcionario = funcionario;
	}

	public ExameVo getExame() {
		return exame;
	}

	public void setExame(ExameVo exame) {
		this.exame = exame;
	}

	public String getDateExame() {
		return dateExame;
	}

	public void setDateExame(String dateExame) {
		this.dateExame = dateExame;
	}

	@Override
	public String toString() {
		return ReflectionToStringBuilder.toString(this);
	}

}
