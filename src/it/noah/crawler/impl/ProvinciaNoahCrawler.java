package it.noah.crawler.impl;

import java.io.IOException;
import java.sql.SQLException;
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
import it.noah.crawler.persistence.AccessProvincia;

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
			AccessProvincia access = new AccessProvincia();
			access.insertProvince(province);
		} catch (ObjectNotFoundException e) {
			log.error(e.getMessage());
		} catch (SQLException e) {
			log.error(e.getMessage());
		}
	}

	private List<Provincia> convertTable2Provincia(Table table) {
		return new ProvinciaConverter().convertTable(table);
	}

}
