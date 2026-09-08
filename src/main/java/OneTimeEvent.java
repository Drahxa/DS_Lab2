import java.util.GregorianCalendar;

import calendar.MeetingCalendar;

public class OneTimeEvent extends CalendarEvent{

	public OneTimeEvent(String desc, String loc, GregorianCalendar start, GregorianCalendar end) {
		super(desc, loc, start, end);
		
	}

	public void scheduleEvent(MeetingCalendar cal) {
		
	}


}
