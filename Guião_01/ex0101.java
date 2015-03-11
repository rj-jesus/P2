import java.util.Scanner;

public class ex0101 {
	static final Scanner sc = new Scanner(System.in);
	public static void main (String args[]) {
		String[] terms1 = sc.nextLine().split(" ");
		String[] terms2 = null;
		String[] terms3 = null;
		if(terms1.length < 3){
			terms2 = sc.nextLine().split(" ");
		}
		if(terms2 != null && (terms1.length + terms2.length) < 3){
			terms3 = sc.nextLine().split(" ");
		}
		double x = Double.parseDouble(terms1[0]);
		char operation = ' ';
		if(terms1.length > 1){
			if(terms1[1].length() == 1) operation = terms1[1].charAt(0);
			else System.err.printf("Not a valid operation.");
		}
		else{
			if(terms2[0].length() == 1) operation = terms2[0].charAt(0);
			else System.err.printf("Not a valid operation.");
		}
		double y;
		if(terms1.length > 2) y = Double.parseDouble(terms1[2]);
		else if(terms2.length > 1) y = Double.parseDouble(terms2[1]);
		else y = Double.parseDouble(terms3[0]);
		switch(operation){
			case '+': System.out.printf(" = %.2f", x + y); break;
			case '-': System.out.printf(" = %.2f", x - y); break;
			case '*': System.out.printf(" = %.2f", x * y); break;
			case '/': System.out.printf(" = %.2f", x / y); break;
		}
	}
}

