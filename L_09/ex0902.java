import java.util.Scanner;

public class ex0902 {
	static final Scanner sc = new Scanner(System.in);
	public static void main (String args[]) {
		System.out.print("Size of tower: ");
		int n = sc.nextInt();
		if(n < 0){
			System.err.print("Invalid size.\n");
			System.exit(1);
		}
		TorreDeHanói game = new TorreDeHanói(n);
		game.solveTowerOfHanoi();
	}
}

