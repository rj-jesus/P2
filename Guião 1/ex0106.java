import java.util.Scanner;
import java.util.Random;

public class ex0106 {
	static final Scanner sc = new Scanner(System.in);
	public static void main (String args[]) {
		Random rand = new Random();
		int random = rand.nextInt(100);
		int tent = -1, counter = 0;
		for(; tent != random; counter++){
			System.out.print("Tentativa: ");
			tent = numInRange();
			if(tent < random) System.out.printf("%d é menor que o resultado.\n", tent);
			else if(tent > random) System.out.printf("%d é maior que o resultado.\n", tent);
		}
		System.out.printf("Parabéns! Acabou o jogo em %d tentativa(s)!", counter);
	}
	public static int numInRange(){
		int x = -1;
		for(; x > 100 || x < 0; ) x = sc.nextInt();
		return x;
	}
}

