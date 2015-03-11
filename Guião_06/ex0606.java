import java.util.Scanner;

public class ex0606 {
	static final Scanner sc = new Scanner(System.in);
	public static void main (String args[]) {
		System.out.print("Montante: ");
		int amount = sc.nextInt();
		System.out.print("Taxa de Juro (%): ");
		amount += amount * sc.nextInt() / 100;
		System.out.print("Prestação: ");
		int permonth = sc.nextInt();
		System.out.print("Meses passados: ");
		int months = sc.nextInt();
		System.out.printf("Valor em dívida: %d", recursiveDn(amount, permonth, months));
	}
	public static int recursiveDn(int amount, int p, int n){
		return amount - p * n;
	}
}

