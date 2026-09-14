// Stub file for CalendarEvent

import java.util.GregorianCalendar;

import calendar.MeetingCalendar;

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
	}
	
	public String getDesc()
	{
		return description;
	}
	
	public String getLoc()
	{
		return location;
	}
	
	public GregorianCalendar getStart()
	{
		return startTime;
	}
	
	public GregorianCalendar getEnd()
	{
		return endTime;
	}
	
	
	

	
	
	
}

