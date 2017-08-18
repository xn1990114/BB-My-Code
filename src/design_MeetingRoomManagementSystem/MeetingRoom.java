package design_MeetingRoomManagementSystem;
import java.util.*;

public class MeetingRoom {
	int ID;
	// tree map is mapping time against event ID
	Map<Long,TreeMap<Integer,Integer>> calendar;
	public MeetingRoom(int ID){
		this.ID=ID;
		this.calendar=new HashMap<Long,TreeMap<Integer,Integer>>();
		for(int i=0;i<=5;i++){
			TreeMap<Integer,Integer> tm=new TreeMap<Integer,Integer>();
			this.calendar.put((long)i, tm);
		}
	}
	
}
