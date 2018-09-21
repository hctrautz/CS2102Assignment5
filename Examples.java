import static org.junit.Assert.*;
import java.util.GregorianCalendar;
import java.util.LinkedList;

import org.junit.Test;

public class Examples {
	GregorianCalendar jan52016 = new GregorianCalendar(2016, 0, 5); 
	GregorianCalendar jan52017 = new GregorianCalendar(2017, 0, 5); 
	GregorianCalendar feb5 = new GregorianCalendar(2017, 1, 5); 
	GregorianCalendar may18 = new GregorianCalendar(2017, 4, 18); 
	GregorianCalendar aug3 = new GregorianCalendar(2017, 7, 3); 
	GregorianCalendar aug27 = new GregorianCalendar(2017, 7, 27); 
	GregorianCalendar dec3 = new GregorianCalendar(2017, 9, 3); 
	GregorianCalendar dec8 = new GregorianCalendar(2017, 9, 8); 

	Time sixam = new Time(6,0);
	Time sixpm = new Time(6,0);
	Time noon = new Time(12,0);
	Time midnight = new Time(24,0);

	Reading negativeReading = new Reading(midnight, -10);
	Reading coldMidnight = new Reading(midnight, 1);
	Reading varReading2 = new Reading(sixam, 20);
	Reading coldMorning = new Reading(sixam, 32);
	Reading varReading4 = new Reading(sixpm, 51);
	Reading varReading3 = new Reading(sixam, 54);
	Reading warmMorning = new Reading(sixpm, 65);
	Reading varReading1 = new Reading(sixam, 67);
	Reading varReading5 = new Reading(sixpm, 71);
	Reading varReading6 = new Reading(sixpm, 80);
	LinkedList<Reading> readings = new LinkedList<Reading>();


	DailyWeatherReport dReport1 = new DailyWeatherReport(jan52016,coldMidnight,varReading2);
	DailyWeatherReport dReport12 = new DailyWeatherReport(jan52017,negativeReading,coldMorning);
	DailyWeatherReport dReport2 = new DailyWeatherReport(feb5,coldMorning,varReading4);
	DailyWeatherReport dReport3 = new DailyWeatherReport(may18,warmMorning,varReading5);
	DailyWeatherReport dReport4 = new DailyWeatherReport(aug3,varReading1,varReading6);
	DailyWeatherReport dReport5 = new DailyWeatherReport(aug27,warmMorning,varReading5);
	DailyWeatherReport dReport6 = new DailyWeatherReport(dec3,negativeReading,coldMorning);
	DailyWeatherReport dReport7 = new DailyWeatherReport(dec8,negativeReading,varReading6);
	ReportList reportList = new ReportList();

	public Examples(){
		readings.add(negativeReading);
		readings.add(coldMidnight);
		readings.add(varReading2);
		readings.add(coldMorning);
		readings.add(varReading4);
		readings.add(varReading3);
		readings.add(warmMorning);
		readings.add(varReading1);
		readings.add(varReading5);
		readings.add(varReading6);

		reportList.addReport(dReport1);
		reportList.addReport(dReport2);
		reportList.addReport(dReport3);
		reportList.addReport(dReport4);
		reportList.addReport(dReport5);
		reportList.addReport(dReport6);
		reportList.addReport(dReport12);
		reportList.addReport(dReport7);
	}

	//tests the method with a month with multiple readings 
	@Test
	public void testAverageHighForMonth() {
		WeatherMonitor monitor = new WeatherMonitor(reportList);
		assertEquals(monitor.averageHighForMonth(7, 2017), 75.5, .01); 
	}

	//tests the method with a month that has a single reading
	@Test
	public void testAverageHighForMonth2() {
		WeatherMonitor monitor = new WeatherMonitor(reportList);
		assertEquals(monitor.averageHighForMonth(4, 2017), 71, .01); 
	}

	//tests with two different years of the same month
	@Test
	public void testAverageHighForMont3() {
		WeatherMonitor monitor = new WeatherMonitor(reportList);
		assertEquals(monitor.averageHighForMonth(0, 2016), 20, .01); 
	}

	//tests the method with a month with multiple readings 
	@Test
	public void testAverageLowForMonth() {
		WeatherMonitor monitor = new WeatherMonitor(reportList);
		assertEquals(monitor.averageLowForMonth(7, 2017), 66, .01); 
	}

	//tests the method with a month that has a single reading
	@Test
	public void testAverageHLowForMonth2() {
		WeatherMonitor monitor = new WeatherMonitor(reportList);
		assertEquals(monitor.averageLowForMonth(4, 2017), 65, .01); 
	}

	//tests with two different years of the same month
	@Test
	public void testAverageLowForMonth3() {
		WeatherMonitor monitor = new WeatherMonitor(reportList);
		assertEquals(monitor.averageLowForMonth(0, 2016), 1, .01); 
	}

	//tests with negative #
	@Test
	public void testAverageLowForMont4() {
		WeatherMonitor monitor = new WeatherMonitor(reportList);
		assertEquals(monitor.averageLowForMonth(0, 2017), -10, .01); 
	}
	
}


