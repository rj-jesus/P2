import java.util.Scanner;

public class ex0903 {
	static final Scanner sc = new Scanner(System.in);
	public static void main (String args[]) {
		Stack<Double> stack = new Stack<Double>();
		for(; sc.hasNext(); ){
			String n = sc.next();
			if(Character.isDigit(n.charAt(0))) stack.push(Double.parseDouble(n));
			else{
				double p1, p2;
				switch(n.charAt(0)){
					case '+':
						p1 = stack.top();
						stack.pop();
						p2 = stack.top();
						stack.pop();
						stack.push(p1+p2);
						break;
					case '-':
						p1 = stack.top();
						stack.pop();
						p2 = stack.top();
						stack.pop();
						stack.push(p1-p2);
						break;
					case '*':
						p1 = stack.top();
						stack.pop();
						p2 = stack.top();
						stack.pop();
						stack.push(p1*p2);
						break;
					case '/':
						p1 = stack.top();
						stack.pop();
						p2 = stack.top();
						stack.pop();
						stack.push(p1/p2);
						break;
					default:
						System.out.print("Error: Invalid arguments.");
						System.exit(1);
				}
			}
			System.out.print("Stack: ");
			stack.print();
			System.out.print("\n");
		}
	}
}

