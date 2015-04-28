import java.util.Scanner;

public class ex1202 {
	
	public static void main (String args[]) {
		ExpressionTree t = new ExpressionTree();
		t.createPostfix(System.in);
		t.printInfix();
		System.out.printf(" = %.2f\n", t.eval());
	}
}

