import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import java.util.Calendar;
import calendar.Meeting;
import calendar.MeetingCalendar;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;

import java.util.GregorianCalendar;



class CalendarEventTest {
	
	OneTimeEvent A;
	OneTimeEvent B;
	OneTimeEvent C;
	MeetingCalendar cal;
	
	OneTimeEvent AB;
	OneTimeEvent BC;
	
	PriorityEvent PE;
	
	GregorianCalendar startA;
	GregorianCalendar endA;
	GregorianCalendar startAB;
	GregorianCalendar endB;
	GregorianCalendar endC;
	
	GregorianCalendar startWE;
	GregorianCalendar endWE;
	GregorianCalendar repeat;
	
	

	@BeforeEach // yes, I imported it
	void setUp() throws Exception{
		
		cal = new MeetingCalendar();
		
								//year, month, day, hour, minute
		startA = new GregorianCalendar(2026, 8, 10, 1, 40);
		endA = new GregorianCalendar(2026, 8, 10, 2, 10);
		startAB = new GregorianCalendar(2021, 2, 2, 7, 0);
		endB = new GregorianCalendar(2021, 2, 2, 7, 30);
		endC = new GregorianCalendar(2021, 2, 2, 8, 30);
		repeat = new GregorianCalendar(2022, 3, 2, 9, 30);
		
		GregorianCalendar startWE = new GregorianCalendar(2021, 2, 2, 7, 30);
		

		startWE = new GregorianCalendar(2022, 2, 2, 8, 30);
		endWE = new GregorianCalendar(2022, 2, 2, 9, 30);
		
		
		GregorianCalendar endAB = new GregorianCalendar(2021, 2, 2, 8, 30);
		GregorianCalendar endBC = new GregorianCalendar(2021, 2, 2, 9, 30);
		
		// Why am I unable to do start an object? 
		A = new OneTimeEvent("A", "ALoc", startA, endA);
		B = new OneTimeEvent("B", "BLoc", endA, endB);
		C = new OneTimeEvent("C", "CLoc", endB, endC);
							
		AB = new OneTimeEvent("AB", "ABLoc", startAB, endAB);
		BC = new OneTimeEvent("BC", "BCLoc", endAB, endBC);
		
		
		
		PE = new PriorityEvent("PE", "PELoc", startA, endA);
		

		
		
		
		
		
		
		
		
	}
	@Test
	void testCalendarEvent() {
		assertEquals("ALoc", A.getLocation());
		assertEquals("A", A.getDescription());
		assertEquals(startA, A.getStartTime());
		assertEquals(endA, A.getEndTime());
	}
	
	@Test
	void testPriorityEventConstructor() {
		assertEquals("PELoc", PE.getLocation());
		assertEquals("PE", PE.getDescription());
		assertEquals(startA, PE.getStartTime());
		assertEquals(endA, PE.getEndTime());
	}
	
	@Test
	void testWeeklyEventConstructor() {
		WeeklyEvent WE = new WeeklyEvent("we", "weLoc", startWE, endWE, repeat);
		assertEquals("weLoc", WE.getLocation());
		assertEquals("we", WE.getDescription());
		assertEquals(startWE, WE.getStartTime());
		assertEquals(endWE, WE.getEndTime());
		assertEquals(repeat, WE.getRepeatUntil());
		
	}

	@Test
	void testMultiDayPerWeekEventConstructor() {
		int[] days = {Calendar.SATURDAY, Calendar.FRIDAY};
		MultiDayPerWeekEvent MDPWE =  new MultiDayPerWeekEvent("MDPW", "MDPWLoc",startWE, endWE, repeat, days);
		
		assertEquals("MDPWLoc", MDPWE.getLocation());
		assertEquals("MDPW", MDPWE.getDescription());
		assertEquals(startWE, MDPWE.getStartTime());
		assertEquals(endWE, MDPWE.getEndTime());
		assertEquals(repeat, MDPWE.getRepeatUntil());
		assertNotNull(days);
	}
	
	
	@Test
	void testscheduleEvent() {
		A.scheduleEvent(cal);
		
		assertEquals("A", cal.findMeeting(startA).getDescription());
		assertEquals("ALoc", cal.findMeeting(startA).getLocation());
		
	}
	
	@Test
	void testPriorityEvent() {
		PriorityEvent r = new PriorityEvent("r", "rLoc", startA, endA);

		assertEquals("rLoc", cal.findMeeting(startA).getLocation());

		
	}
	
	@Test
	void testWeeklyEvent() {
		GregorianCalendar until = new GregorianCalendar(2026, 8, 24, 23, 59);
		WeeklyEvent w = new WeeklyEvent("W", "WLoc", startA, endA, until);
		
		GregorianCalendar week2 = (GregorianCalendar) startA.clone();
		
		GregorianCalendar week3 = (GregorianCalendar) startA.clone();
		
		GregorianCalendar week4 = (GregorianCalendar) startA.clone();
		
		assertNotNull(cal.findMeeting(startA));
		assertNotNull(cal.findMeeting(week2));
		assertNotNull(cal.findMeeting(week3));
		assertNull(cal.findMeeting(week4));
		}
	
	@Test 
	void testMultiDayPerWeekEvent() {
		GregorianCalendar until = new GregorianCalendar(2026, 8, 13 ,23, 59);
		int[] days = { Calendar.THURSDAY, Calendar.SATURDAY};
		
		MultiDayPerWeekEvent m = new MultiDayPerWeekEvent("m", "mLoc", startA, endA, until, days);
		
		
		
		assertNotNull(cal.findMeeting(startA));
		
		assertEquals("m", cal.findMeeting(startA).getDescription());
	}



}
