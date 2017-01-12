package it.noah.crawler.converter;

import java.util.ArrayList;
import java.util.List;

import it.noah.crawler.dom.tag.Cell;
import it.noah.crawler.dom.tag.Table;
import it.noah.crawler.dom.tag.TableRow;
import it.noah.crawler.model.District;

public class DistrictConverter {

	public List<District> convertTable(Table table) {
		List<District> province = new ArrayList<District>();
		for (TableRow row : table.getRows()) {
			District district = getDistrict(row);
			province.add(district);
		}
		return province;
	}

	private District getDistrict(TableRow row) {
		District district = new District();
		for (int i = 0; i < row.getRow().size(); i++) {
			Cell cell = row.getRow().get(i);
			switch (i) {
			case 0:
				district.setInitial(cell.getValue());
				break;
			case 1:
				district.setName(cell.getValue());
				break;
			case 2:
				district.setRegion(cell.getValue());
				break;
			}
		}
		return district;
	}

}
