package it.noah.crawler;

import it.noah.crawler.dom.NoahDOMExplorer;
import it.noah.crawler.dom.tag.Table;
import it.noah.crawler.exception.NoahCrawlerException;
import it.noah.crawler.exception.ObjectNotFoundException;

import java.io.IOException;

public abstract class AbstractNoahCrawler implements NoahCrawler {

	private NoahDOMExplorer explorer;

	public AbstractNoahCrawler(String url) {
		try {
			this.explorer = new NoahDOMExplorer(url);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public abstract void run() throws NoahCrawlerException;

	public Table getTable(String tableName, boolean header)
			throws ObjectNotFoundException {
		return explorer.getTable(tableName, header);
	}

}
