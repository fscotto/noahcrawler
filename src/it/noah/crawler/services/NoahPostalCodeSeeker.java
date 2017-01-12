package it.noah.crawler.services;

import java.util.List;

import org.geonames.PostalCode;
import org.geonames.PostalCodeSearchCriteria;
import org.geonames.WebService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class NoahPostalCodeSeeker {

	private static final Logger log = LoggerFactory
			.getLogger(NoahPostalCodeSeeker.class);

	public static String getPostalCodeFromName(String username, String town,
			String countryCode) {
		String postalCode = null;

		try {
			WebService.setUserName(username);
			PostalCodeSearchCriteria criteria = new PostalCodeSearchCriteria();
			criteria.setPlaceName(town);
			criteria.setCountryCode(countryCode);
			List<PostalCode> result = WebService.postalCodeSearch(criteria);
			System.out.println("Finder results: " + result.size());
			if (result.size() == 1) {
				postalCode = result.get(0).getPostalCode();
			} else if (result.size() > 1) {
				for (PostalCode postalCodeObj : result) {

				}
			}
		} catch (Exception e) {
			log.error(e.getMessage());
		}

		return postalCode;
	}

}
