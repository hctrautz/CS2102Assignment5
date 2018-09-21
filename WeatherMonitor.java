import java.util.GregorianCalendar;
import java.util.LinkedList;

class WeatherMonitor {
	private IReportList reports;

	WeatherMonitor(IReportList reports){
		this.reports = reports;
	}

	//produces the average highest temperature for a month of a specific year
	public double averageHighForMonth(int month, int year) {
		double sum = 0;
		double items = 0;

		for (DailyWeatherReport report: reports.getMonthReports(month, year)){
			sum = report.getMax().getTemp() + sum;
			items = items + 1;
		}
	return (sum/items);
}

	//produces the average lowest temperature for a month of a specific year
	public double averageLowForMonth(int month, int year) {
		double sum = 0;
		double items = 0;

		for (DailyWeatherReport report: reports.getMonthReports(month, year)){
				sum = report.getMin().getTemp() + sum;
				items = items + 1;
			}
		return (sum/items);
	}

	//produces the reading with the greatest temperature 
	public Reading getHigh(LinkedList<Reading> readings){
		Reading high = readings.get(0);
		for(int i = 0; i < readings.size(); i++){	
			if(readings.get(i).getTemp()> high.getTemp()){
				high = readings.get(i);
			}
		}
		return high;
	}
	//produces the reading with the lowest temperature 
	public Reading getLow(LinkedList<Reading> readings){
		Reading low = readings.get(0);
		for(int i = 0; i < readings.size(); i++){	
			if(readings.get(i).getTemp() < low.getTemp()){
				low = readings.get(i);
			}
		}
		return low;
	}

	//consumes a date and a list of readings, creates a new DailyWeatherReport, and then adds it to the the WeatherMonitor
	public void addDailyReport(GregorianCalendar date, LinkedList<Reading> readings) {
		DailyWeatherReport aReport = new DailyWeatherReport (date, getLow(readings), getHigh(readings));
		reports.addReport(aReport);
	}

}
