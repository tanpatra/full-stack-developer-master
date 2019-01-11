package com.hcl.hackathon.fullstack.beans;

import java.util.List;

public class MeetingRoomSearch {
	String date;
	String startTime;
	String endTime;
	List<String> amenities;
	String name;
	String floorName;
	String buildingName;
	String cityName;
	int capacity;
	
	public MeetingRoomSearch(String date,	String startTime,	String endTime,	List<String> amenities,	String name,	String floorName,	String buildingName,	String cityName,	int capacity) {
		this.date = date;
		this.startTime = startTime;
		this.endTime = endTime;
		this.amenities = amenities;
		this.name = name;
		this.floorName = floorName;
		this.buildingName = buildingName;
		this.cityName = cityName;
		this.capacity = capacity;
	}
	
	public String getStartTime() {
		return startTime;
	}
	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}
	public String getEndTime() {
		return endTime;
	}
	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}
	public List<String> getAmenities() {
		return amenities;
	}
	public void setAmenities(List<String> amenities) {
		this.amenities = amenities;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
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
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}

}
