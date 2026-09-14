import java.util.GregorianCalendar;

import calendar.MeetingCalendar;
import calendar.Meeting;
public class PriorityEvent extends CalendarEvent{

	public PriorityEvent(String desc, String loc, GregorianCalendar start, GregorianCalendar end) {
		super(desc, loc, start, end);
		
	}
	
	public void scheduleEvent(MeetingCalendar cal) {
		Meeting m = new Meeting(getDesc(), getLoc(), getStart(), getEnd());
		cal.addMeeting(m, true);
	}

}
