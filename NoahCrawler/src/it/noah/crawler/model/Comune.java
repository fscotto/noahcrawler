package it.noah.crawler.model;

import it.noah.crawler.annotation.Column;
import it.noah.crawler.annotation.NoahCrawlerModel;
import it.noah.crawler.annotation.Transiet;

@NoahCrawlerModel
public class Comune {

	@Transiet
	private Long id;

	@Column(name = "")
	private String nome;

	@Column(name = "")
	private String cap;

	@Column(name = "")
	private Provincia provincia;

	@Column(name = "")
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
