public class ex0901 {
	
	public static void main (String args[]) {
		if(args.length < 1){
			System.out.print("Usage: java ex0901 <String>\n");
			System.exit(1);
		}
		String text = new String();
		for(int i = 0; i < args.length; i++){
			System.out.printf("%s ", args[i]);
			text += args[i];
		}
		ex0901Stack stack = new ex0901Stack(text);
		ex0901Pile pile = new ex0901Pile(text);
		for(int i = 0; i < text.length(); i++){
			if(Character.isLetter(text.charAt(i)) || Character.isDigit(text.charAt(i))){
				stack.push(Character.toLowerCase(text.charAt(i)));
				pile.in(Character.toLowerCase(text.charAt(i)));
			}
		}
		boolean is_palindrome = true;
		for(; is_palindrome && stack.size() > 0; ){
			if(stack.top() != pile.peek()) is_palindrome = false;
			stack.pop();
			pile.out();
		}
		System.out.print("is");
		if(!is_palindrome) System.out.print(" not");
		System.out.print(" a palindrome.\n");
	}
}

