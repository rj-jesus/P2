package cdlinkedlist;

public class Queue<T>{
    private Node<T> top;
    private int size;
    public void in(T e){
	Node<T> node = new Node<T>(e);
	if(isEmpty()){
	    top = node;
	    top.prev = top;
	    top.next = top;
	}
	else{
	    node.prev = top.prev;
	    node.next = top;
	    top.prev = node;
	    node.prev.next = node;
	}
	size++;
    }
    public void out(){
	assert !isEmpty(): "Can't delete an element from an empty queue.";
	top.next.prev = top.prev;
	top = top.next;
	size--;
    }
    public T peek(){
	assert !isEmpty(): "Can't retrieve an element from an empty queue.";
	return top.e;
    }
    public int size(){
	return size;
    }
    public boolean isEmpty(){
	return size == 0;
    }
    public void clear(){
	top = null;
	size = 0;
    }
    public void print(){
	Node<T> first = top;
	System.out.print(first.e + " ");
	first = first.next;
	while(first != top){
	    System.out.print(first.e + " ");
	    first = first.next;
	}
    }
    private class Node<T>{
	T e;
	Node<T> prev;
	Node<T> next;
	private Node(T e){
	    this.e = e;
	}
    }
}
