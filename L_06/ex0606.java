import java.util.Scanner;

public class ex0606 {
	static final Scanner sc = new Scanner(System.in);
	public static void main (String args[]) {
		System.out.print("Montante: ");
		int amount = sc.nextInt();
		System.out.print("Taxa de Juro (%): ");
		amount += amount * sc.nextInt() / 100;
		System.out.print("Prestação (por mês): ");
		int permonth = sc.nextInt();
		System.out.print("Meses passados: ");
		int months = sc.nextInt();
		System.out.printf("Valor em dívida: %.2f\n", recursiveDn(amount, permonth, months));
	}
	public static double recursiveDn(int amount, int p, int n){
		double missing = amount - p * n;
		if(missing <= 0) return 0;
		return missing;
	}
}

