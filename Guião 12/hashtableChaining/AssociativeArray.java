package hashtableChaining;

public class AssociativeArray<K extends Comparable<? super K>, T>{
	private Node<K, T> root;
	private int size = 0;
	
	public void set(K key, T value){
		if(!exists(key)) size++;
		root = set(root, key, value);
	}
	private Node<K, T> set(Node<K, T> node, K key, T value){
		if(node == null) node = new Node(key, value);
		else if(node.key.compareTo(key) == 0) node.value = value;
		else if(node.key.compareTo(key) > 0) node.left = set(node.left, key, value);
		else node.right = set(node.right, key, value);
		return node;
	}
	public T get(K key){
		if(!exists(key)) throw new AssertionError();
		return search(root, key).value;
	}
	public boolean exists(K key){
		return search(root, key) != null;
	}
	public void delete(K key){
		if(!exists(key)) throw new AssertionError();
		root = delete(root, key);
		size--;
	}
	public Node<K, T> delete(Node<K, T> node, K key){
		int n = node.key.compareTo(key);
		if(n == 0 && node.right == null && node.left == null) return null;
		else if(n == 0 && node.right != null && node.left == null) return node.right;
		else if(n == 0 && node.left != null && node.right == null) return node.left;
		else if(n == 0) return set(node, node.left.key, node.left.value);
		else if(n > 0) return delete(node.left, key);
		else return delete(node.right, key);
	}
	public boolean isEmpty(){
		return root == null;
	}
	public void clear(){
		size = 0;
		root = null;
	}
	public int size(){
		return size;
	}
	public String[] keysToArray(){
		String[] arr = new String[size];
		getKeys(root, arr, 0);
		return arr;
	}
	private int getKeys(Node<K, T> node, String[] arr, int i){
		if(node.left != null) i = getKeys(node.left, arr, i);
		arr[i++] = node.key.toString();
		if(node.right != null) i = getKeys(node.right, arr, i);
		return i;
	}
	/*public K[] keysToArray(){
		K[] arr = new K[size];
		getKeys(root, arr, 0);
		return arr;
	}
	private int getKeys(Node<K, T> node, String[] arr, int i){
		if(node.left != null) i = getKeys(node.left, arr, i);
		arr[i++] = node.key.toString();
		if(node.right != null) i = getKeys(node.right, arr, i);
		return i;
	}*/
	private Node<K, T> search(Node<K, T> node, K key){
		if(node == null) return null;
		int n = node.key.compareTo(key);
		if(n == 0) return node;
		if(n < 0) return search(node.left, key);
		else return search(node.right, key);
	}
	private K getK(Node<K, T> e){
		return e.key;
	}
	private class Node<K, T>{
		K key;
		T value;
		Node<K, T> left;
		Node<K, T> right;
		
		private Node(K key, T value){
			this.key = key;
			this.value = value;
		}
	}
}

