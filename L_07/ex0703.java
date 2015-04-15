import java.util.Scanner;

public class ex0703 {
	static final Scanner sc = new Scanner(System.in);
	public static void main (String args[]) {
		if(iGuessIt(0, 100)){
			System.out.print(" Congratz!\n");
		}
		else{
			System.out.print(" Too bad.\n");
		}
	}
	public static int getFeedback(){
		int n_options = 4, x = -1;
		for(; x < 0 || x > n_options; ){
			System.out.print(">>> ");
			x = sc.nextInt();
		}
		return x;
	}
	public static boolean iGuessIt(int min, int max){
		int attempt = min + (int)(Math.random()*(max-min));
		System.out.printf("Let's see... %d?\n", attempt);
		switch(getFeedback()){
			case 0:
				System.out.print("I'm sorry I couldn't find it...");
				return false;
			case 1:
				System.out.print("Wow! I knew I could do it!");
				break;
			case 2:
				iGuessIt(attempt, max);
				break;
			case 3:
				iGuessIt(min, attempt);
				break;
			default:
				System.err.print("Sorry, I think I had some malfunction... It's better to stop.");
				System.exit(-1);
		}
		return true;
	}
}
