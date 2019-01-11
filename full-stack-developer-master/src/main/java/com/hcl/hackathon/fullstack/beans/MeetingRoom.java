package com.hcl.hackathon.fullstack.beans;

import java.util.List;

public class MeetingRoom {
	Long id;
	String name;
	String description;
	String floorName;
	String buildingName;
	String cityName;
	int capacity;
	List<String> amenities;
	
	public MeetingRoom(String name, String description, String floorName, String buildingName, String cityName, int capacity, List<String> amenities) {
		this.name = name;
		this.description = description;
		this.floorName = floorName;
		this.buildingName = buildingName;
		this.cityName = cityName;
		this.capacity = capacity;
		this.amenities = amenities;
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getFloorName() {
		return floorName;
	}
	public void setFloorName(String floorName) {
		this.floorName = floorName;
	}
	public String getBuildingName() {
		return buildingName;
	}
	public void setBuildingName(String buildingName) {
		this.buildingName = buildingName;
	}
	public String getCityName() {
		return cityName;
	}
	public void setCityName(String cityName) {
		this.cityName = cityName;
	}
	public int getCapacity() {
		return capacity;
	}
	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}
	public List<String> getAmenities() {
		return amenities;
	}
	public void setAmenities(List<String> amenities) {
		this.amenities = amenities;
	}

}
