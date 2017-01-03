package it.noah.crawler.converter.impl;

import java.util.ArrayList;
import java.util.List;

import it.noah.crawler.annotation.Column;
import it.noah.crawler.converter.Converter;
import it.noah.crawler.dom.tag.Table;
import it.noah.crawler.model.Provincia;

public class ProvinciaConverter implements Converter<Provincia> {

	@Override
	public List<Provincia> convertTable(Table table) {
		List<Provincia> province = new ArrayList<Provincia>();
		int j = 0;
		for (int i = 0; i < table.columns(); i++) {
			Provincia provincia = new Provincia();
			Column annotations = provincia.getClass()
					.getAnnotation(Column.class);
			province.add(provincia);
		}
		return province;
	}

}
