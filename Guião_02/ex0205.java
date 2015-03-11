import java.util.Scanner;
import pt.ua.prog.*;

public class ex0205 {
	static final Scanner sc = new Scanner(System.in);
	public static void main (String args[]) {
		boolean recycle = true;
		Data xpto = null;
		for(int c; recycle; ){
			switch(menu()){
				case 1: xpto = new Data(); break;
				case 2:
					System.out.print("Dia: ");
					int day = sc.nextInt();
					System.out.print("Mês: ");
					int month = sc.nextInt();
					System.out.print("Ano: ");
					int year = sc.nextInt();
					sc.nextLine();
					xpto = new Data(day, month, year);
					break;
				case 3:
					if(Data.checkDate(xpto.day(), xpto.month(), xpto.year())) System.out.print("A data é válida.");
					else System.out.print("A data é inválida.");
					break;
				case 4: xpto.printDate(); break;
				case 5: System.out.printf("%s", xpto.writeDate()); break;
				case 6: xpto.toYesterday(); break;
				case 7: xpto.toTomorrow(); break;
				case 0: recycle = false;
			}
		}
	}
	public static int menu(){
		System.out.print("\n1. Cria novo objecto com a data atual\n");
		System.out.print("2. Cria novo objecto com uma qualquer data\n");
		System.out.print("3. Indica se a data é válida\n");
		System.out.print("4. Escreve data\n");
		System.out.print("5. Escreve data por extenso\n");
		System.out.print("6. Dia anterior\n");
		System.out.print("7. Dia seguinte\n");
		System.out.print("0. Termina\n");
		System.out.print("\nNOTA: Se não houver indicação em contrário, todas as operações fazem-se sobre o último objecto criado\n");
		System.out.print("\nOpção: ");
		return inRange(0, 7);
	}
	public static int inRange(int min, int max){
		for(; ; ){
			int x = sc.nextInt();
			if(x >= min && x <= max){
				sc.nextLine();
				return x;
			}
		}
	}
}

