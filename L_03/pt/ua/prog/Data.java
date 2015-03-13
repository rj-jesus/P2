package pt.ua.prog;
import java.util.Calendar;

public class Data {
	private int day, month, year;
	
	public Data(int day, int month, int year){
		this.day = day;
		this.month = month;
		this.year = year;
	}
	public boolean equalsTo(Data d){
		return day == d.day() && month == d.month() && year == d.year();
	}
	public boolean lessThan(Data d){
		if(this.equalsTo(d)) return false;
		if(year > d.year()) return false;
		else if(year < d.year()) return true;
		if(month > d.month()) return false;
		else if(month < d.month()) return true;
		if(day > d.day()) return false;
		return true;
	}
	public boolean greaterThan(Data d){
		if(this.equalsTo(d)) return false;
		if(this.lessThan(d)) return false;
		return true;
	}
	public void printDate(){
		System.out.printf("%02d-%02d-%04d", day, month, year);
	}
	public int day(){
		return day;
	}
	public int month(){
		return month;
	}
	public int year(){
		return year;
	}
}

