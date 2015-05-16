import static java.lang.System.*;

public class AllDivisors
{
	public static void main(String[] args){
		int n = 0;
		try{
			n = Integer.parseInt(args[0]);
		}
		catch(NumberFormatException|IndexOutOfBoundsException e){
			System.err.print("Error: Impossible to parse.");
			System.exit(1);
		}
		all_divisors(n, "");
	}
	public static void all_divisors(int n, String indent_step){
		assert n > 0: "Error: N must be a natural number.";
		System.out.printf(indent_step + "%d\n", n);
		for(int i = n - 1; i > 1; i--){
			if(n % i == 0) all_divisors(i, indent_step + "  ");
		}
	}
}

