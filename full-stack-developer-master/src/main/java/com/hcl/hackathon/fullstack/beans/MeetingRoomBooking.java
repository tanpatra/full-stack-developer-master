package com.hcl.hackathon.fullstack.beans;

import java.util.Date;

public class MeetingRoomBooking {
	long id;
	Date startTime;
	Date endTime;
	MeetingRoom meetingRoom;
	
	public MeetingRoomBooking(MeetingRoom meetingRoom,Date startTime,Date endTime) {
		this.meetingRoom = meetingRoom;
		this.startTime = startTime;
		this.endTime = endTime;
	}
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public Date getStartTime() {
		return startTime;
	}
	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}
	public Date getEndTime() {
		return endTime;
	}
	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}
	public MeetingRoom getMeetingRoom() {
		return meetingRoom;
	}
	public void setMeetingRoom(MeetingRoom meetingRoom) {
		this.meetingRoom = meetingRoom;
	}

}
