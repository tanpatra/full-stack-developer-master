package com.hcl.hackathon.fullstack.beans;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class MeetingRoomBookingDB {

	private List<MeetingRoomBooking> meetingRoomBookingList;
    private static MeetingRoomBookingDB meetingRoomBookingDB = null;
    private MeetingRoomBookingDB(){
    	meetingRoomBookingList = new ArrayList<MeetingRoomBooking>();
    }
    public static MeetingRoomBookingDB getInstance() {
    	if(meetingRoomBookingDB != null) return meetingRoomBookingDB;
    	meetingRoomBookingDB = new MeetingRoomBookingDB();;
    	return meetingRoomBookingDB;
    }
    public void add(MeetingRoomBooking booking) {
    	meetingRoomBookingList.add(booking);
    }
    
    public List<MeetingRoomBooking> getMeetingRoomBookingList() {
    	return meetingRoomBookingList;
    }
    
   public List<MeetingRoom> getAvailableMeetingRooms(MeetingRoomSearch roomSearch){
	   List<MeetingRoom> roomsAvailable  = new ArrayList<MeetingRoom>();
	   List<MeetingRoom> totalRoomsList = MeetingRoomDB.getInstance().getMeetingRoomList();
	   List<MeetingRoom> roomsAvailableAfterCapacityFilter = null;
	   List<MeetingRoom> roomsAvailableAfterLocationFilter = null;
	   List<MeetingRoom> roomsAvailableAfterAmenitiesFilter = null;
	   
	   if(roomSearch.getCityName() != null && roomSearch.getBuildingName() != null && roomSearch.getFloorName() != null) {
		   for(MeetingRoom room : totalRoomsList) {
			   if (roomSearch.getCityName().equals(room.getCityName()) && roomSearch.getBuildingName().equals(room.getBuildingName()) && roomSearch.getFloorName().equals(room.getFloorName())) {
				   if(roomsAvailableAfterLocationFilter == null) roomsAvailableAfterLocationFilter = new ArrayList<MeetingRoom>();
				   roomsAvailableAfterLocationFilter.add(room);
			   }
		   }
	   } else if (roomSearch.getCityName() != null && roomSearch.getBuildingName() != null) {
		   for(MeetingRoom room : totalRoomsList) {
			   if (roomSearch.getCityName().equals(room.getCityName()) && roomSearch.getBuildingName().equals(room.getBuildingName())) {
				   if(roomsAvailableAfterLocationFilter == null) roomsAvailableAfterLocationFilter = new ArrayList<MeetingRoom>();
				   roomsAvailableAfterLocationFilter.add(room);
			   }
		   }
	   } else if (roomSearch.getCityName() != null) {
		   for(MeetingRoom room : totalRoomsList) {
			   if (roomSearch.getCityName().equals(room.getCityName())) {
				   if(roomsAvailableAfterLocationFilter == null) roomsAvailableAfterLocationFilter = new ArrayList<MeetingRoom>();
				   roomsAvailableAfterLocationFilter.add(room);
			   }
		   }
	   }
	   if (roomsAvailableAfterLocationFilter == null) roomsAvailableAfterLocationFilter = totalRoomsList;
	   
	   if(roomSearch.getCapacity() > 0) {
		   for (MeetingRoom room : roomsAvailableAfterLocationFilter) {
			   if (room.getCapacity() >= roomSearch.getCapacity()) {
				   if(roomsAvailableAfterCapacityFilter == null) roomsAvailableAfterCapacityFilter = new ArrayList<MeetingRoom>();
				   roomsAvailableAfterCapacityFilter.add(room);
			   }
		   }
	   }
	   
	   if(roomsAvailableAfterCapacityFilter == null) roomsAvailableAfterCapacityFilter = roomsAvailableAfterLocationFilter;
	   
	   if(roomSearch.getAmenities() != null) {
		   for(MeetingRoom room : roomsAvailableAfterCapacityFilter) {
			   boolean amenityFound = true;
			   for (String amenity : roomSearch.getAmenities()) {
				   if (!room.getAmenities().contains(amenity)) amenityFound = false;
			   }
			   if (amenityFound) {
				   if (roomsAvailableAfterAmenitiesFilter == null) roomsAvailableAfterAmenitiesFilter = new ArrayList<MeetingRoom>();
				   roomsAvailableAfterAmenitiesFilter.add(room);
			   }
		   } 
	   }
	   if(roomsAvailableAfterAmenitiesFilter == null) roomsAvailableAfterAmenitiesFilter = roomsAvailableAfterCapacityFilter;
	   SimpleDateFormat sdf =new SimpleDateFormat("yyyy-MM-dd HH:mm");
	   String startTimeString = roomSearch.getDate()+ " "+roomSearch.getStartTime();
	   String endTimeString = roomSearch.getDate()+ " "+roomSearch.getEndTime();
	   //for (meetingRoomBookingList)
	   for (MeetingRoom room : roomsAvailableAfterAmenitiesFilter) {
		  try {
			if (isRoomAvailable(room, sdf.parse(startTimeString), sdf.parse(endTimeString))) roomsAvailable.add(room);
		} catch (ParseException e) {
			System.out.println("exception while parsing date :: "+e.getMessage());
			e.printStackTrace();
		}
	   }

	   return roomsAvailable;
   }
private boolean isRoomAvailable(MeetingRoom room, Date startTime, Date endTime) {
	if (meetingRoomBookingList == null || meetingRoomBookingList.size() == 0) return true;
	for(MeetingRoomBooking booking: meetingRoomBookingList) {
		System.out.println("booking ID :: "+booking.getMeetingRoom().getId());
		System.out.println("room id :: "+room.getId());
		if(booking.getMeetingRoom().getId() == room.getId()) {
			if(startTime.before(booking.getEndTime()) && startTime.after(booking.getStartTime())) return false;
			if(endTime.before(booking.getEndTime()) && endTime.after(booking.getStartTime())) return false;
		}
	}
	return true;
}

	
}
