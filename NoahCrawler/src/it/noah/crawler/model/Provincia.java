package it.noah.crawler.model;

import it.noah.crawler.annotation.Column;
import it.noah.crawler.annotation.NoahCrawlerModel;
import it.noah.crawler.annotation.Transiet;

import java.util.List;

@NoahCrawlerModel
public class Provincia {

	@Transiet
	private Long id;

	@Column(name = "Provincia")
	private String nome;

	@Column(name = "Sigla")
	private String sigla;

	@Column(name = "Regione")
	private String regione;

	@Transiet
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
