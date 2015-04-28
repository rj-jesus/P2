import java.util.Scanner;
import java.io.InputStream;
import java.util.NoSuchElementException;

public class ExpressionTree{
	private Node root;
	
	public ExpressionTree(InputStream obj){
		root = createPrefix(new Scanner(obj));
	}
	private Node createPrefix(Scanner sc){
		Node node = null;
		if(sc.hasNextDouble()) node = new Node(sc.nextDouble(), '0');
		else{
			try{
				char tmp = sc.next().charAt(0);
				if(!isOperation(tmp)){
					System.err.print("Error: Unrecognized operation found.\n");
					System.exit(2);
				}
				node = new Node(0, tmp);
			}
			catch(NoSuchElementException e){
				System.err.print("Error: Invalid prefix expression!\n");
				System.exit(1);
			}
			node.left = createPrefix(sc);
			node.right = createPrefix(sc);
		}
		return node;
	}
	public void printInfix(){
		printInfix(root);
	}
	public void printInfix(Node node){
		if(node != null){
			if(!isLeaf(node)) System.out.print("(");
			printInfix(node.left);
			if(isOperation(node.op)) System.out.print(node.op);
			else System.out.print(node.value);
			printInfix(node.right);
			if(!isLeaf(node)) System.out.print(")");
		}
	}
	private boolean isLeaf(Node node){
		return node.left == null && node.right == null;
	}
	public double eval(){
		return eval(root);
	}
	private double eval(Node node){
		double result = 0;
		if(isLeaf(node)) result = node.value;
		else{
			double left, right;
			char op = node.op;
			left = eval(node.left);
			right = eval(node.right);
			switch(op){
				case '+': result = left + right; break;
				case '-': result = left - right; break;
				case '*': result = left * right; break;
				case '/': result = left / right; break;
				default: System.err.print("Error: Unrecognized operation found.\n"); System.exit(2);
			}
		}
		return result;
	}
	private static boolean isOperation(char test){
		switch(test){
			case '+': case '-': case '*': case '/': return true;
			default: return false;
		}
	}
	private class Node{
		double value;
		char op;
		Node left, right;
		
		private Node(double value, char operation){
			this.value = value;
			this.op = operation;
		}
	}
}

