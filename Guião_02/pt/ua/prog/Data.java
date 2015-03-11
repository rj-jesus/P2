package pt.ua.prog;
import java.util.Calendar;

public class Data {
	private int day, month, year;
	
	public Data(int day, int month, int year){
		this.day = day;
		this.month = month;
		this.year = year;
	}
	public Data(){
		Calendar date = Calendar.getInstance();
		day = date.get(Calendar.DAY_OF_MONTH);
		month = date.get(Calendar.MONTH) + 1;
		year = date.get(Calendar.YEAR);
	}
	public boolean greaterThan(Data a){
		if(year > a.year()) return true;
		else if(year == a.year()){
			if(month > a.month()) return true;
			else if(month == a.month()){
				if(day < a.day()) return true;
			}
		}
		return false;
	}
	public boolean lessThan(Data a){
		if(year < a.year()) return true;
		else if(year == a.year()){
			if(month < a.month()) return true;
			else if(month == a.month()){
				if(day < a.day()) return true;
			}
		}
		return false;
	}
	public boolean equalTo(Data a){
		if(a.year() == year && a.month() == month && a.day() == day) return true;
		return false;
	}
	public void toTomorrow(){
		assert checkDate(day, month, year);
		day += 1;
		if(day > daysInMonth(month, year)){
			day = 1;
			month += 1;
		}
		if(month == 13){
			month = 1;
			year += 1;
		}
	}
	public void toYesterday(){
		assert checkDate(day, month, year);
		day -= 1;
		if(day < 1){
			if(month > 1){
				month -= 1;
				day = daysInMonth(month, year);
			}
			else{
				month = 12;
				day = 31;
				year -= 1;
			}
		}
	}
	public String writeDate(){
		return "" + day + " de " + nameOfMonth() + " de " + year;
	}
	public String nameOfMonth(){
		switch(month){
			case 1: return "Janeiro";
			case 2: return "Fevereiro";
			case 3: return "Março";
			case 4: return "Abril";
			case 5: return "Maio";
			case 6: return "Junho";
			case 7: return "Julho";
			case 8: return "Agosto";
			case 9: return "Setembro";
			case 10: return "Outubro";
			case 11: return "Novembro";
			case 12: return "Dezembro";
			default: throw new AssertionError("Error: Invalid month!");
		}
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
	public static boolean checkDate(int day, int month, int year){
		if(day < 1 || month < 1 || month > 12 || year < 0) return false;
		if(day > daysInMonth(month, year)) return false;
		return true;
	}
	static int daysInMonth(int month, int year){
		switch(month){
			case 1: case 3: case 5: case 7: case 8: case 10: case 12: return 31;
			case 4: case 6: case 9: case 11: return 30;
			case 2:
				if(leapYear(year)) return 29;
				return 28;
			default: throw new AssertionError("Error: Invalid day!");
		}
	}
	static boolean leapYear(int year){
		return year % 4 == 0 && year % 100 != 0 || year % 400 == 0;
	}
	public void printDate(){
		System.out.printf("%02d-%02d-%04d", day, month, year);
	}
}

