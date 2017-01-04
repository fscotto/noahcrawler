package it.noah.crawler.dom.tag.builder;

import java.util.ArrayList;
import java.util.List;

import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import it.noah.crawler.dom.tag.Cell;
import it.noah.crawler.dom.tag.TableRow;

public class TableRowBuilder {

	public List<TableRow> build(Elements htmlRows) {
		List<TableRow> rows = new ArrayList<TableRow>();
		for (Element htmlRow : htmlRows) {
			TableRow tableRow = new TableRow();
			List<Cell> row = new ArrayList<Cell>();
			Elements tds = htmlRow.select("td");
			for (Element tableData : tds) {
				Cell cell = new Cell();
				cell.setValue(tableData.text());
				row.add(cell);
			}
			tableRow.addRow(row);
			rows.add(tableRow);
		}
		return rows;
	}

}
