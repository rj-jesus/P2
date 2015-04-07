public class ex0901 {
	
	public static void main (String args[]) {
		if(args.length < 1){
			System.out.print("Usage: java ex0901 <String>\n");
			System.exit(1);
		}
		String text = new String();
		for(int i = 0; i < args.length; text += args[i++]);
		Stack<Character> stack = new Stack<Character>();
		Queue<Character> queue = new Queue<Character>();
		for(int i = 0; i < text.length(); i++){
			if(Character.isLetter(text.charAt(i)) || Character.isDigit(text.charAt(i))){
				stack.push(Character.toLowerCase(text.charAt(i)));
				queue.in(Character.toLowerCase(text.charAt(i)));
			}
		}
		boolean is_palindrome = true;
		for(; is_palindrome && !stack.isEmpty(); ){
			is_palindrome = stack.top() == queue.peek();
			stack.pop();
			queue.out();
		}
		System.out.print(args[0] + " is");
		if(!is_palindrome) System.out.print(" not");
		System.out.print(" a palindrome.\n");
	}
}

