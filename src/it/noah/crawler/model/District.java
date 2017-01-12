package it.noah.crawler.model;

import java.io.Serializable;
import java.util.List;

public class District implements Serializable {

	private static final long serialVersionUID = 106451135158559443L;

	private Long id;
	private String name;
	private String initial;
	private String region;
	private List<Town> towns;

	public void setId(Long id) {
		this.id = id;
	}

	public Long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getInitial() {
		return initial;
	}

	public void setInitial(String initial) {
		this.initial = initial;
	}

	public void setTowns(List<Town> towns) {
		this.towns = towns;
	}

	public List<Town> getTowns() {
		return towns;
	}

	public void setRegion(String region) {
		this.region = region;
	}

	public String getRegion() {
		return region;
	}

}
