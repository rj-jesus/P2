package pt.ua.prog;
import java.util.Calendar;

public class Data2 {
	private int dias;
	private boolean isValid;
	
	public static int diasDeDiferença(Data2 a, Data2 b){
		if(a.dias() >= b.dias()) return a.dias() - b.dias();
		return b.dias() - a.dias();
	}
	public boolean igualA(Data2 a){
		if(dias == a.dias()) return true;
		return false;
	}
	public boolean menorDoQue(Data2 a){
		if(dias < a.dias()) return true;
		return false;
	}
	public boolean maiorDoQue(Data2 a){
		if(dias > a.dias()) return true;
		return false;
	}
	public void paraOntem(){
		dias -= 1;
	}
	public void paraAmanhã(){
		dias += 1;
	}
	public void printExtenso(){
		System.out.printf("%d de %s de %d", dia(), nomeDoMês(), ano());
	}
	public String nomeDoMês(){
		int mês = mês();
		String[] nomes = {"Janeiro", "Fevereiro", "Março", "Abril", "Maio", "Junho", "Julho", "Agosto", "Setembro", "Outrubro", "Novembro", "Dezembro"};
		return nomes[mês - 1];
	}
	public Data2(){
		Calendar hoje = Calendar.getInstance();
		int ano = hoje.get(Calendar.YEAR);
		for(int i = 0; i < ano - 2000; i++){
			if(bissexto(i)) dias += 366;
			else dias += 365;
		}
		dias += hoje.get(Calendar.DAY_OF_YEAR);
		isValid = true;
	}
	public Data2(int dia, int mês, int ano){
		assert (ano >= 2000 && dataVálida(dia, mês, ano));
		isValid = dataVálida(dia, mês, ano);
		dias = dia;
		for(int i = 0; i < ano - 2000; i++){
			if(bissexto(i)) dias += 366;
			else dias += 365;
		}
		int fev = 28;
		if(bissexto(ano)) fev = 29;
		int[] dias_array = {0, 31, fev, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
		for(int i = 1; i < mês; i++) dias += dias_array[i];
	}
	public static boolean dataVálida(int dia, int mês, int ano){
		if(dia < 1 || mês < 1 || ano > 12 || ano < 0) return false;
		if(dia > diasNoMês(mês, ano)) return false;
		return true;
	}
	public boolean dataVálida(){
		return isValid;
	}
	public static int diasNoMês(int mês, int ano){
		int fev = 28;
		if(bissexto(ano)) fev = 29;
		int[] dias = {31, fev, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
		return dias[mês - 1];
	}
	public int dias(){
		return dias;
	}
	public int dia(){
		int dia = dias, i = 0;
		boolean repetir = true;
		for(; repetir; i++){
			if(i % 4 == 0 && i %100 != 0 || i % 400 == 0){
				if(dia >= 366) dia -= 366;
				else repetir = false;
			}
			else{
				if(dia >= 365) dia -= 365;
				else repetir = false;
			}
		}
		int fev = 28;
		if(bissexto(ano())) fev = 29;
		int[] dia_array = {0, 31, fev, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
		for(i = 1; ; i++){
			if(dia - dia_array[i] <= 0) break;
			dia -= dia_array[i];
		}
		return dia;
	}
	public int mês(){
		int mês = dias, i = 0;
		boolean repetir = true;
		for(; repetir; i++){
			if(i % 4 == 0 && i %100 != 0 || i % 400 == 0){
				if(mês >= 366) mês -= 366;
				else repetir = false;
			}
			else{
				if(mês >= 365) mês -= 365;
				else repetir = false;
			}
		}
		int fev = 28;
		if(bissexto(ano())) fev = 29;
		int[] dia = {0, 31, fev, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
		int tmp = 0;
		for(i = 1; ; i++){
			tmp += dia[i];
			if(tmp >= mês) break;
		}
		return i;
	}
	public int ano(){
		int ano = dias, i = 0;
		boolean repetir = true;
		for(; repetir; i++){
			if(i % 4 == 0 && i %100 != 0 || i % 400 == 0){
				if(ano >= 366) ano -= 366;
				else repetir = false;
			}
			else{
				if(ano >= 365) ano -= 365;
				else repetir = false;
			}
		}
		return 2000 + --i;
	}
	public static boolean bissexto(int ano){
		if(ano % 4 == 0 && ano % 100 != 0 || ano % 400 == 0) return true;
		return false;
	}
	public void print(){
		System.out.printf("%02d-%02d-%04d", dia(), mês(), ano());
	}
}
