import java.util.GregorianCalendar;

import java.util.Calendar;
import calendar.Meeting;
import calendar.MeetingCalendar;

public class WeeklyEvent extends CalendarEvent{
	
	private GregorianCalendar repeatUntil;
	
	public WeeklyEvent(String desc, String loc, GregorianCalendar start, GregorianCalendar end, GregorianCalendar repeat) {
		super(desc, loc, start, end);
		this.setRepeatUntil(repeat);
		
	}
	
	public void scheduleEvent(MeetingCalendar cal) {
		GregorianCalendar startDate = (GregorianCalendar)getStartTime().clone();
		GregorianCalendar endDate = (GregorianCalendar)getEndTime().clone();
		
		while(startDate.compareTo(endDate) <= 0) {
			Meeting m = new Meeting(getDescription(), getLocation(), getStartTime(), getEndTime());
			cal.addMeeting(m);
			
			startDate.add(Calendar.DATE, 7);
			endDate.add(Calendar.DATE, 7);
		}
	}

	public GregorianCalendar getRepeatUntil() {
		return repeatUntil;
	}

	public void setRepeatUntil(GregorianCalendar repeatUntil) {
		this.repeatUntil = repeatUntil;
	}
}


