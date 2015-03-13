package pt.ua.prog;
import java.util.Calendar;

public class Data {
	private int day, month, year;
	
	public Data(int day, int month, int year){
		this.day = day;
		this.month = month;
		this.year = year;
		if(!checkDate(this.day, this.month, this.year)) throw new AssertionError("Error: Invalid date entered!");
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
	private static boolean checkDate(int day, int month, int year){
		if(day < 1 || month < 1 || month > 12 || year < 0) return false;
		if(day > daysInMonth(month, year)) return false;
		return true;
	}
	private static int daysInMonth(int month, int year){
		switch(month){
			case 1: case 3: case 5: case 7: case 8: case 10: case 12: return 31;
			case 4: case 6: case 9: case 11: return 30;
			case 2:
				if(leapYear(year)) return 29;
				return 28;
			default: throw new AssertionError("Error: Invalid day!");
		}
	}
	private static boolean leapYear(int year){
		return year % 4 == 0 && year % 100 != 0 || year % 400 == 0;
	}
}
