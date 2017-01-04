package it.noah.crawler.dom.tag.builder;

import java.util.List;

import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import it.noah.crawler.dom.tag.Table;
import it.noah.crawler.dom.tag.TableHeader;
import it.noah.crawler.dom.tag.TableRow;

public class TableBuilder {

	public Table build(Element element, boolean headerFlag) {
		Table table = new Table();
		Elements rows = element.select("tr");
		Element header;
		if (headerFlag) {
			header = rows.first();
			rows.remove(header);
			TableHeaderBuilder tableHeaderBuilder = new TableHeaderBuilder();
			TableHeader tableHeader = tableHeaderBuilder.build(header);
			table.setHeader(tableHeader);
		}
		TableRowBuilder tableRowBuilder = new TableRowBuilder();
		List<TableRow> tableRows = tableRowBuilder.build(rows);
		table.setRows(tableRows);
		return table;
	}

}
