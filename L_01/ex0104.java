import java.util.Scanner;

public class ex0104 {
	static final Scanner sc = new Scanner(System.in);
	public static void main (String args[]) {
		String line = " ";
		for(; !line.equals(""); ){
			System.out.print("-> ");
			line = sc.nextLine();
			for(int j = 0; j < line.length(); j++){
				if(line.charAt(j) == 'r' || line.charAt(j) == 'R') continue;
				else if(line.charAt(j) == 'l') System.out.print('u');
				else if(line.charAt(j) == 'L') System.out.print('U');
				else System.out.print(line.charAt(j));
			}
			System.out.print("\n");
		}
	}
}

