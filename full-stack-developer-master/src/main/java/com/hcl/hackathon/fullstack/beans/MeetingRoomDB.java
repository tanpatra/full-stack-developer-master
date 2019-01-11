package com.hcl.hackathon.fullstack.beans;

import java.util.ArrayList;
import java.util.List;

public class MeetingRoomDB {
	
	private List<MeetingRoom> meetingRoomList;
    private static MeetingRoomDB meetingRoomDB = null;
    private long meetingRoomIdCounter = 0;
    private MeetingRoomDB(){
    	meetingRoomList = new ArrayList<MeetingRoom>();
    }
    public static MeetingRoomDB getInstance() {
    	if (meetingRoomDB != null) return meetingRoomDB;
    	meetingRoomDB = new MeetingRoomDB();
    	System.out.println("meetingRoomDB is null");
    	return meetingRoomDB;
    }
    public void add(MeetingRoom room) {    	
    	meetingRoomIdCounter++;
    	room.setId(meetingRoomIdCounter);
    	meetingRoomList.add(room);
    	System.out.println("room added and size of the list is :: "+meetingRoomList.size());
    }
    
    public MeetingRoom getMeetingRoom(Long id) {
    	for(MeetingRoom meetingRoom : meetingRoomList){
    		if (id == meetingRoom.getId()) return meetingRoom;
    	}
    	return null;
    }
	public long getMeetingRoomIdCounter() {
		return meetingRoomIdCounter;
	}
	public List<MeetingRoom> getMeetingRoomList() {
		return meetingRoomList;
	}
}
