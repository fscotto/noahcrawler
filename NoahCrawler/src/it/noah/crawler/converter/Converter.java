package it.noah.crawler.converter;

import it.noah.crawler.dom.tag.Table;

import java.util.List;

public interface Converter<T> {

	public <T> List<T> convertTable(Table table);

}
