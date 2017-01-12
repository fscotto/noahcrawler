package it.noah.crawler.impl;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import it.noah.crawler.NoahCrawler;
import it.noah.crawler.converter.TownConverter;
import it.noah.crawler.exception.NoahCrawlerException;
import it.noah.crawler.model.Town;

public class NoahTownCrawler implements NoahCrawler {

	private static final Logger log = LoggerFactory
			.getLogger(NoahTownCrawler.class);

	private static final String DEFAULT_PATH = "D:\\Sviluppo\\workspace\\NoahCrawler\\sql\\towns.csv";

	private String path;

	public NoahTownCrawler() {
		path = DEFAULT_PATH;
	}

	public NoahTownCrawler(String path) {
		this.path = path;
	}

	@Override
	public void run() throws NoahCrawlerException {
		log.info("Start " + this.getClass().getSimpleName());
		List<Town> towns = loadTownsFromCSV(path);
		log.info("End " + this.getClass().getSimpleName());
	}

	private List<Town> loadTownsFromCSV(String path) {
		List<Town> towns = new ArrayList<Town>();
		BufferedReader bufferedReader = null;
		String line = "";
		String cvsSplitBy = ",";

		try {
			bufferedReader = new BufferedReader(new FileReader(path));
			while ((line = bufferedReader.readLine()) != null) {
				// use comma as separator
				String[] townArray = line.split(cvsSplitBy);
				Town town = convertRowToTown(townArray);
				towns.add(town);
			}
			System.out.println("Loaded town: " + towns.size());
		} catch (FileNotFoundException e) {
			log.error(e.getMessage());
		} catch (IOException e) {
			log.error(e.getMessage());
		} finally {
			if (bufferedReader != null) {
				try {
					bufferedReader.close();
				} catch (IOException e) {
					log.error(e.getMessage());
				}
			}
		}
		return towns;
	}

	private Town convertRowToTown(String[] row) {
		return new TownConverter().convertCSVRowToTown(row);
	}

	public String getPath() {
		return this.path;
	}

	public void setPath(String path) {
		this.path = path;
	}

}
