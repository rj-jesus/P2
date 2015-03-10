import java.util.Scanner;

public class ex0105 {
	static final Scanner sc = new Scanner(System.in);
	public static void main (String args[]) {
		double result = 0;
		int counter = -1;
		for(double tmp = 0; counter == -1 || tmp != 0; counter++){
			tmp = sc.nextDouble();
			result += tmp;
		}
		if(counter != 0) System.out.printf("Soma: %.2f. Média: %.2f.", result, result / counter);
		else System.out.printf("Soma: %.2f.", result);
	}
}

