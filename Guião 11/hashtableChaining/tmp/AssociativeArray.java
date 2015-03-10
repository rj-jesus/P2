package hashtableChaining;

public class AssociativeArray<T> {
	private Node<T>[] arr = null;
	private int size;
	
	public AssociativeArray(int n){
		if(n < 0) throw new AssertionError();
		arr = (Node<T>[]) new Node[n];
		size = 0;
	}
	public int hashCode(String key){
		int hash = key.hashCode() % arr.length;
		if(hash < 0) hash = -hash;
		return hash;
	}
	public void set(String key, T elem){
		if(isFull()) throw new AssertionError();
		int hash = hashCode(key);
		Node<T> n = searchNode(arr[hash], key);
		if(arr[hash] == null){
			arr[hash] = new Node<T>();
			arr[hash].e = elem;
			arr[hash].key = key;
			size++;
		}
		else if(n == null){
			n = new Node<T>();
			n.e = elem;
			n.key = key;
			n.next = arr[hash];
			arr[hash] = n;
			size++;
		}
		else{
			n.e = elem;
		}
	}
	public T get(String key){
		int hash = hashCode(key);
		if(arr[hash] == null) throw new AssertionError();
		Node<T> n = searchNode(arr[hash], key);
		return n.e;
	}
	public void delete(String key){
		if(isEmpty()) throw new AssertionError();
		int hash = hashCode(key);
		if(!exists(key)) throw new AssertionError();
		Node<T> n = searchNode(arr[hash], key);
		//Node<T> t = lookForPrev(arr[hash], key);
		//t.next = n.next;
		size--;
	}
	private Node<T> lookForPrev(Node<T> t, String key){
		Node<T> n = null;
		for(int i = 0; i < arr.length; i++){
			if(arr[i] != null){
				if(arr[i].next != null){
					if(arr[i].next.key.equals(key)) return arr[i];
					n = arr[i].next;
					for(; n.next != null; ){
						if(n.next.key.equals(key)) return n;
						n = n.next;
					}
				}
			}
		}
		return n;
	}
	public int size(){
		return size;
	}
	public void clear(){
		for(int i = 0; i < arr.length; i++) arr[i] = null;
		size = 0;
	}
	public String[] keysToArray(){
		String[] keys = null;
		for(int i = 0, j = 0; i < arr.length; i++){
			Node<T> n = arr[i];
			if(n != null){
				keys = expand(keys);
				keys[j++] = n.key;
				for(; n.next != null; ){
					keys = expand(keys);
					keys[j++] = n.key;
					n = n.next;
				}
			}
		}
		return keys;
	}
	private String[] expand(String[] elems){
		if(elems == null) return new String[1];
		String[] brr = new String[elems.length+1];
		for(int i = 0; i < elems.length; i++) brr[i] = elems[i];
		return brr;
	}
	public boolean exists(String key){
		int hash = hashCode(key);
		Node<T> n = searchNode(arr[hash], key);
		return n != null;
	}
	public boolean isEmpty(){
		return size == 0;
	}
	private Node<T> searchNode(Node<T> pos, String key){
		Node<T> n = null;
		if(pos == null) return n;
		else if(pos.key.equals(key)) n = pos;
		else if(pos.next != null) n = searchNode(pos.next, key);
		return n;
	}
	public boolean isFull(){
		return size == arr.length;
	}
	public class Node<T>{
		T e;
		Node<T> next;
		String key;
	}
}

