package it.noah.crawler;

import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import it.noah.crawler.dom.NoahDOMExplorer;
import it.noah.crawler.dom.tag.Table;
import it.noah.crawler.exception.NoahCrawlerException;
import it.noah.crawler.exception.ObjectNotFoundException;

public abstract class AbstractNoahCrawler implements NoahCrawler {

	private final static Logger log = LoggerFactory
			.getLogger(AbstractNoahCrawler.class);

	private NoahDOMExplorer explorer;

	public AbstractNoahCrawler(String url) {
		try {
			this.explorer = new NoahDOMExplorer(url);
		} catch (IOException e) {
			log.error(e.getMessage());
		}
	}

	@Override
	public abstract void run() throws NoahCrawlerException;

	public Table getTable(String tableName, boolean header)
			throws ObjectNotFoundException {
		return explorer.getTable(tableName, header);
	}

}
