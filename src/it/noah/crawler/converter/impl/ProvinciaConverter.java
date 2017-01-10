package it.noah.crawler.converter.impl;

import java.util.ArrayList;
import java.util.List;

import it.noah.crawler.converter.Converter;
import it.noah.crawler.dom.tag.Cell;
import it.noah.crawler.dom.tag.Table;
import it.noah.crawler.dom.tag.TableRow;
import it.noah.crawler.model.Provincia;

public class ProvinciaConverter implements Converter<Provincia> {

	@Override
	public List<Provincia> convertTable(Table table) {
		List<Provincia> province = new ArrayList<Provincia>();
		for (TableRow row : table.getRows()) {
			Provincia provincia = getProvincia(row);
			province.add(provincia);
		}
		return province;
	}

	private Provincia getProvincia(TableRow row) {
		Provincia provincia = new Provincia();
		for (int i = 0; i < row.getRow().size(); i++) {
			Cell cell = row.getRow().get(i);
			switch (i) {
			case 0:
				provincia.setSigla(cell.getValue());
				break;
			case 1:
				provincia.setNome(cell.getValue());
				break;
			case 2:
				provincia.setRegione(cell.getValue());
				break;
			}
		}
		return provincia;
	}

}
