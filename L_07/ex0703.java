import java.util.Scanner;
import java.util.Random;

public class ex0703 {
	static final Scanner sc = new Scanner(System.in);
	public static void main (String args[]) {
		if(iGuessIt(Integer.MIN_VALUE, Integer.MAX_VALUE)){
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
		int attempt = randInt(min, max);
		System.out.printf("Let's see... %d?\n", attempt);
		boolean result = false;
		switch(getFeedback()){
			case 0:
				System.out.print("I'm sorry I couldn't find it...");
				result = false;
				break;
			case 1:
				System.out.print("Wow! I knew I could do it!");
				result = true;
				break;
			case 2:
				result = iGuessIt(attempt, max);
				break;
			case 3:
				result = iGuessIt(min, attempt);
				break;
			default:
				System.err.print("Sorry, I think I had some malfunction... It's better to just stop.");
				System.exit(-1);
		}
		return result;
	}
	private static int randInt(int min, int max){
		if(min > max) throw new AssertionError("Error: Invalid range.");
		Random rand = new Random();
		int dif = max - min, result = 0;
		if(dif >= 0 && dif != Integer.MAX_VALUE) result = min + rand.nextInt(dif);
		else for(; result <= min || result >= max; ) result = rand.nextInt();
		return result;
	}
}
