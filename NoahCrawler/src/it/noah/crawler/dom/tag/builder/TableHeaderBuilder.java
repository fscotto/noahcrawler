package it.noah.crawler.dom.tag.builder;

import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import it.noah.crawler.dom.tag.Cell;
import it.noah.crawler.dom.tag.TableHeader;

public class TableHeaderBuilder {

	public TableHeader build(Element element) {
		TableHeader tableHeader = new TableHeader();
		Elements tableDatas = element.getElementsByTag("th");
		for (Element tableData : tableDatas) {
			Cell data = new Cell();
			data.setValue(tableData.text());
			tableHeader.addColumn(data);
		}
		return tableHeader;
	}
}
