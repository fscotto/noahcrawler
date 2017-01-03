package it.noah.crawler.impl;

import it.noah.crawler.AbstractNoahCrawler;
import it.noah.crawler.NoahCrawler;
import it.noah.crawler.converter.impl.ComuneConverter;
import it.noah.crawler.dom.tag.Table;
import it.noah.crawler.enums.UrlEnum;
import it.noah.crawler.exception.NoahCrawlerException;
import it.noah.crawler.exception.ObjectNotFoundException;
import it.noah.crawler.model.Comune;

import java.io.IOException;
import java.util.List;

public class ComuneNoahCrawler extends AbstractNoahCrawler implements
		NoahCrawler {

	public ComuneNoahCrawler() throws IOException {
		super(UrlEnum.COMUNI_URL.getUrl());
	}

	@Override
	public void run() throws NoahCrawlerException {
		try {
			List<Comune> comuni = convertTable2Comuni(getTable("", true));
			// TODO una volta creata la lista va salvata sul db
		} catch (ObjectNotFoundException e) {
			e.printStackTrace();
		}
	}

	private List<Comune> convertTable2Comuni(Table table) {
		return new ComuneConverter().convertTable(table);
	}

}
