import java.util.GregorianCalendar;
import java.util.LinkedList;

class ReportList implements IReportList {
	private LinkedList<DailyWeatherReport> dailyReports;

	ReportList(){
		dailyReports = new LinkedList<DailyWeatherReport>();
	}
	
	ReportList(LinkedList<DailyWeatherReport> dailyReports){
		this.dailyReports = dailyReports;
	}

	@Override
	public boolean addReport(DailyWeatherReport report) {
		return dailyReports.add(report);
	}
	
	//returns a list of reports from the desired month and year
	public LinkedList<DailyWeatherReport> getMonthReports(int month, int year){
		LinkedList<DailyWeatherReport> reportsForMonth = new LinkedList<DailyWeatherReport>();
		
		for(DailyWeatherReport report : this.dailyReports) {
			if((report.getDate().get(GregorianCalendar.MONTH) == month) && (report.getDate().get(GregorianCalendar.YEAR) == year)) {
				reportsForMonth.add(report);
			}
		}
		return reportsForMonth;
	}
	
}
