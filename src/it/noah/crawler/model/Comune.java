package it.noah.crawler.model;

import java.io.Serializable;

public class Comune implements Serializable {

	private static final long serialVersionUID = -2171167117875954706L;

	private Long id;
	private String nome;
	private String cap;
	private Provincia provincia;
	private String regione;

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

	public String getCap() {
		return cap;
	}

	public void setCap(String cap) {
		this.cap = cap;
	}

	public Provincia getProvincia() {
		return provincia;
	}

	public void setProvincia(Provincia provincia) {
		this.provincia = provincia;
	}

	public void setRegione(String regione) {
		this.regione = regione;
	}

	public String getRegione() {
		return regione;
	}

}
