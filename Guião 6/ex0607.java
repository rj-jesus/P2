import java.io.File;

public class ex0607 {
	
	public static void main (String args[]) {
		if(args.length != 2) throw new AssertionError();
		File f = new File(args[0]);
		String name = args[1];
		findFile_a(f, name);
		findFile_b(f, name);
	}
	public static void findFile_a(File f, String s){
		if(f == null || s == null) throw new AssertionError();
		if(f.isFile() && f.getName().equals(s)) System.out.printf("%s\n", f.getPath());
		if(f.isDirectory() && f.canRead()){
			File[] b = f.listFiles();
			for(int i = 0; i < b.length; i++) findFile_a(b[i], s);
		}
	}
	public static void findFile_b(File f, String s){
		if(f == null || s == null) throw new AssertionError();
		if(f.isFile() && f.getName().indexOf(s) != -1) System.out.printf("%s\n", f.getPath());
		if(f.isDirectory() && f.canRead()){
			File[] b = f.listFiles();
			for(int i = 0; i < b.length; i++) findFile_b(b[i], s);
		}
	}
}

