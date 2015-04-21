package hashtableChaining;

public class AssociativeArray<T>{
	private Node<T>[] arr;
	private int size;
	
	public AssociativeArray(int n){
		if(n < 0) throw new AssertionError();
		arr = (Node<T>[]) new Node[n];
		size = 0;
	}
	private int hashCode(String key){
		int index = key.hashCode() % arr.length;
		if(index < 0) index *= -1;
		return index;
	}
	public void set(String key, T value){
		int index = hashCode(key);
		arr[index] = set(arr[index], key, value);
	}
	private Node<T> set(Node<T> n, String key, T value){
		if(n == null || n.isEmpty()){
			n = new Node<T>(key, value);
			size++;
		}
		else{
			Node<T> res = search(n, key);
			if(res == null || res.isEmpty()){
				res = new Node<T>(key, value);
				res.next = n;
				n = res;
				size++;
			}
			else res.value = value;
		}
		return n;
	}
	private Node<T> search(Node<T> n, String key){
		if(n == null) return null;
		else if(n.key.equals(key)) return n;
		else if(n.next != null) return search(n.next, key);
		else return null;
	}
	public T get(String key){
		int index = hashCode(key);
		if(arr[index] != null){
			Node<T> n = search(arr[index], key);
			if(n != null) return n.value;
		}
		throw new AssertionError("Error: Key not found.");
	}
	public boolean exists(String key){
		int index = hashCode(key);
		if(arr[index] == null) return false;
		Node<T> n = search(arr[index], key);
		return n != null;
	}
	public boolean isEmpty(){
		return size == 0;
	}
	public int size(){
		return size;
	}
	public void clear(){
		for(int i = 0; i < arr.length; i++) arr[i] = null;
		size = 0;
	}
	public void delete(String key){
		int index = hashCode(key);
		if(!exists(key)) throw new AssertionError("Error: Key not found.");
		arr[index] = remove(arr[index], key);
		size--;
	}
	private Node<T> remove(Node<T> n, String key){
		Node<T> result = n;
		if(result.key.equals(key)) result = result.next;
		for(n = result; n != null; ){
			if(n.next != null && n.next.key.equals(key)) n.next = n.next.next;
			n = n.next;
		}
		return result;
	}
	public String[] keysToArray(){
		String[] keys = new String[size];
		int j = 0;
		for(int i = 0; i < arr.length; i++){
			j = keys_for_index(arr[i], keys, j);
		}
		return keys;
	}
	private int keys_for_index(Node<T> pos, String[] keys, int index){
		if(pos == null) return index;
		keys[index++] = pos.key;
		if(pos.next != null) index = keys_for_index(pos.next, keys, index);
		return index;
	}
	private class Node<T>{
		private String key;
		private T value;
		Node<T> next;
		
		public Node(){
			key = new String();
			value = (T) new Object();
		}
		public Node(String key, T value){
			this.key = key;
			this.value = value;
		}
		public boolean isEmpty(){
			return key == null || value == null;
		}
	}
}

