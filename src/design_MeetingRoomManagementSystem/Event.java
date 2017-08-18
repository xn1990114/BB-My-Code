package design_MeetingRoomManagementSystem;

public class Event {
	static int currID=1;
	public int ID;
	public String content;
	public long day;
	public int startTime;
	public int endTime;
	public Event(long day,int start,int end,String content){
		this.ID=currID;
		currID++;
		this.day=day;
		this.startTime=start;
		this.endTime=end;
		this.content=content;
	}
}
