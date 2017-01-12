package it.noah.crawler.impl;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import it.noah.crawler.AbstractNoahCrawler;
import it.noah.crawler.NoahCrawler;
import it.noah.crawler.converter.DistrictConverter;
import it.noah.crawler.dom.tag.Table;
import it.noah.crawler.exception.NoahCrawlerException;
import it.noah.crawler.exception.ObjectNotFoundException;
import it.noah.crawler.model.District;
import it.noah.crawler.persistence.DistrictAccess;

public class NoahDistrictCrawler extends AbstractNoahCrawler
		implements NoahCrawler {

	private final static Logger log = LoggerFactory
			.getLogger(NoahDistrictCrawler.class);

	private final static String URL = "http://www.aci.it/i-servizi/normative/codice-della-strada/elenco-sigle-province-ditalia.html";

	public NoahDistrictCrawler() throws IOException {
		super(URL);
	}

	@Override
	public void run() throws NoahCrawlerException {
		try {
			log.info("Start " + this.getClass().getSimpleName());
			List<District> districts = convertTableToDistricts(
					getTable("", true));
			log.debug("Convertion succesfull!!!");
			DistrictAccess access = new DistrictAccess();
			access.insertDistricts(districts);
			log.info("End " + this.getClass().getSimpleName());
		} catch (ObjectNotFoundException e) {
			log.error(e.getMessage());
		} catch (SQLException e) {
			log.error(e.getMessage());
		}
	}

	private List<District> convertTableToDistricts(Table table) {
		return new DistrictConverter().convertTable(table);
	}

}
