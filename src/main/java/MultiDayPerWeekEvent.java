import java.util.GregorianCalendar;

import calendar.MeetingCalendar;
import calendar.Meeting;
import java.util.Calendar;

public class MultiDayPerWeekEvent extends CalendarEvent {
	
	private GregorianCalendar repeatUntil;
	private int[] days;

	public MultiDayPerWeekEvent(String desc, String loc, GregorianCalendar start, 
			GregorianCalendar end, GregorianCalendar repeat, int[]days) {
		super(desc, loc, start, end);
		this.repeatUntil = repeat; 
		this.days = days;
	
	}
	
	public void scheduleEvent(MeetingCalendar cal) {
		GregorianCalendar startDate = (GregorianCalendar) getStartTime().clone();
		GregorianCalendar endDate = (GregorianCalendar) getEndTime().clone();
		
		int today = startDate.get(Calendar.DAY_OF_WEEK);
		while(startDate.compareTo(getRepeatUntil()) <= 0) {
			
			for(int day: getDays()) {
				if (day == today) {
					Meeting m = new Meeting(getDescription(), getLocation(), startDate, endDate);
					cal.addMeeting(m);
				}
				startDate.add(Calendar.DATE, 1);
				endDate.add(Calendar.DATE, 1);
			}
			
		}
		
		 
	}

	public GregorianCalendar getRepeatUntil() {
		return repeatUntil;
	}

	public void setRepeatUntil(GregorianCalendar repeatUntil) {
		this.repeatUntil = repeatUntil;
	}

	public int[] getDays() {
		return days;
	}

	public void setDays(int[] days) {
		this.days = days;
	}
	

}
