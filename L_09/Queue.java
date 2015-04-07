public class Queue<T> {
	private Node<T> head = null, tail = null;
	
	public T peek(){
		if(this.isEmpty()) throw new AssertionError("Error: Empty queue.");
		return head.data;
	}
	public void out(){
		if(this.isEmpty()) throw new AssertionError("Error: Empty queue.");
		head = head.next;
	}
	public void in(T data){
		Node<T> tmp = new Node<T>();
		tmp.data = data;
		if(head == null) head = tmp;
		else tail.next = tmp;
		tail = tmp;
	}
	public boolean isEmpty(){
		return head == null;
	}
	private class Node<T>{
		T data;
		Node<T> next;
	}
}

