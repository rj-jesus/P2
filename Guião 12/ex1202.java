public class ex1202 {
	
	public static void main (String args[]) {
		ExpressionTree expression = new ExpressionTree();
		expression.printInfix();
		System.out.print(" = ");
		System.out.printf("%.1f\n", expression.eval());
	}
}

