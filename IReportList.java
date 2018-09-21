import java.util.LinkedList;

public interface IReportList {
	public boolean addReport(DailyWeatherReport report);
	public LinkedList<DailyWeatherReport> getMonthReports(int month, int year);
}
