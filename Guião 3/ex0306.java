import java.util.Scanner;
import pt.ua.prog.Data2;

public class ex0306 {
	static final Scanner sc = new Scanner(System.in);
	public static void main (String args[]) {
		boolean recycle = true;
		Data2 xpto = null;
		int tmp1, tmp2, tmp3;
		for(int c, i = 0; recycle; i++){
			switch(menu(i)){
				case 1: xpto = new Data2(); break;
				case 2:
					System.out.print("Dia: ");
					tmp1 = sc.nextInt();
					System.out.print("Mês: ");
					tmp2 = sc.nextInt();
					System.out.print("Ano: ");
					tmp3 = sc.nextInt();
					sc.nextLine();
					xpto = new Data2(tmp1, tmp2, tmp3);
					break;
				case 3: if(Data2.dataVálida(xpto.dia(), xpto.mês(), xpto.ano())) System.out.print("A data é válida."); else System.out.print("A data é inválida."); break;
				case 4: xpto.print(); break;
				case 5: xpto.printExtenso(); break;
				case 6: xpto.paraOntem(); break;
				case 7: xpto.paraAmanhã(); break;
				case 8:
					System.out.print("Data a comparar com última introduzida:\n");
					System.out.print("Dia: ");
					tmp1 = sc.nextInt();
					System.out.print("Mês: ");
					tmp2 = sc.nextInt();
					System.out.print("Ano: ");
					tmp3 = sc.nextInt();
					if(xpto.maiorDoQue(new Data2(tmp1, tmp2, tmp3))) System.out.print("A data introduzida é menor.\n");
					else if(xpto.menorDoQue(new Data2(tmp1, tmp2, tmp3))) System.out.print("A data introduzida é maior.\n");
					else System.out.print("As duas datas são iguais.\n");
					break;
				case 9:
					System.out.print("Data a comparar com última introduzida:\n");
					System.out.print("Dia: ");
					tmp1 = sc.nextInt();
					System.out.print("Mês: ");
					tmp2 = sc.nextInt();
					System.out.print("Ano: ");
					tmp3 = sc.nextInt();
					System.out.printf("Há %d dia(s) de diferença entre as duas datas.\n", Data2.diasDeDiferença(xpto, new Data2(tmp1, tmp2, tmp3)));
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

