public class Stack_0901 {
	private char[] letters = null;
	private int index = -1;
	
	public ex0901Stack(String text){
		if(text == null) throw new AssertionError();
		letters = new char[countArraySize(text)];
		index = 0;
	}
	private int countArraySize(String text){
		int size = 0;
		for(int i = 0; i < text.length(); i++) if(Character.isLetter(text.charAt(i)) || Character.isDigit(text.charAt(i))) size++;
		return size;
	}
	public void push(char a){
		letters[index++] = a;
	}
	public void pop(){
		index--;
	}
	public char top(){
		return letters[index-1];
	}
	public boolean isEmpty(){
		return index == 0;
	}
	public boolean isFull(){
		return index == letters.length;
	}
	public int size(){
		return index;
	}
	public void clear(){
		index = 0;
	}
}

