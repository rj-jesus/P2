package pt.ua.prog;
import java.util.Calendar;

public class Data {
	private int d, m, a;
	
	public Data(){
		Calendar hoje = Calendar.getInstance();
		d = hoje.get(Calendar.DAY_OF_MONTH);
		m = hoje.get(Calendar.MONTH) + 1;
		a = hoje.get(Calendar.YEAR);
	}
	public Data(int day, int month, int year){
		d = day;
		m = month;
		a = year;
	}
	public int day(){
		return d;
	}
	public int month(){
		return m;
	}
	public int year(){
		return a;
	}
	public void writeDate(){
		System.out.printf("%d de %s de %d", d, nameOfMonth(), a);
	}
	public void toTomorrow(){
		d += 1;
		if(d == 32){
			d = 1;
			m += 1;
			if(m == 13){
				m = 1;
				a += 1;
			}
		}
		else if(d == 31 && (m == 4 || m == 6 || m == 9 || m == 11)){
			d = 1;
			m += 1;
		}
		else{
			if(d == 30 && m == 2 && leapYear(a)){
			d = 1;
			m += 1;
			}
			else if(d == 29 && m == 2){
				d = 1;
				m += 1;
			}
		}
	}
	public void toYesterday(){
		d -= 1;
		if(d == 0){
			m -= 1;
			if(m == 0){
				a -= 1;
				m = 12;
				d = 31;
			}
			else d = daysInMonth(m, a);
		}
	}
	public String nameOfMonth(){
		switch(m){
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
		}
		return "Inválido";
	}
	public void printData(){
		System.out.printf("%02d-%02d-%04d", d, m, a);
	}
	static boolean leapYear(int x){
		if(x % 4 == 0 && x % 100 != 0 || x % 400 == 0) return true;
		return false;
	}
	static int daysInMonth(int x, int y){
		switch(x){
			case 1: case 3: case 5: case 7: case 8: case 10: case 12: return 31;
			case 4: case 6: case 9: case 11: return 30;
			case 2: if(leapYear(y)) return 29; else return 28;
		}
		return -1;
	}
	public static boolean checkDate(int x, int y, int z){
		if(x < 1 || x > 31 || y < 1 || y > 12) return false;
		switch(y){
			case 4: case 6: case 9: case 11: if(x > 30) return false;
			case 2: 
				if(leapYear(z)){
					if(x > 29) return false;
				}
				else if(x > 28) return false;
		}
		return true;
	}
}
