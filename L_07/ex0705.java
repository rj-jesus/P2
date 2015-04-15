public class ex0705 {
	
	public static void main (String args[]) {
		double result = sqrt(2, 1.4, 0.0001);
		System.out.printf("%.5f", result);
	}
	public static double sqrt(double n, double inic, double e){
		assert inic >= 0 : "Error: Invalid initialization value.";
		if(n < 0) throw new AssertionError("Error: Please use isqrt for that.");
		return msqrt(n, inic, e);
	}
	public static String isqrt(double n, double inic, double e){
		assert inic >= 0 : "Error: Invalid initialization value.";
		String i = "";
		if(n < 0){
			i = "i";
			n *= -1;
		}
		return msqrt(n, inic, e) + i;
	}
	private static double msqrt(double n, double xo, double e){
		double x = (xo + n / xo) / 2;
		if(Math.abs(n - x*x) >= e) x = msqrt(n, x, e);
		return x;
	}
}

