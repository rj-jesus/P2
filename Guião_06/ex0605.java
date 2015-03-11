import java.io.File;

public class ex0605 {
	
	public static void main (String args[]) {
		File f = null;
		try{
			f = new File(args[0]);
		}
		catch(NullPointerException e){
			System.out.print("ERRO: Argumentos inválidos.");
			System.exit(1);
		}
		finally{
			if(f == null || !f.exists() || !f.canRead()){
				System.out.print("ERRO: Argumentos inválidos.");
				System.exit(1);
			}
		}
		printChain(f);
	}
	public static void printChain(File a){
		assert a != null && a.exists() && a.canRead();
		System.out.printf("%s\n", a.getPath());
		if(a.isDirectory() && a.canRead()){
			File[] b = a.listFiles();
			for(int i = 0; i < b.length; i++) printChain(b[i]);
		}
	}
}

