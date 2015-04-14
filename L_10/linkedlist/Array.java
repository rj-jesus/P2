package linkedlist;

public class Array<T> {
	private T[] array = null;
	
	public Array(int n){
		array = (T[]) new Object[n];
	}
	public void set(T e, int n){
		if(array == null || n >= array.length) throw new AssertionError();
		array[n] = e;
	}
	public boolean defined(int n){
		if(array == null || n >= array.length) throw new AssertionError();
		return array[n] != null;
	}
	public T get(int n){
		if(array == null || n >= array.length) throw new AssertionError();
		return array[n];
	}
	public int length(){
		return array.length;
	}
}

