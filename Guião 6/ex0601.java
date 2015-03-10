import java.util.Scanner;

public class ex0601 {
	static final Scanner sc = new Scanner(System.in);
	public static void main (String args[]) {
		System.out.print("N: ");
		System.out.printf("%d\n", fibonacci(1000));
		for(long n = sc.nextLong(), i = 0; i <= n; i++) System.out.printf("%d\n", fibonacci(i)); 
	}
	public static long fibonacci(long n){
		assert n >= 0;
		if(n == 0) return 0;
		if(n == 1) return 1;
		return fibonacci(n - 2) + fibonacci(n - 1);
	}
}

