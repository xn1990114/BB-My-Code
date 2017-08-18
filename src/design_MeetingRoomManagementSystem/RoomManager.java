package design_MeetingRoomManagementSystem;
import java.util.*;
/*
 * design question: Meeting Room Management System. 要求实现两个功能：
 * a. 给定一个internval返回所有在这个internval内available的room; 
 * b. 给定一个room和时间返回这个room最早的available时间
 */
public class RoomManager {
	public Map<Integer,MeetingRoom> rooms;
	public Map<Integer,Event> events;
	public RoomManager(){
		this.rooms=new HashMap<Integer,MeetingRoom>();
		this.events=new HashMap<Integer,Event>();
	}
	public boolean addEvent(int roomID,Event e){
		this.events.put(e.ID, e);
		MeetingRoom room=this.rooms.get(roomID);
		if(!searchAvailability(room,e.day,e.startTime,e.endTime)){
			return false;
		}
		room.calendar.get(e.day).put(e.startTime, e.ID);
		return true;
	}
	//function a
	public List<Integer> findAllAvailableRoom(long day ,int start,int end){
		List<Integer> result=new ArrayList<Integer>();
		for(int roomID:this.rooms.keySet()){
			if(searchAvailability(rooms.get(roomID),day,start,end)){
				result.add(roomID);
			}
		}
		return result;
	}
	
	public boolean searchAvailability(MeetingRoom room,long day,int start, int end){
		TreeMap<Integer,Integer> curr=room.calendar.get(day);
		Integer nextStart=curr.ceilingKey(start);
		if(nextStart!=null&&nextStart<end){
			return false;
		}
		Integer lastStart=curr.floorKey(start);
		if(lastStart!=null&&events.get(curr.get(lastStart)).endTime>start){
			return false;
		}
		return true;
	}
	// function b;
	public int nextAvailableTime(int roomID,long day){
		MeetingRoom room=this.rooms.get(roomID);
		TreeMap<Integer,Integer> curr=room.calendar.get(day);
		int time=0;
		for(int key:curr.keySet()){
			if(key>time){
				return time;
			}
			time=events.get(curr.get(key)).endTime;
		}
		
		return time==24?-1:time;
	}
}
