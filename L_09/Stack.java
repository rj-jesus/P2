public class Stack<T> {
	private Node<T> top = null;
	
	public T top(){
		if(this.isEmpty()) throw new AssertionError("Error: Empty stack.");
		return top.data;
	}
	public void pop(){
		if(this.isEmpty()) throw new AssertionError("Error: Empty stack.");
		top = top.next;
	}
	public void push(T data){
		Node<T> tmp = new Node<T>();
		tmp.data = data;
		tmp.next = top;
		top = tmp;
	}
	public void print(){
		print(top);
	}
	private void print(Node n){
		if(n != null){
			print(n.next);
			System.out.print(" " + n.data);
		}
	}
	public boolean isEmpty(){
		return top == null;
	}
	public void clear(){
		top = null;
	}
	private class Node<T>{
		T data;
		Node<T> next;
	}
}

