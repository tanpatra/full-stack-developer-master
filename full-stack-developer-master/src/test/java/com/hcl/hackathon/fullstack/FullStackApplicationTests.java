package com.hcl.hackathon.fullstack;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;
import static org.assertj.core.api.Assertions.assertThat;

import com.hcl.hackathon.fullstack.beans.MeetingRoom;
import com.hcl.hackathon.fullstack.beans.MeetingRoomBooking;
import com.hcl.hackathon.fullstack.beans.MeetingRoomBookingDB;
import com.hcl.hackathon.fullstack.beans.MeetingRoomDB;
import com.hcl.hackathon.fullstack.beans.MeetingRoomSearch;

@RunWith(SpringRunner.class)
@TestPropertySource(value={"classpath:application.properties"})
@SpringBootTest
public class FullStackApplicationTests {

	/*@Test
	public void searchMeetingRoomTest() {
		MeetingRoomSearch meetingRoomsearch = new MeetingRoomSearch("2018-12-23","9:30","10:30",null,null,null,null,null,9);
		MeetingRoomBookingDB meetingRoomBookingDB = MeetingRoomBookingDB.getInstance();
		List<MeetingRoom> availableMeetingRooms = meetingRoomBookingDB.getAvailableMeetingRooms(meetingRoomsearch);
		assertThat(availableMeetingRooms.size()).isEqualTo(2);
	}*/
	
	/*@Test
	public void searchMeetingRoomTestTime() {
		MeetingRoomSearch meetingRoomsearch = new MeetingRoomSearch("2018-12-23","10:30","11:30",null,null,null,null,null,9);
		MeetingRoomBookingDB meetingRoomBookingDB = MeetingRoomBookingDB.getInstance();
		List<MeetingRoom> availableMeetingRooms = meetingRoomBookingDB.getAvailableMeetingRooms(meetingRoomsearch);
		assertThat(availableMeetingRooms.size()).isEqualTo(1);
	}*/
	
	@Test
	public void searchMeetingRoomTestHCL() {
		List<String> amenities = new ArrayList<String>();
		amenities.add("Apple TV");
		MeetingRoomSearch meetingRoomsearch = new MeetingRoomSearch("2018-12-23","4:30 PM","4:45 PM",amenities,null,null,null,null,4);
		MeetingRoomBookingDB meetingRoomBookingDB = MeetingRoomBookingDB.getInstance();
		List<MeetingRoom> availableMeetingRooms = meetingRoomBookingDB.getAvailableMeetingRooms(meetingRoomsearch);
		assertThat(availableMeetingRooms.size()).isEqualTo(2);
	}
	
	@Before
	public void setupMeetingRoom() throws ParseException {
		List<String> amenities1 = new ArrayList<String>();
		amenities1.add("Apple TV");
		amenities1.add("Mac");
		amenities1.add("Phone");
		amenities1.add("Television");
		amenities1.add("Whileboard/Marker");
		amenities1.add("Zoom Room");		
		MeetingRoom room1 = new MeetingRoom("Glass Case of Emotion", "", "First", "Sweet Candy Building", "Salt Lake City", 10, amenities1);
		
		List<String> amenities2 = new ArrayList<String>();
		amenities2.add("Apple TV");		
		amenities2.add("Television");
		amenities2.add("Whileboard/Marker");		
		MeetingRoom room2 = new MeetingRoom("Death Star", "Large room on second floor", "Second", "Sweet Candy Building", "Salt Lake City", 9, amenities2);
		
		List<String> amenities3 = new ArrayList<String>();	
		amenities3.add("Television");
		amenities3.add("Whileboard/Marker");		
		MeetingRoom room3 = new MeetingRoom("Super Star", "medium room on third floor", "Third", "Baby Building", "Salt Lake City", 5, amenities3);
		
		MeetingRoomDB meetingRoomDB = MeetingRoomDB.getInstance();
		meetingRoomDB.add(room1);
		meetingRoomDB.add(room2);
		
		SimpleDateFormat sdf =new SimpleDateFormat("yyyy-MM-dd HH:mm");
		MeetingRoomBooking booking = new MeetingRoomBooking(room1, sdf.parse("2018-12-23 11:00"),sdf.parse("2018-12-23 12:00"));
		MeetingRoomBookingDB meetingRoomBookingDB = MeetingRoomBookingDB.getInstance();
		meetingRoomBookingDB.add(booking);
	}

}
