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
	
	GregorianCalendar startA;
	GregorianCalendar endA;
	GregorianCalendar startAB;
	GregorianCalendar endB;
	GregorianCalendar endC;
	
	

	@BeforeEach // yes, I imported it
	void setUp() throws Exception{
		
		cal = new MeetingCalendar();
		
								//year, month, day, hour, minute
		startA = new GregorianCalendar(2026, 8, 10, 1, 40);
		endA = new GregorianCalendar(2026, 8, 10, 2, 10);
		startAB = new GregorianCalendar(2021, 2, 2, 7, 0);
		endB = new GregorianCalendar(2021, 2, 2, 7, 30);
		endC = new GregorianCalendar(2021, 2, 2, 8, 30);
		
		GregorianCalendar endAB = new GregorianCalendar(2021, 2, 2, 8, 30);
		GregorianCalendar endBC = new GregorianCalendar(2021, 2, 2, 9, 30);
		
		// Why am I unable to do start an object? 
		A = new OneTimeEvent("A", "ALoc", startA, endA);
		B = new OneTimeEvent("B", "BLoc", endA, endB);
		C = new OneTimeEvent("C", "CLoc", endB, endC);
							
		AB = new OneTimeEvent("AB", "ABLoc", startAB, endAB);
		BC = new OneTimeEvent("BC", "BCLoc", endAB, endBC);
		
		
		
		
	}
	@Test
	void testCalendarEvent() {
		assertEquals("ALoc", A.getLoc());
		assertEquals("A", A.getDesc());
		assertEquals(startA, A.getStart());
		assertEquals(endA, A.getEnd());
	}
	
	@Test
	void testscheduleEvent() {
		A.scheduleEvent(cal);
		
		Meeting booked = cal.findMeeting(startA);
		
		assertNotNull(booked);
		assertEquals("A", booked.getDescription());
		assertEquals("ALoc", booked.getLocation());
		
	}
	
	@Test
	void testPriorityEvent() {
		A.scheduleEvent(cal);
		
		PriorityEvent r = new PriorityEvent("r", "rLoc", startA, endA);
		
		r.scheduleEvent(cal);
		
		Meeting booked = cal.findMeeting(startA);
		
		assertNotNull(booked);
		assertEquals("r", booked.getDescription());
		assertEquals("rLoc", booked.getLocation());

		
	}
	
	void testWeeklyEvent() {
		GregorianCalendar until = new GregorianCalendar(2026, 8, 14, 23, 59);
		WeeklyEvent w = new WeeklyEvent("W", "WLoc", startA, endA, until);
		w.scheduleEvent(cal);
		
		GregorianCalendar week2 = (GregorianCalendar) startA.clone();
		week2.add(Calendar.DATE, 7);
		GregorianCalendar week3 = (GregorianCalendar) startA.clone();
		week3.add(Calendar.DATE, 14);
		GregorianCalendar week4 = (GregorianCalendar) startA.clone();
		week4.add(Calendar.DATE, 21);
	}

	//Q. Can I delete Get/Set Test if I am testing the constructor.
//	@Test
//	void testScheduleEvent() {
//		assertFalse();
//	}



}
