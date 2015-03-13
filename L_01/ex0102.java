import java.util.Scanner;

public class ex0102 {
	static final Scanner sc = new Scanner(System.in);
	public static void main (String args[]) {
		double result = 0;
		System.out.print("Avaliação Intercalar Teórico-Prática 1: ");
		result += 0.15 * getInRange(0, 20);
		System.out.print("Avaliação Intercalar Prática: ");
		result += 0.2 * getInRange(0, 20);
		System.out.print("Avaliação Intercalar Teórico-Prática 2: ");
		result += 0.15 * getInRange(0, 20);
		System.out.print("Avaliação Prática Final: ");
		result += 0.5 * getInRange(0, 20);
		System.out.printf("Nota Final: %.2f\n", result);
		if(result < 9.5) System.out.print("Reprovado.\n");
		else System.out.print("Aprovado.\n");
	}
	public static double getInRange(double min, double max){
		for(double x; ; ){
			x = sc.nextDouble();
			if(x >= min && x <= max) return x;
		}
	}
}

