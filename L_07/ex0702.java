public class ex0702 {
	
	public static void main (String args[]) {
		int a = -1, b = -1;
		try{
			a = Integer.parseInt(args[0]);
			b = Integer.parseInt(args[1]);
		}
		catch(NullPointerException|NumberFormatException e){
			System.out.print("Error: Usage: java ex0701 <a> <b>\n");
			System.exit(1);
		}
		finally{
			if(a < 0 || b < 0){
				System.out.print("Error: Invalid arguments.\n");
				System.exit(2);
			}
		}
		System.out.printf("Máximo divisor comum entre %d e %d: %d\n", a, b, mdc(a, b));
	}
	public static int mdc(int a, int b){
		if(a < 0 || b < 0) throw new AssertionError("Error: Invalid arguments.");
		int to_return = -1;
		if(b == 0) to_return = a;
		else to_return = mdc(b, a % b);
		if(to_return == -1) throw new AssertionError();
		return to_return;
	}
}

