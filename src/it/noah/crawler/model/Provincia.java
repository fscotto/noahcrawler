package it.noah.crawler.model;

import java.io.Serializable;
import java.util.List;

public class Provincia implements Serializable {

	private static final long serialVersionUID = 106451135158559443L;

	private Long id;
	private String nome;
	private String sigla;
	private String regione;
	private List<Comune> comuni;

	public void setId(Long id) {
		this.id = id;
	}

	public Long getId() {
		return id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getSigla() {
		return sigla;
	}

	public void setSigla(String sigla) {
		this.sigla = sigla;
	}

	public void setComuni(List<Comune> comuni) {
		this.comuni = comuni;
	}

	public List<Comune> getComuni() {
		return comuni;
	}

	public void setRegione(String regione) {
		this.regione = regione;
	}

	public String getRegione() {
		return regione;
	}

}
