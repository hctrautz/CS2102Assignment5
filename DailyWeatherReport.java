import java.util.GregorianCalendar;

class DailyWeatherReport {
	private GregorianCalendar date;
	private Reading min;
	private Reading max;
	
	
	DailyWeatherReport(GregorianCalendar date, Reading min, Reading max){
		this.date = date;
		this.min = min;
		this.max = max;
	}
	
	public GregorianCalendar getDate() {
		return this.date;
	}
	
	public Reading getMax() {
		return this.max;
	}
	
	public Reading getMin() {
		return this.min;
	}
	
}
