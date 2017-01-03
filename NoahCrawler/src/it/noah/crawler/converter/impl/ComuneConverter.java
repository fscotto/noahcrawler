package it.noah.crawler.converter.impl;

import it.noah.crawler.converter.Converter;
import it.noah.crawler.dom.tag.Table;
import it.noah.crawler.model.Comune;

import java.util.ArrayList;
import java.util.List;

public class ComuneConverter implements Converter<Comune> {

	@Override
	public List<Comune> convertTable(Table table) {
		List<Comune> comuni = new ArrayList<Comune>();
		return comuni;
	}

}
