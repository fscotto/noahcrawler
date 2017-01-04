package it.noah.crawler.impl;

import java.io.IOException;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import it.noah.crawler.AbstractNoahCrawler;
import it.noah.crawler.NoahCrawler;
import it.noah.crawler.converter.impl.ProvinciaConverter;
import it.noah.crawler.dom.tag.Table;
import it.noah.crawler.enums.UrlEnum;
import it.noah.crawler.exception.NoahCrawlerException;
import it.noah.crawler.exception.ObjectNotFoundException;
import it.noah.crawler.model.Provincia;

public class ProvinciaNoahCrawler extends AbstractNoahCrawler
		implements NoahCrawler {

	private final static Logger log = LoggerFactory
			.getLogger(ProvinciaNoahCrawler.class);

	public ProvinciaNoahCrawler() throws IOException {
		super(UrlEnum.PROVINCE_URL.getUrl());
	}

	@Override
	public void run() throws NoahCrawlerException {
		try {
			List<Provincia> province = convertTable2Provincia(
					getTable("", true));
			log.debug("Provincia convertita con successo!!!");
			// TODO una volta creata la lista va salvata sul db
		} catch (ObjectNotFoundException e) {
			log.error(e.getMessage());
		}
	}

	private List<Provincia> convertTable2Provincia(Table table) {
		return new ProvinciaConverter().convertTable(table);
	}

}
