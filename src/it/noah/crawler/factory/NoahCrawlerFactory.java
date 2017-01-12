package it.noah.crawler.factory;

import it.noah.crawler.NoahCrawler;
import it.noah.crawler.enums.CrawlerEnum;
import it.noah.crawler.impl.NoahTownCrawler;
import it.noah.crawler.impl.NoahDistrictCrawler;

import java.io.IOException;

public class NoahCrawlerFactory {

	public static NoahCrawler getInstance(CrawlerEnum crawler) throws IOException {
		if (crawler == CrawlerEnum.DISTRICT_CRAWLER) {
			return new NoahDistrictCrawler();
		} else if (crawler == CrawlerEnum.TOWN_CRAWLER) {
			return new NoahTownCrawler();
		}
		return null;
	}

}
