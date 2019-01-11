package com.hcl.hackathon.fullstack.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.hcl.hackathon.fullstack.beans.MeetingRoom;
import com.hcl.hackathon.fullstack.beans.MeetingRoomBookingDB;
import com.hcl.hackathon.fullstack.beans.MeetingRoomDB;
import com.hcl.hackathon.fullstack.beans.MeetingRoomSearch;

@RestController
public class MeetingRoomController {
	
	  @PostMapping(value="/room/add")
	  @ResponseBody
	public MeetingRoom registerStudent(@RequestBody MeetingRoom room) {
		MeetingRoomDB meetingRoomDB = MeetingRoomDB.getInstance();
		meetingRoomDB.add(room);
		return meetingRoomDB.getMeetingRoom(meetingRoomDB.getMeetingRoomIdCounter());
	}
	  
	  @PostMapping(value="/room/search")
	  @ResponseBody
	public List<MeetingRoom> bookMeetingRoom(@RequestBody MeetingRoomSearch roomSearch) {
		  MeetingRoomBookingDB meetingRoomBookingDB = MeetingRoomBookingDB.getInstance();

		
		return meetingRoomBookingDB.getAvailableMeetingRooms(roomSearch);
	}

}
