package it.noah.crawler.impl;

import it.noah.crawler.AbstractNoahCrawler;
import it.noah.crawler.NoahCrawler;
import it.noah.crawler.converter.impl.ProvinciaConverter;
import it.noah.crawler.dom.tag.Table;
import it.noah.crawler.enums.UrlEnum;
import it.noah.crawler.exception.NoahCrawlerException;
import it.noah.crawler.exception.ObjectNotFoundException;
import it.noah.crawler.model.Provincia;

import java.io.IOException;
import java.util.List;

public class ProvinciaNoahCrawler extends AbstractNoahCrawler implements
		NoahCrawler {

	public ProvinciaNoahCrawler() throws IOException {
		super(UrlEnum.PROVINCE_URL.getUrl());
	}

	@Override
	public void run() throws NoahCrawlerException {
		try {
			List<Provincia> province = convertTable2Provincia(getTable("", true));
			// TODO una volta creata la lista va salvata sul db
		} catch (ObjectNotFoundException e) {
			e.printStackTrace();
		}
	}

	private List<Provincia> convertTable2Provincia(Table table) {
		return new ProvinciaConverter().convertTable(table);
	}

}
