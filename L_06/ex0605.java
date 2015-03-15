import java.io.File;

public class ex0605 {
	
	public static void main (String args[]) {
		File f = null;
		try{
			f = new File(args[0]);
		}
		catch(ArrayIndexOutOfBoundsException e){
			System.out.print("> Notice: Current directory was used by default.\n");
			f = new File(".");
		}
		finally{
			if(f == null || !f.exists() || !f.canRead()){
				System.err.print("Error: Can't iterate through directory.\n");
				System.exit(1);
			}
		}
		printChain(f);
	}
	public static void printChain(File a){
		assert a != null && a.exists() && a.canRead();
		System.out.printf("%s\n", a.getPath());
		if(a.isDirectory() && a.canRead()){
			File[] dir_list = a.listFiles();
			for(File dir : dir_list) printChain(dir);
		}
	}
}

