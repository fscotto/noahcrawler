package it.noah.crawler.factory;

import it.noah.crawler.NoahCrawler;
import it.noah.crawler.enums.CrawlerEnum;
import it.noah.crawler.impl.ComuneNoahCrawler;
import it.noah.crawler.impl.ProvinciaNoahCrawler;

import java.io.IOException;

public class NoahCrawlerFactory {

	public static NoahCrawler getInstance(CrawlerEnum crawler) throws IOException {
		if (crawler == CrawlerEnum.PROVINCIA_CRAWLER) {
			return new ProvinciaNoahCrawler();
		} else if (crawler == CrawlerEnum.COMUNE_CRAWLER) {
			return new ComuneNoahCrawler();
		}
		return null;
	}

}
