import java.util.Scanner;
import java.io.*;

public class ex0107 {
	static final Scanner sc = new Scanner(System.in);
	public static void main (String args[]) throws IOException{
		if(args == null || args.length < 2 || args[0] == null || args[1] == null){
			System.err.print("Nomes inválidos.\n");
			System.exit(1);
		}
		File input = new File(args[0]);
		File output = new File(args[1]);
		if(!argsCheck(input, output)) System.exit(1);
		Scanner sf = new Scanner(input);
		PrintWriter pf = new PrintWriter(output, "UTF-8");
		for(; sf.hasNextLine(); ) pf.printf("%s\n", sf.nextLine());
		sf.close();
		pf.close();
		System.out.print("Copia terminada.\n");
	}
	public static boolean argsCheck(File in, File out){
		if(!in.exists()){
			System.out.print("Ficheiro de destino não existe.\n");
			return false;
		}
		if(!in.isFile()){
			System.out.print("Ficheiro de origem não é um ficheiro.\n");
			return false;
		}
		if(!in.canRead()){
			System.out.print("Ficheiro de origem não é legível.\n");
			return false;
		}
		if(out.exists()){
			if(!out.isFile()){
				System.out.print("Ficheiro de destino não é um ficheiro.\n");
				return false;
			}
			if(!out.canRead()){
				System.out.print("Ficheiro de destino não é legível.\n");
				return false;
			}
			System.out.print("Ficheiro de destino já existe. Pretende reescrevê-lo (Y/N)? ");
			char tmp = sc.nextLine().charAt(0);
			for(; tmp != 'Y' && tmp != 'y' && tmp != 'N' && tmp != 'n'; ){
				System.out.print("Caracter inválido (Y/N): ");
				tmp = sc.nextLine().charAt(0);
			}
			if(tmp == 'N' || tmp == 'n') return false;
		}
		return true;
	}
}

