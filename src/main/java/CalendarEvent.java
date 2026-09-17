// Stub file for CalendarEvent

import java.util.GregorianCalendar;

import calendar.MeetingCalendar;
import calendar.Meeting;

public abstract class CalendarEvent{
	
	private String description;
	private String location;
	private GregorianCalendar startTime;
	private GregorianCalendar endTime;
	
	
	public CalendarEvent(String desc, String loc, GregorianCalendar start, GregorianCalendar end) 
	{
		this.description = desc;
		this.location = loc;
		this.startTime = start;
		this.endTime = end;
	}
	
	public void scheduleEvent(MeetingCalendar cal)
	{	
		Meeting m = new Meeting(getDescription(), getLocation(), getStartTime(), getEndTime());
		cal.addMeeting(m);
		
	}
	
	public String getDescription()
	{
		return description;
	}
	
	public String getLocation()
	{
		return location;
	}
	
	public GregorianCalendar getStartTime()
	{
		return startTime;
	}
	
	public GregorianCalendar getEndTime()
	{
		return endTime;
	}
	
	
	

	
	
	
}

