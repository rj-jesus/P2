import java.util.Scanner;

public class ex0103 {
	static final Scanner sc = new Scanner(System.in);
	public static void main (String args[]) {
		int num = 0;
		for(; num < 1; ){
			System.out.print("Número: ");
			num = sc.nextInt();
		}
		int counter = 0;
		for(int i = num; i > 1; i--){
			if(num % i == 0) counter++;
		}
		if(counter == 1) System.out.printf("%d é primo.", num);
		else System.out.printf("%d não é primo.", num);
	}
}

