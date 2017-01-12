package it.noah.crawler.converter;

import it.noah.crawler.model.District;
import it.noah.crawler.model.Town;
import it.noah.crawler.services.NoahPostalCodeSeeker;

public class TownConverter {

	public Town convertCSVRowToTown(String[] row) {
		Town town = new Town();
		town.setName(row[0]);
		town.setRegion(row[1]);
		String districtStr = !"-".equals(row[2]) ? row[2] : row[3];
		District district = new District();
		district.setName(districtStr);
		town.setDistrict(district);
		String postalCode = NoahPostalCodeSeeker
				.getPostalCodeFromName("morgoth", town.getName(), "IT");
		town.setPostalCode(postalCode);
		return town;
	}

}
