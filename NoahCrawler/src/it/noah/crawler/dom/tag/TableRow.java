package it.noah.crawler.dom.tag;

import java.util.LinkedList;
import java.util.List;

public class TableRow {
	private List<Cell> cells = new LinkedList<Cell>();

	public List<Cell> getRow() {
		return cells;
	}

	public void addRow(List<Cell> row) {
		cells = row;
	}

	public int size() {
		return cells.size();
	}

}
