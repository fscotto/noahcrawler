package it.noah.crawler.enums;

public enum UrlEnum {
	PROVINCE_URL(
			"http://www.aci.it/i-servizi/normative/codice-della-strada/elenco-sigle-province-ditalia.html");

	private String url;

	UrlEnum(String url) {
		this.url = url;
	}

	public String getUrl() {
		return this.url;
	}
}
