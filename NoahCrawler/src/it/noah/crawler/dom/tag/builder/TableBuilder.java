package it.noah.crawler.dom.tag.builder;

import it.noah.crawler.dom.tag.Table;

import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class TableBuilder {

	public Table build(Element element, boolean headerFlag) {
		Table table = new Table();
		Elements elements = element.select("tr");
		Element header;
		if (headerFlag) {
			header = elements.select("tr").first();
			header.remove();
			TableHeaderBuilder thb = new TableHeaderBuilder();
			table.setHeader(thb.build(header));
		}
		Elements rows = elements.select("tr");
		TableRowBuilder thr = new TableRowBuilder();
		// table.setBody(thr.build(rows)); TODO
		return table;
	}

}
