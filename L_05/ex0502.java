import java.util.Scanner;
import java.io.*;

public class ex0502 {
	static final Scanner sc = new Scanner(System.in);
	public static void main (String args[]) {
		File input = null, output = null;
		try{
			input = new File(args[0]);
			output = new File(args[1]);
		}
		catch(IndexOutOfBoundsException|NullPointerException e){
			System.out.print("ERRO: Argumentos inválidos.\n");
		}
		Scanner fsc = null;
		if(inputCkeck(input)){
			try{
				fsc = new Scanner(input);
			}
			catch(FileNotFoundException e){
				System.out.print("ERRO: Ficheiro para cópia inexistente.\n");
			}
			finally{
				if(fsc == null) System.exit(1);
			}
		}
		else{
			System.out.print("ERRO: Ficheiro inválido.\n");
			System.exit(1);
		}
		PrintWriter fpw = null;
		if(output.exists() && output.canWrite()){
			System.out.print("Ficheiro de destino já existente.\nPretende escrever por cima? (Y/N): ");
			switch(sc.nextLine().charAt(0)){
				case 'y': case 'Y':
					try{
						fpw = new PrintWriter(output);
					}
					catch(IOException e){
						System.out.print("ERRO: Ficheiro inválido.\n");
					}
					finally{
						if(fpw == null) System.exit(2);
					}
					break;
				case 'n': case 'N': System.exit(0);
			}
		}
		else if(output.exists() && !output.canWrite()){
			System.err.print("Error: Output file exists but it's not writable.");
			System.exit(2);
		}
		else{
			try{
				fpw = new PrintWriter(output);
			}
			catch(IOException e){
				System.out.print("ERRO: Ficheiro inválido.\n");
			}
			finally{
				if(fpw == null) System.exit(2);
			}
		}
		for(; fsc.hasNextLine(); ){
			fpw.printf("%s\n", fsc.nextLine());
		}
		fsc.close();
		fpw.close();
		System.out.print("Cópia terminada.\n");
	}
	public static boolean inputCkeck(File a){
		return a.isFile() && a.canRead();
	}
}

