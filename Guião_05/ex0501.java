import static java.lang.System.*;
import pt.ua.prog.GuessGame;
import java.util.Scanner;

public class ex0501 {
	static final Scanner sc = new Scanner(System.in);
	public static void main(String[] args) {
		int x = 0, y = 0;
		try{
			x = Integer.parseInt(args[0]);
			y = Integer.parseInt(args[1]);
		}
		catch(NumberFormatException|IndexOutOfBoundsException|NullPointerException e){
			out.print("ERRO: Valores ilegais. Foi definido o intervalo [0, 20] por omissão.\n");
			x = 0;
			y = 20;
		}
		GuessGame game = new GuessGame(x, y);
		String command = null;
		for(int counter = 1, attempt; ; counter++){
			command = menu(x, y, counter);
			switch(command){
				case "count":
					out.printf("\nNumber of attempts: %d\n", game.numAttempts());
					break;
				case "help":
					counter = 0;
					break;
				case "quit":
					out.print("\n");
					exit(0);
				default:
					try{
						attempt = Integer.parseInt(command);
					}
					catch(NumberFormatException e){
						System.err.print("Error: Can't parse attempt. Menu will be shown instead.");
						break;
					}
					if(game.validAttempt(attempt)) game.play(attempt);
					else{
						out.printf("\nERROR: invalid number: %d\n", attempt);
						break;
					}
					if(game.attemptIsLower()) out.printf("\nNumber is higher than %d\n", attempt);
					else if(game.attemptIsHigher()) out.printf("\nNumber is lower than %d\n", attempt);
					else if(game.finished()){
						out.printf("\n\nGame finished in %d attempts\n\n", game.numAttempts());
						exit(0);
					}
			}
		}
	}
	public static String menu(int x, int y, int counter){
		if(counter == 1){
			out.print("\nAvailable commands:");
			out.printf("\n  <number>   (new attempt to guess number in set [%d,%d])", x, y);
			out.print("\n  count      (show current number of attempts)");
			out.print("\n  help       (information on command usage)");
			out.print("\n  quit       (exits the program)\n");
			out.print("\ncommand: ");
		}
		else out.print("\ncommand: ");
		return sc.nextLine();
	}
}

