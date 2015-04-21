import hashtableChaining.AssociativeArray;
import java.util.Scanner;
import java.io.File;
import java.io.IOException;

public class ex1104 {
	static final String file_name = "numbers.txt";
	static final Scanner sc = new Scanner(System.in);
	public static void main (String args[]) {
		AssociativeArray<Integer> list = new AssociativeArray(100);
		File f = new File(file_name);
		try{
			Scanner fsc = new Scanner(f);
			for(; fsc.hasNextLine(); ){
				String[] line = fsc.nextLine().split(" ");
				list.set(line[2], Integer.parseInt(line[0]));
			}
			fsc.close();
		}
		catch(IOException e){
			System.err.printf("Error: Couldn't parse %s.\n", file_name);
			System.exit(1);
		}
		long total = 0, last_unit = 0;
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

