import hashtableChaining.AssociativeArray;
import java.util.Scanner;
import java.io.File;
import java.io.IOException;

public class ex1103 {
	static final String file_name = "numbers.txt";
	static final Scanner sc = new Scanner(System.in);
	public static void main (String args[]) {
		AssociativeArray<Integer> list = new AssociativeArray(100);
		File f = new File(file_name);
		try{
			Scanner fsc = new Scanner(f);
			for(; fsc.hasNext(); ){
				int n = Integer.parseInt(fsc.next());
				fsc.next();
				list.set(fsc.next(), n);
			}
			fsc.close();
		}
		catch(IOException e){
			System.err.printf("Error: Couldn't parse %s.\n", file_name);
			System.exit(1);
		}
		for(; sc.hasNext(); ){
			String[] tmp = sc.next().split("-");
			for(int i = 0; i < tmp.length; i++){
				if(!list.exists(tmp[i])) System.out.printf("%s ", tmp[i]);
				else System.out.printf("%d ", list.get(tmp[i]));
			}
		}
		System.out.print("\n");
	}
}

