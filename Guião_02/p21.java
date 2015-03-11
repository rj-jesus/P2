import java.util.Scanner;
/*************************************************************************
 * Compilation: javac j21.java 
 * Execution: java j21
 *************************************************************************/

public class p21 {
	static final Scanner sc = new Scanner(System.in);
	// Exemplo simples de utilização da class Complexo
	public static void main(String[] args) {
		double re, im;
		if(args != null && args.length >= 2){
			re = Double.parseDouble(args[0]);
			im = Double.parseDouble(args[1]);
		}
		else{
			System.out.print("Re: ");
			re = sc.nextDouble();
			System.out.print("Im: ");
			im = sc.nextDouble();
		}
		Complexo a = new Complexo(re, im);

		// Vamos usar métodos de 'a'
		System.out.println("(" + a.real() + " + " + a.imag() + "i)");
		System.out.println("  parte real = " + a.real());
		System.out.println("  parte imaginaria = " + a.imag());
		System.out.println("  modulo = " + a.abs());
		System.out.printf("  fase   =  %2.2f\n", a.phase());
	}

}
