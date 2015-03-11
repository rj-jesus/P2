import java.util.Scanner;
import pt.ua.prog.Caixa;

public class ex0305 {
	static final Scanner sc = new Scanner(System.in);
	public static void main (String args[]) {
		Caixa caixa = new Caixa();
		for(long x, i = 0; ; i++){
			switch(menu(i)){
				case 1:
					System.out.print("Dinheiro a adiconar (em cêntimos): ");
					x = sc.nextLong();
					sc.nextLine();
					caixa.addCoins(x);
					break;
				case 2:
					System.out.print("Dinheiro a retirar (em cêntimos): ");
					x = sc.nextLong();
					sc.nextLine();
					caixa.print(caixa.takeMoney(x));
					break;
				case 3:
					caixa.print();
					break;
				case 4:
					System.out.printf("Total: %.2f euros.\n", (double)caixa.total() / 100);
					break;
				case 0:
					System.exit(0);
			}
		}
	}
	public static int menu(long i){
		int x = -1;
		for(; x < 0 || x > 4; ){
			if(i == 0) System.out.print("1. Adicionar moedas\n");
			else System.out.print("\n1. Adicionar moedas\n");
			System.out.print("2. Retirar dinheiro\n");
			System.out.print("3. Ver moedas na carteira\n");
			System.out.print("4. Ver total da carteira\n");
			System.out.print("0. Termina\n");
			System.out.print("\nOpção: ");
			x = sc.nextInt();
		}
		sc.nextLine();
		return x;
	}
}

