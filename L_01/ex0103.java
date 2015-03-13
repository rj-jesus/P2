import java.util.Scanner;

public class ex0103 {
	static final Scanner sc = new Scanner(System.in);
	public static void main (String args[]) {
		int num = -1;
		for(; num < 0; ){
			System.out.print("Número: ");
			num = sc.nextInt();
		}
		if(num == 0){
			System.out.printf("%d é primo (nem composto).\n", num);
			System.exit(0);
		}
		int counter = 0;
		for(int i = 1; i <= Math.sqrt(num); i++){
			if(num % i == 0) counter++;
		}
		if(counter == 1) System.out.printf("%d é primo.\n", num);
		else System.out.printf("%d não é primo.\n", num);
	}
}

