package linkedlist;

public class Stack<T>{
    private Node<T> top;
    private int size;
    public void push(T e){
	Node<T> node = new Node<T>(e);
	node.next = top;
	top = node;
	size++;
	assert top.e == e;
    }
    public void pop(){
	assert !isEmpty(): "Can't remove elements of an empty stack.";
	top = top.next;
	size--;
    }
    public T top(){
	assert !isEmpty(): "Can't get top element of empty stack.";
	return top.e;
    }
    public boolean isEmpty(){
	return size == 0;
    }
    public int size(){
	return size;
    }
    public void clear(){
	top = null;
	size = 0;
    }
    public void print(){
	Node<T> first = top;
	while(first != null){
	    System.out.print(first.e + " ");
	    first = first.next;
	}
    }
    private class Node<T>{
	T e;
	Node<T> next;
	private Node(T e){
	    this.e = e;
	}
    }
}
