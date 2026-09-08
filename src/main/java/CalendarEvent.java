// Stub file for CalendarEvent

import java.util.GregorianCalendar;

import calendar.MeetingCalendar;

public abstract class CalendarEvent{
	
	protected String description;
	protected String location;
	protected GregorianCalendar startTime;
	protected GregorianCalendar endTime;
	
	
	public CalendarEvent(String desc, String loc, GregorianCalendar start, GregorianCalendar end) 
	{
	}
	
	public void ScheduleEvent(MeetingCalendar cal)
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

