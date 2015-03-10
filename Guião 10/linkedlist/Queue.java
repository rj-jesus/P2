package linkedlist;

public class Queue<T> {
	private Node<T> fout = null, fin = null;
	private int size = 0;
	
	public void in(T e){
		Node<T> n = new Node<T>();
		n.e = e;
		if(fout == null) fout = n;
		else fin.next = n;
		fin = n;
		size++;
	}
	public void out(){
		if(isEmpty()) throw new AssertionError();
		fout = fout.next;
		if(fout == null) fin = null;
		size--;
	}
	public T peek(){
		return fout.e;
	}
	public int size(){
		return size;
	}
	public boolean isEmpty(){
		return fout == null;
	}
	public void print(){
		for(; !isEmpty(); ){
			System.out.print(peek() + " ");
			out();
		}
	}
	private class Node<T>{
		T e;
		Node<T> next;
	}
}

