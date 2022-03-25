package br.com.soc.sistema.soap.response.exame;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "exame")
@XmlAccessorType (XmlAccessType.FIELD)
public class Exame implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1017733815904457343L;

	@XmlElement(name="id")
	private String rowid;

	@XmlElement(name="descricao")
	private String nome;

	public String getRowid() {
		return rowid;
	}

	public void setRowid(String rowid) {
		this.rowid = rowid;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

}
