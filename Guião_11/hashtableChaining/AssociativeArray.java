package hashtableChaining;

public class AssociativeArray<T>{
	private Node<T>[] arr;
	private int size;
	
	public AssociativeArray(int n){
		if(n < 0) throw new AssertionError();
		arr = (Node<T>[]) new Node[n];
		size = 0;
	}
	public int hashCode(String key){
		int index = key.hashCode() % arr.length;
		if(index < 0) index = -index;
		return index;
	}
	public void set(String key, T value){
		int index = hashCode(key);
		if(arr[index] == null){
			arr[index] = new Node<T>();
			arr[index].key = key;
			arr[index].value = value;
			size++;
		}
		else{
			Node<T> n = search(key, arr[index]);
			if(n == null){
				n = new Node<T>();
				n.key = key;
				n.value = value;
				n.next = arr[index];
				arr[index] = n;
				size++;
			}
			else n.value = value;
		}
	}
	public T get(String key){
		int index = hashCode(key);
		if(!exists(key)) throw new AssertionError();
		Node<T> n = search(key, arr[index]);
		return n.value();
	}
	public boolean exists(String key){
		int index = hashCode(key);
		if(arr[index] == null) return false;
		Node<T> n = search(key, arr[index]);
		return n != null;
	}
	public boolean isEmpty(){
		return size == 0;
	}
	public boolean isFull(){
		return size == arr.length;
	}
	public int size(){
		return size();
	}
	public void clear(){
		for(int i = 0; i < arr.length; i++) arr[i] = null;
		size = 0;
	}
	public void delete(String key){
		int index = hashCode(key);
		if(!exists(key)) throw new AssertionError();
		Node<T> n = search(key, arr[index]);
		n.value = null;
		n = arr[index];
		if(n.value() == null) arr[index] = n.next();
		else{
			for(; n.next.value() != null; ) n = n.next();
			n = n.next.next();
			for(; !n.key().equals(arr[index].key()); ){
				Node<T> t = n;
				for(n = arr[index]; !n.next.key().equals(t.key()); ) n = n.next();
				n.next = t;
			}
			arr[index] = n;
		}
		size--;
	}
	public String[] keysToArray(){
		String[] keys = new String[arr.length];
		int j = 0;
		for(int i = 0; i < arr.length; i++){
			if(arr[i] != null){
				Node<T> n = arr[i];
				for(; ; ){
					keys[j++] = n.key();
					if(n.next() == null) break;
					n = n.next();
				}
			}
		}
		String[] last_array = new String[j];
		for(int i = 0; keys[i] != null; i++) last_array[i] = keys[i];
		return last_array;
	}
	private Node<T> search(String key, Node<T> position){
		Node<T> n = position;
		for(; ; ){
			if(n.key().equals(key)) return n;
			else if(n.next() != null) n = n.next();
			else break;
		}
		return null;
	}
	private class Node<T>{
		String key;
		T value;
		Node<T> next;
		
		public String key(){
			return key;
		}
		public T value(){
			return value;
		}
		public Node<T> next(){
			return next;
		}
	}
}

