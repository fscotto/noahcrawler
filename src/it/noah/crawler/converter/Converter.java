package it.noah.crawler.converter;

import java.util.List;

import it.noah.crawler.dom.tag.Table;

public interface Converter<T> {

	public List<T> convertTable(Table table);

}
