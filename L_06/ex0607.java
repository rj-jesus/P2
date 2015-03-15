import java.io.File;
import java.io.BufferedReader;		//For actual acceptable runtimes
import java.io.InputStreamReader;	//For actual acceptable runtimes

public class ex0607 {
	
	public static void main (String args[]) {
		if(args.length != 2) throw new AssertionError("Error: Invalid arguments.");
		File dir = new File(args[0]);
		String name = args[1];
		findFile_a(dir, name);
		findFile_b(dir, name);
		//findFile(dir, name);	//For shell execution time
	}
	public static void findFile_a(File f, String s){
		if(f == null || s == null) throw new AssertionError();
		if(f.isFile() && f.getName().equals(s)) System.out.printf("%s\n", f.getPath());
		if(f.isDirectory() && f.canRead()){
			File[] dirs = f.listFiles();
			for(File dir : dirs) findFile_a(dir, s);
		}
	}
	public static void findFile_b(File f, String s){
		if(f == null || s == null) throw new AssertionError();
		if(f.isFile() && f.getName().indexOf(s) != -1) System.out.printf("%s\n", f.getPath());
		if(f.isDirectory() && f.canRead()){
			File[] dirs = f.listFiles();
			for(int i = 0; i < dirs.length; i++) findFile_b(dirs[i], s);
		}
	}
	
	public static void findFile(File f, String s){
		if(f == null || s == null) throw new AssertionError();
		Process sh;
		StringBuffer output = new StringBuffer();
		try{
			sh = Runtime.getRuntime().exec("find " + f.getPath() + " -iname " + s);
			sh.waitFor();
			BufferedReader read = new BufferedReader(new InputStreamReader(sh.getInputStream()));
			for(String line; (line = read.readLine()) != null; ) output.append(line + "\n");
		}
		catch(Exception e){
			System.err.print("Error: There was a problem executing shell command.");
		}
		System.out.print(output.toString());
	}
}

