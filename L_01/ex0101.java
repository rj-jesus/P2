import java.util.Scanner;

public class ex0101 {
	static final Scanner sc = new Scanner(System.in);
	public static void main (String args[]) {
		System.out.println(args[1]);
		if(args.length != 3){
			System.err.printf("Notice: If you tried to run *, be sure to use '*' (exactly writen like that) or 'x'.\n");
			throw new AssertionError("\nError: Usage: java ex0101.java <n1> <op> <n2>");
		}
		double p1 = 0, p2 = 0;
		char op = ' ';
		try{
			p1 = Double.parseDouble(args[0]);
			op = args[1].charAt(0);
			p2 = Double.parseDouble(args[2]);
		}
		catch(NumberFormatException e){
			System.err.printf("\nError: Impossible to parse numbers. Check your input.");
			System.exit(1);
		}
		switch(op){
			case '+': System.out.printf(" = %.2f\n", p1 + p2); break;
			case '-': System.out.printf(" = %.2f\n", p1 - p2); break;
			case '*': case 'x': System.out.printf(" = %.2f\n", p1 * p2); break;
			case '/': 
				if(p2 == 0) throw new AssertionError("\nError: Dividing by zero!");
				System.out.printf(" = %.2f\n", p1 / p2); break;
			default: System.err.printf("Error: Operation not supported.\n");
		}
	}
}

