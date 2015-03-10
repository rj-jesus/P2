import java.util.Scanner;

public class ex0104 {
	static final Scanner sc = new Scanner(System.in);
	public static void main (String args[]) {
		String line = null;
		for(int i = 1; i == 1 || !line.equals(""); i++){
			System.out.printf("Frase %d: ", i);
			line = sc.nextLine();
			String tmp = "";
			for(int j = 0; j < line.length(); j++){
				if(line.charAt(j) == 'r' || line.charAt(j) == 'R') continue;
				else{
					if(line.charAt(j) == 'l') tmp += 'u';
					else if(line.charAt(j) == 'L') tmp += 'U';
					else tmp += line.charAt(j);
				}
			}
			System.out.printf("-> %s\n", tmp);
		}
	}
}

