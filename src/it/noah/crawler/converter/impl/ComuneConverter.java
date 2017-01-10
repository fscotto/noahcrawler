package it.noah.crawler.converter.impl;

import java.util.List;

import org.geonames.PostalCode;

import it.noah.crawler.converter.Converter;
import it.noah.crawler.dom.tag.Table;
import it.noah.crawler.model.Comune;

public class ComuneConverter implements Converter<Comune> {

	@Override
	public List<Comune> convertTable(Table table) {
		return null;
	}

	public List<Comune> convertPostalCode(List<PostalCode> postalCodes) {
		// TODO da implementare
		return null;
	}

}
