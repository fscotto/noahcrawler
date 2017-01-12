package it.noah.crawler.dom;

import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import it.noah.crawler.dom.tag.Table;
import it.noah.crawler.dom.tag.builder.TableBuilder;
import it.noah.crawler.exception.ObjectNotFoundException;

public class NoahDOMExplorer {

	private Document document;

	public NoahDOMExplorer(String url) throws IOException {
		document = Jsoup.connect(url).get();
	}

	public synchronized Document getDocument() {
		return document;
	}

	public synchronized Table getTable(String tableName, boolean header)
			throws ObjectNotFoundException {
		if (document == null) {
			throw new ObjectNotFoundException("Document not found!!!");
		}
		Elements elements = document.getElementsByTag("table");
		Element element = selectByName(elements, tableName);
		TableBuilder tableBuilder = new TableBuilder();
		return tableBuilder.build(element, header);
	}

	private synchronized Element selectByName(Elements elements, String name) {
		Element selected = null;
		if (name == null || elements == null) {
			throw new IllegalArgumentException("Parameter not valid!!!");
		}
		for (Element current : elements) {
			if (name.equals(current.className())) {
				selected = current;
			}
		}
		return selected;
	}

}
