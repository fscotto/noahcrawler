package it.noah.crawler.enums;

public enum UrlEnum {
	PROVINCE_URL(
			"http://www.aci.it/i-servizi/normative/codice-della-strada/elenco-sigle-province-ditalia.html"),
	COMUNI_URL("https://it.wikipedia.org/wiki/Citt%C3%A0_d'Italia");

	private String url;

	UrlEnum(String url) {
		this.url = url;
	}

	public String getUrl() {
		return this.url;
	}
}
