package linkedlist;

public class Stack<T> {
	private Node<T> top = null;
	private int size = 0;
	
	public void push(T e){
		Node<T> n = new Node<T>();
		n.e = e;
		n.next = top;
		top = n;
		size++;
	}
	public void pop(){
		if(isEmpty()) throw new AssertionError();
		top = top.next;
		size--;
	}
	public T top(){
		if(isEmpty()) throw new AssertionError();
		return top.e;
	}
	public void print(){
		for(; !isEmpty(); ){
			System.out.print(top() + " ");
			pop();
		}
	}
	public boolean isEmpty(){
		return size == 0;
	}
	public int size(){
		return size;
	}
	private class Node<T>{
		T e;
		Node<T> next;
	}
}

