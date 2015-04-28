import java.util.Scanner;
import java.io.InputStream;

public class ExpressionTree {
	Node root;
	Stack t = new Stack();
	
	public void createPostfix(InputStream obj){
	    Scanner sc = new Scanner(obj);
		for(; sc.hasNext(); ) createStack(sc.next());
		root = t.head();
	}
	private void createStack(String n){
		try{
			double value = Double.parseDouble(n);
			Node node = new Node();
			node.value = value;
			t.push(node);
		}
		catch(NumberFormatException e){
			if(isOperation(n.charAt(0))){
				Node n2 = t.pull();
				Node n1 = t.pull();
				Node node = new Node();
				node.op = n.charAt(0);
				node.left = n1;
				node.right = n2;
				t.push(node);
			}
			else{
				System.err.printf("ERROR: Invalid operation: %c.\n", n.charAt(0));
				System.exit(1);
			}
		}
	}
	public double eval(){
		return eval(root);
	}
	private double eval(Node n){
		if(n == null) throw new AssertionError("ERROR: Invalid arguments.\n");
		double result = 0;
		if(!isOperation(n.op)) result = n.value;
		else{
			double left, right;
			char op = n.op;
			left = eval(n.left);
			right = eval(n.right);
			switch(op){
				case '+': result = left + right; break;
				case '-': result = left - right; break;
				case '*': result = left * right; break;
				case '/': result = left / right; break;
			}
		}
		return result;
	}
	private boolean isOperation(char n){
		return n == '+' || n == '-' || n == '*' || n == '/';
	}
	public void printInfix(){
		printInfix(root);
		System.out.print("\n");
	}
	private void printInfix(Node n){
		if(n == null) throw new AssertionError("ERROR: Invalid arguments.\n");
		if(isOperation(n.op)) System.out.print("(");
		if(n.left != null) printInfix(n.left);
		if(n.op == 'e') System.out.printf("%.2f", n.value);
		else System.out.printf(" %c ", n.op);
		if(n.right != null) printInfix(n.right);
		if(isOperation(n.op)) System.out.print(")");
	}
	private class Stack{
		StackNode t;
		int size = 0;
		
		private void push(Node n){
			if(t == null){
				t = new StackNode();
				t.node = n;
			}
			else{
				StackNode tmp = new StackNode();
				tmp.node = n;
				tmp.next = t;
				t = tmp;
			}
			size++;
		}
		private Node pull(){
			if(size == 0){
				System.err.print("ERROR: Invalid arguments.\n");
				System.exit(1);
			}
			Node n = t.node;
			t = t.next;
			size--;
			return n;
		}
		private Node head(){
			return t.node;
		}
		private class StackNode{
			Node node;
			StackNode next;
		}
	}
	private class Node{
		double value;
		char op = 'e';
		Node left, right;
	}
}

