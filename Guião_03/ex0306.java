import java.util.Scanner;
import pt.ua.prog.Data2;

public class ex0306 {
	static final Scanner sc = new Scanner(System.in);
	public static void main (String args[]) {
		boolean recycle = true;
		Data2 data = null;
		int day, month, year;
		for(int c, i = 0; recycle; i++){
			switch(menu(i)){
				case 1: data = new Data2(); break;
				case 2:
					System.out.print("Dia: ");
					day = sc.nextInt();
					System.out.print("Mês: ");
					month = sc.nextInt();
					System.out.print("Ano: ");
					year = sc.nextInt();
					sc.nextLine();
					data = new Data2(day, month, year);
					break;
				case 3:
					if(data.dataVálida()) System.out.print("A data é válida.");
					else System.out.print("A data não é válida.");
					break;
				case 4: data.print(); break;
				case 5: data.printExtenso(); break;
				case 6: data.paraOntem(); break;
				case 7: data.paraAmanhã(); break;
				case 8:
					System.out.print("Data a comparar com última introduzida:\n");
					System.out.print("Dia: ");
					day = sc.nextInt();
					System.out.print("Mês: ");
					month = sc.nextInt();
					System.out.print("Ano: ");
					year = sc.nextInt();
					if(data.maiorDoQue(new Data2(day, month, year))) System.out.print("A data introduzida é menor.\n");
					else if(data.menorDoQue(new Data2(day, month, year))) System.out.print("A data introduzida é maior.\n");
					else System.out.print("As duas datas são iguais.\n");
					break;
				case 9:
					System.out.print("Data a comparar com última introduzida:\n");
					System.out.print("Dia: ");
					day = sc.nextInt();
					System.out.print("Mês: ");
					month = sc.nextInt();
					System.out.print("Ano: ");
					year = sc.nextInt();
					System.out.printf("Há %d dia(s) de diferença entre as duas datas.\n", Data2.diasDeDiferença(data, new Data2(day, month, year)));
					break;
				case 0: recycle = false;
			}
		}
	}
	public static int menu(int i){
		if(i == 0) System.out.print("1. Cria novo objecto com a data atual\n");
		else System.out.print("\n1. Cria novo objecto com a data atual\n");
		System.out.print("2. Cria novo objecto com uma qualquer data\n");
		System.out.print("3. Indica se a data é válida\n");
		System.out.print("4. Escreve data\n");
		System.out.print("5. Escreve data por extenso\n");
		System.out.print("6. Dia anterior\n");
		System.out.print("7. Dia seguinte\n");
		System.out.print("8. Comparar datas\n");
		System.out.print("9. Dias entre duas datas\n");
		System.out.print("0. Termina\n");
		System.out.print("\nNOTA: Se não houver indicação em contrário, todas as operações fazem-se sobre o último objecto criado\n");
		System.out.print("\nOpção: ");
		return inRange();
	}
	public static int inRange(){
		int x = -1;
		for(; x < 0 || x > 9; ) x = sc.nextInt();
		sc.nextLine();
		return x;
	}
}

