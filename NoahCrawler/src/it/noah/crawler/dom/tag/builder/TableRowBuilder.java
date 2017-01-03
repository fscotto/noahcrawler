package it.noah.crawler.dom.tag.builder;

import it.noah.crawler.dom.tag.Cell;
import it.noah.crawler.dom.tag.TableRow;

import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class TableRowBuilder {

	public TableRow build(Elements rows) {
		TableRow tableRow = new TableRow();
		for (Element row : rows) {
			Elements tds = row.select("td");
			Cell cell = new Cell();
			cell.setValue(tds.text());
			// tableRow.addColumn(cell); TODO
		}
		return tableRow;
	}

}
