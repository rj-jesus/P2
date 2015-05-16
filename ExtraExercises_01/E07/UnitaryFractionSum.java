import static java.lang.System.*;

public class UnitaryFractionSum
{
	public static void main(String[] args){
		int n = 0;
		int d = 0;
		try{
			n = Integer.parseInt(args[0]);
			d = Integer.parseInt(args[1]);
		}
		catch(NumberFormatException|IndexOutOfBoundsException e){
			System.err.print("Error: Couldn't parse the arguments. Aborting.");
			System.exit(1);
		}
		String unitary = to_unitary_fractions(n, d);
		System.out.print(Integer.valueOf(n) + "/" + Integer.valueOf(d) + " = " + unitary.substring(0, unitary.length() - 2) + "\n");
	}
	public static String to_unitary_fractions(int n, int d){
		assert d != 0 && n / d > 0 && n / d < 1: "Error: N / D must be in ]0, 1[ and D mustn't equal 0.";
		if(n % d != 0){  // Actually n is not a divisor of b as said, but a multiple
			int d_unitary = (int) Math.ceil((double) d / n);
			return "1/" + Integer.valueOf(d_unitary) + " + " + to_unitary_fractions(n * d_unitary - d, d * d_unitary);
		}
		return "";
	}
}

