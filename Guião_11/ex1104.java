import hashtableChaining.AssociativeArray;
import java.util.Scanner;
import java.io.*;

public class ex1104 {
	static final String file_name = "numbers.txt";
	static final Scanner sc = new Scanner(System.in);
	public static void main (String args[]) throws IOException{
		File f = new File(file_name);
		int c = 0;
		Scanner fsc = null;
		try{
			fsc = new Scanner(f);
		}
		catch(IOException e){
			System.out.printf("Impossível abrir ficheiro %s.\n", file_name);
			System.exit(1);
		}
		for(; fsc.hasNext(); c++){
			fsc.next();
			fsc.next();
			fsc.next();
		}
		fsc = new Scanner(f);
		AssociativeArray<Integer> list = new AssociativeArray(c);
		for(; fsc.hasNext(); ){
			int n = Integer.parseInt(fsc.next());
			fsc.next();
			list.set(fsc.next(), n);
		}
		fsc.close();
		int total = 0, last_unit = 0;
		for(; sc.hasNext(); ){
			String[] tmp = sc.next().split("-");
			for(int i = 0; i < tmp.length; i++){
				System.out.printf("%s ", tmp[i]);
				if(list.exists(tmp[i])){
					int n = list.get(tmp[i]);
					if(n < 100 || n % 10 != 0){
						total += last_unit;
						last_unit = n;
					}
					else if(last_unit != 0 && n % 10 == 0) last_unit *= n;
				}
			}
		}
		System.out.printf("%d\n", total+last_unit);
	}
}

