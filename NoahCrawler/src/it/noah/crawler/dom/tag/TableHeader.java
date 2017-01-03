package it.noah.crawler.dom.tag;

import java.util.LinkedList;
import java.util.List;

public class TableHeader {
	private List<Cell> cells = new LinkedList<Cell>();

	public void addColumn(Cell cell) {
		cells.add(cell);
	}

	public List<Cell> getColumns() {
		return cells;
	}

	public Cell getColumn(int index) {
		return cells.get(index);
	}

	public int size() {
		return cells.size();
	}

}
