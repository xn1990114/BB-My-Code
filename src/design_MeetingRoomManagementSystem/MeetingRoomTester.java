package design_MeetingRoomManagementSystem;

import static org.junit.Assert.*;

import org.junit.Test;

public class MeetingRoomTester {

	@Test
	public void test() {
		RoomManager rm=new RoomManager();
		rm.rooms.put(101, new MeetingRoom(101));
		rm.rooms.put(102, new MeetingRoom(102));
		rm.rooms.put(103, new MeetingRoom(103));
		Event e11=new Event(1,0,5,"Room1 0-5");
		Event e12=new Event(1,4,6,"Room1 4-6");
		Event e13=new Event(1,16,18,"Room1 16-18");
		Event e14=new Event(1,20,23,"Room1 20-23");
		assertTrue(rm.addEvent(101, e11));
		assertTrue(!rm.addEvent(101, e12));
		assertTrue(rm.addEvent(101, e13));
		assertTrue(rm.addEvent(101, e14));
		Event e20=new Event(1,0,2,"Room2 0-2");
		Event e21=new Event(1,2,4,"Room2 2-4");
		Event e22=new Event(1,4,6,"Room2 4-6");
		Event e23=new Event(1,6,8,"Room2 6-8");
		Event e24=new Event(1,15,23,"Room2 15-23");
		Event e25=new Event(1,23,24,"Room2 23-24");
		assertTrue(rm.addEvent(102, e21));
		assertTrue(rm.addEvent(102, e22));
		assertTrue(rm.addEvent(102, e23));
		assertTrue(rm.addEvent(102, e24));
		assertTrue(rm.addEvent(102, e25));
		assertTrue(rm.nextAvailableTime(102, 0)==0);
		assertTrue(rm.nextAvailableTime(102, 1)==0);
		assertTrue(rm.addEvent(102, e20));
		assertTrue(rm.nextAvailableTime(102, 1)==8);
		Event e30=new Event(1,0,2,"Room3 0-2");
		Event e31=new Event(1,2,14,"Room3 2-14");
		Event e32=new Event(1,14,16,"Room3 14-16");
		Event e33=new Event(1,16,24,"Room3 16-24");
		assertTrue(rm.addEvent(103, e30));
		assertTrue(rm.addEvent(103, e32));
		assertTrue(rm.findAllAvailableRoom(0, 0, 24).size()==3);
		assertTrue(rm.findAllAvailableRoom(1, 8, 14).size()==3);
		assertTrue(rm.findAllAvailableRoom(1, 15, 16).size()==1);
		assertTrue(rm.findAllAvailableRoom(1, 6, 9).size()==2);
		assertTrue(rm.nextAvailableTime(103, 1)==2);
		assertTrue(rm.addEvent(103, e31));
		assertTrue(rm.nextAvailableTime(103, 1)==16);
		assertTrue(rm.addEvent(103, e33));
		assertTrue(rm.nextAvailableTime(103, 1)==-1);
		assertTrue(rm.findAllAvailableRoom(1, 0, 24).size()==0);
	}

}
