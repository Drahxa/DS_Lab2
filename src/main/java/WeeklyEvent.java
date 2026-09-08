import java.util.GregorianCalendar;

public class WeeklyEvent extends CalendarEvent{
	
	private GregorianCalendar repeatUntil;
	
	public WeeklyEvent(String desc, String loc, GregorianCalendar start, GregorianCalendar end, GregorianCalendar repeat) {
		super(desc, loc, start, end);
		this.setRepeatUntil(repeat);
		
	}

	public GregorianCalendar getRepeatUntil() {
		return repeatUntil;
	}

	public void setRepeatUntil(GregorianCalendar repeatUntil) {
		this.repeatUntil = repeatUntil;
	}
}


