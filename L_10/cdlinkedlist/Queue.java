package cdlinkedlist;

public class Queue<T> {
	private Node<T> fin = null, fout = null;
	private int size = 0;
	
	public void in(T e){
		Node<T> n = new Node<T>();
		n.e = e;
		if(fout == null) fout = n;
		else fin.next = n;
		n.next = fout;
		n.prev = fin;
		fout.prev = n;
		fin = n;
		size++;
	}
	public void out(){
		if(isEmpty()) throw new AssertionError();
		if(size == 1) fout = null;
		else{
			fout = fout.next;
			fout.prev = fin;
			fin.next = fout;
		}
		size--;
	}
	public T peek(){
		if(isEmpty()) throw new AssertionError();
		return fout.e;
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
		Node<T> prev, next;
	}
}

