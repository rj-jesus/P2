import java.util.Scanner;
import java.io.File;

public class ex0503 {
	static final Scanner sc = new Scanner(System.in);
	public static void main (String args[]) {
		File parent = null;
		try{
			parent = new File(args[0]);
		}
		catch(IndexOutOfBoundsException|NullPointerException e){
			System.out.print("Directório actual tomado por omissão.\n");
		}
		finally{
			if(parent == null) parent = new File(".");
		}
		String[] directories_files = null;
		try{
			directories_files = parent.list();
		}
		catch(SecurityException e){
			System.out.print("Ficheiro Protegido.");
		}
		finally{
			if(directories_files == null) System.exit(1);
		}
		for(int i = 0; i < directories_files.length; i++){
			File tmp = null;
			try{
				tmp = new File(directories_files[i]);
			}
			catch(NullPointerException e){
				throw e;
			}
			String[] attributes = {"", "", ""};
			if(tmp.isDirectory()) attributes[0] = "DIR";
			if(tmp.canRead() && !attributes[0].equals("")) attributes[1] = ", READ";
			else if(tmp.canRead()) attributes[1] = "READ";
			if(tmp.canWrite() && !attributes[1].equals("")) attributes[2] = ", WRITE";
			else if(tmp.canWrite()) attributes[2] = "WRITE";
			System.out.printf("\n%-20s(", directories_files[i]);
			for(int j = 0; j < attributes.length; j++) System.out.printf("%s", attributes[j]);
			System.out.print(")");
		}
		System.out.print("\n");
	}
}

