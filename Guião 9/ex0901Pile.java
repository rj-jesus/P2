public class ex0901Pile {
	private char[] letters = null;
	private int head = -1, tail = -1, size = -1;
	
	public ex0901Pile(String text){
		if(text == null) throw new AssertionError();
		letters = new char[countArraySize(text)];
		tail = 0;
		head = 0;
		size = 0;
	}
	private int countArraySize(String text){
		int size = 0;
		for(int i = 0; i < text.length(); i++) if(Character.isLetter(text.charAt(i)) || Character.isDigit(text.charAt(i))) size++;
		return size;
	}
	public void in(char a){
		letters[tail++] = a;
		if(tail == letters.length) tail = 0;
		size++;
	}
	public void out(){
		head++;
		if(head == letters.length) head = 0;
		size--;
	}
	public char peek(){
		return letters[head];
	}
	public boolean isEmpty(){
		return size == 0;
	}
	public boolean isFull(){
		return size == letters.length;
	}
	public int size(){
		return size;
	}
	public void clear(){
		tail = 0;
		head = 0;
		size = 0;
	}
}

