import java.util.GregorianCalendar;

import calendar.MeetingCalendar;
import calendar.Meeting;

public class OneTimeEvent extends CalendarEvent{

	public OneTimeEvent(String desc, String loc, GregorianCalendar start, GregorianCalendar end) {
		super(desc, loc, start, end);
		
	}

	public void scheduleEvent(MeetingCalendar cal) {
		Meeting m = new Meeting(getDescription(), getLocation(), getStartTime(), getEndTime());
		cal.addMeeting(m);
	}
}
