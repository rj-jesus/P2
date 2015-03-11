public class ex0702 {
	
	public static void main (String args[]) {
		int a = -1, b = -1;
		try{
			a = Integer.parseInt(args[0]);
			b = Integer.parseInt(args[1]);
		}
		catch(NullPointerException|NumberFormatException e){
			System.out.print("ERRO: Utilização: java ex0701 <a> <b>\n");
			System.exit(1);
		}
		finally{
			if(a < 0 || b < 0){
				System.out.print("ERRO: Paramêtros inválidos.\n");
				System.exit(1);
			}
		}
		System.out.printf("Máximo divisor comum entre %d e %d: %d\n", a, b, mdc(a, b));
	}
	public static int mdc(int a, int b){
		if(a < 0 || b < 0){
			System.out.print("ERRO: Paramêtros inválidos.");
			throw new AssertionError();
		}
		int to_return = -1;
		if(b == 0) to_return = a;
		else to_return = mdc(b, a % b);
		if(to_return == -1) throw new AssertionError();
		return to_return;
	}
}

