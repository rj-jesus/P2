import java.util.Scanner;
import java.io.*;

public class ex0107 {
	static final Scanner sc = new Scanner(System.in);
	public static void main (String args[]) throws IOException{
		if(args.length != 2){
			System.err.print("Error: Invalid files!\n");
			System.exit(1);
		}
		File input = new File(args[0]);
		File output = new File(args[1]);
		if(!argsCheck(input, output)) System.exit(2);
		Scanner sf = new Scanner(input);
		PrintWriter pf = new PrintWriter(output, "UTF-8");
		for(; sf.hasNextLine(); ) pf.printf("%s\n", sf.nextLine());
		sf.close();
		pf.close();
	}
	public static boolean argsCheck(File in, File out){
		if(!in.exists()){
			System.out.print("Error: Input file doesn't exist!\n");
			return false;
		}
		if(!in.isFile()){
			System.out.print("Error: Input is not a file!\n");
			return false;
		}
		if(!in.canRead()){
			System.out.print("Error: Can't read input file!\n");
			return false;
		}
		if(out.exists()){
			if(!out.isFile()){
				System.out.print("Error: Output is not a file!\n");
				return false;
			}
			if(!out.canWrite()){
				System.out.print("Error: Can't write to output file!\n");
				return false;
			}
			System.out.print("Ouput file already exists. Do you want to overwrite? (Y/N) ");
			char tmp = Character.toLowerCase(sc.nextLine().charAt(0));
			for(; tmp != 'y' && tmp != 'n'; ){
				System.out.print("Invalid character. (Y/N): ");
				tmp = Character.toLowerCase(sc.nextLine().charAt(0));
			}
			if(tmp == 'n') return false;
		}
		return true;
	}
}

