import hashtableChaining.AssociativeArray;
import java.util.Scanner;
import java.io.File;
import java.io.PrintWriter;
import java.io.FileNotFoundException;

public class ex1102 {
	
	public static void main (String args[]) {
		AssociativeArray<Integer> words = new AssociativeArray(1000);
		File f = null;
		try{
			f = new File(args[0]);
		}
		catch(NullPointerException e){
			System.err.print("Usage: java ex1102 <file_name>\n");
			System.exit(1);
		}
		try{
			Scanner fsc = new Scanner(f);
			for(String tmp; fsc.hasNext(); ){
				tmp = fsc.next();
				words.set(tmp, words.exists(tmp) ? words.get(tmp)+1 : 1);
				// if(words.exists(tmp)) words.set(tmp, words.get(tmp)+1); // These also work.
				// else words.set(tmp, 1);								   // ^
			}
			fsc.close();
		}
		catch(FileNotFoundException e){
			System.err.print("Error: File not found.\n");
			System.exit(2);
		}
		String[] keys = words.keysToArray();
		try{
			PrintWriter fp = new PrintWriter("Histograma.txt", "UTF-8");
			for(String key : keys){
				int valueAt = words.get(key);
				fp.printf("%s ", key);
				for(int i = 0; i < valueAt; i++) fp.printf("*");
				fp.printf("\n");
			}
			fp.close();
		}
		catch(Exception e){
			System.err.print("Error: Couldn't save to file.\n");
			System.exit(3);
		}
	}
}

