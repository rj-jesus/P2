import java.util.Scanner;
import java.io.*;

public class ex0505 {
	
	public static void main (String args[]) {
		int column = 0;
		Scanner fsc = null;
		try{
			fsc = new Scanner(new File(args[0]));
			column = Integer.parseInt(args[1]) - 1;
		}
		catch(NullPointerException|IndexOutOfBoundsException|NumberFormatException|IOException e){
			System.out.print("ERRO: Argumentos Inválidos.");
		}
		finally{
			if(fsc == null){
				System.err.print("Error: Couldn't parse arguments, no point in continuing execution. Aborting...\n");
				System.exit(1);
			}
		}
		String tmp = "";
		for(; fsc.hasNextLine(); ) tmp += fsc.nextLine() + "\n";
		String[] lines = tmp.split("\n");
		for(int i = 0; i < lines.length; i++){
			fsc = new Scanner(lines[i]);
			for(int j = 0; fsc.hasNext(); j++){
				tmp = fsc.next();
				if(j == column) System.out.printf("%s", tmp);
			}
			System.out.print("\n");
		}
		fsc.close();
	}
}

