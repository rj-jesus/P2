public class Stack_0902 {
	private int[] list = null;
	private int index;
	
	public Stack_0902(int size){
		if(size <= 0) throw new AssertionError();
		list = new int[size];
		index = 0;
	}
	public void push(int n){
		if(isFull()) throw new AssertionError();
		list[index++] = n;
		if(isEmpty()) throw new AssertionError();
	}
	public void pop(){
		if(isEmpty()) throw new AssertionError();
		index--;
		if(isFull()) throw new AssertionError();
	}
	public int top(){
		if(isEmpty()) throw new AssertionError();
		return list[index-1];
	}
	public boolean isEmpty(){
		return index == 0;
	}
	public boolean isFull(){
		return index == list.length;
	}
	public int size(){
		return index;
	}
	public void clear(){
		index = 0;
	}
	public void print(){
		for(int i = 0; i < size(); i++) System.out.printf("%d ", list[i]);
	}
}

