package it.noah.crawler.dom.tag;

import java.util.List;

public class Table {
	private TableHeader header;
	private List<TableRow> rows;

	public Table() {
		header = new TableHeader();
	}

	public void setHeader(TableHeader header) {
		this.header = header;
	}

	public TableHeader getHeader() {
		return header;
	}

	public void setRows(List<TableRow> rows) {
		this.rows = rows;
	}

	public List<TableRow> getRows() {
		return rows;
	}

	public int columns() {
		return header.size();
	}

}
