import java.util.Scanner;

public class ex0102 {
	static final Scanner sc = new Scanner(System.in);
	public static void main (String args[]) {
		double result = 0;
		System.out.print("Avaliação Intercalar Teórico-Prática 1: ");
		result += 0.15 * sc.nextDouble();
		System.out.print("Avaliação Intercalar Prática: ");
		result += 0.2 * sc.nextDouble();
		System.out.print("Avaliação Intercalar Teórico-Prática 2: ");
		result += 0.15 * sc.nextDouble();
		System.out.print("Avaliação Prática Final: ");
		result += 0.5 * sc.nextDouble();
		System.out.printf("Nota Final: %.2f", result);
	}
}

