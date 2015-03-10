import hashtableChaining.AssociativeArray;
import java.util.Scanner;
import java.io.File;
import java.io.PrintWriter;
import java.io.FileNotFoundException;
import java.io.UnsupportedEncodingException;

public class ex1102 {
	
	public static void main (String args[]) {
		File f = null;
		try{
			f = new File(args[0]);
		}
		catch(NullPointerException e){
			System.out.print("Usage: java ex1102 <file_name>\n");
			System.exit(1);
		}
		Scanner fsc = null;
		try{
			fsc = new Scanner(f);
		}
		catch(FileNotFoundException e){
			System.out.print("File not found.\n");
			System.exit(2);
		}
		int c = 0;
		for(; fsc.hasNext(); c++) fsc.next();
		try{
			fsc = new Scanner(f);
		}
		catch(FileNotFoundException e){
			System.out.print("File not found.\n");
			System.exit(2);
		}
		AssociativeArray<Integer> list = new AssociativeArray(c);
		for(; fsc.hasNext(); ){
			String tmp = fsc.next();
			if(list.exists(tmp)) list.set(tmp, list.get(tmp)+1);
			else list.set(tmp, 1);
		}
		fsc.close();
		String[] keys = list.keysToArray();
		PrintWriter fp = null;
		try{
			fp = new PrintWriter("Histograma.txt", "UTF-8");
		}
		catch(FileNotFoundException|UnsupportedEncodingException e){
			System.out.print("UTF-8 encoding not supported.\n");
			System.exit(1);
		}
		for(int i = 0; i < keys.length; i++){
			int valueAt = list.get(keys[i]);
			fp.printf("%s %d\n", keys[i], valueAt);
			System.out.printf("%s %d\n", keys[i], valueAt);
		}
		fp.close();
	}
}

