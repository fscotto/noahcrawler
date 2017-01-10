package it.noah.crawler.impl;

import org.geonames.Toponym;
import org.geonames.ToponymSearchCriteria;
import org.geonames.ToponymSearchResult;
import org.geonames.WebService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import it.noah.crawler.NoahCrawler;
import it.noah.crawler.exception.NoahCrawlerException;

public class ComuneNoahCrawler implements NoahCrawler {

	private static final Logger log = LoggerFactory
			.getLogger(ComuneNoahCrawler.class);

	// http://api.geonames.org/postalCodeSearch?placename=IT&username=morgoth

	@Override
	public void run() throws NoahCrawlerException {
		try {
			WebService.setUserName("morgoth");
			ToponymSearchCriteria criteria = new ToponymSearchCriteria();
			criteria.setLanguage("IT");
			criteria.setCountryCode("IT");
			criteria.setMaxRows(1000);
			ToponymSearchResult result = WebService.search(criteria);
			System.out.println(result.getTotalResultsCount());
			for (Toponym toponym : result.getToponyms()) {
				// TODO FINIRE IMPLEMENTAZIONE
			}
			// TODO salvare sul database
		} catch (Exception e) {
			log.error(e.getMessage());
		}

	}

}
