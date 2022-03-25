package br.com.soc.sistema.soap.response.exame;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "exameRealizado")
@XmlAccessorType (XmlAccessType.FIELD)
public class ExameRealizado implements Serializable{
		
	/**
	 * 
	 */
	private static final long serialVersionUID = 2915741593313461262L;

	@XmlElement(name="id")
	private String rowid;
	
	@XmlElement(name="idExame")
	private String rowidExame;
	
	@XmlElement(name="idFuncionario")
	private String rowidFuncionario;
	
	@XmlElement(name="dataExame")
	private String dataExame;

	public String getRowid() {
		return rowid;
	}

	public void setRowid(String rowid) {
		this.rowid = rowid;
	}

	public String getRowidExame() {
		return rowidExame;
	}

	public void setRowidExame(String rowidExame) {
		this.rowidExame = rowidExame;
	}

	public String getRowidFuncionario() {
		return rowidFuncionario;
	}

	public void setRowidFuncionario(String rowidFuncionario) {
		this.rowidFuncionario = rowidFuncionario;
	}

	public String getDataExame() {
		return dataExame;
	}

	public void setDataExame(String dataExame) {
		this.dataExame = dataExame;
	}
	
	
	

}
