/**
 * Complete este módulo de forma a que o programa principal funcione devidamente.
 * 
 * Uma CompressedQueue é uma fila, mas onde entradas com o mesmo valor são comprimidas
 * para um único elemento da fila contendo o valor e o número de repetições.
 * 
 * Além disto e dos métodos usuais, tem também métodos adicionais:
 * 
 * peekCount()
 *   Devolve o número de repetições do valor existente na frente da fila.
 * 
 * maxDiff()
 *   Indica qual o maior "salto" (em valor absoluto) entre elementos consecutivos da fila.
 * 
 * minDiff()
 *   Indica qual o menor "salto" (em valor absoluto) entre elementos consecutivos da fila.
 * 
 * toString()
 *   Devolve uma string com os elementos da fila (entre {}), por ordem, em cada elemento
 *   é descrito pelo par valor e repetições (entre []) e cada elemento é por
 *   vírgulas.
 * 
 **/

public class CompressedQueue{
	private Node<Integer> first_in;
	private Node<Integer> last_out;
	private int size;
	private int minDiff = Integer.MAX_VALUE, maxDiff = Integer.MIN_VALUE;
	public void in(int i){
		Node<Integer> node = new Node<Integer>(i);
		if(last_out != null) ;
		if(empty()){
			first_in = node;
			last_out = node;
		}
		else if(last_out.value == i) last_out.count += 1;
		else{
			int diference = Math.abs(i - last_out.value);
			if(diference < minDiff) minDiff = diference;
			if(diference > maxDiff) maxDiff = diference;
			last_out.next = node;
			last_out = node;
		}
		size++;
	}
	public int minDiff(){
		if(empty()) throw new AssertionError("Error: Empty queue.");
		return minDiff;
	}
	public int maxDiff(){
		if(empty()) throw new AssertionError("Error: Empty queue.");
		return maxDiff;
	}
	public void out(){
		if(empty()) throw new AssertionError("Error: Empty queue.");
		size -= first_in.count;
		first_in = first_in.next;
	}
	public int peek(){
		if(empty()) throw new AssertionError("Error: Empty queue.");
		return first_in.value;
	}
	public int peekCount(){
		if(empty()) throw new AssertionError("Error: Empty queue.");
		return first_in.count;
	}
	public String toString(){
		String result = "{";
		Node<Integer> valued_node = this.first_in;
		while(valued_node != null){
			result += "[" + Integer.valueOf(valued_node.value) + ":" + Integer.valueOf(valued_node.count) + "],";
			valued_node = valued_node.next;
		}
		if(result.length() == 1) result += " ";
		return result.substring(0, result.length()-1) + "}";
	}
	public void clear(){
		size = 0;
	}
	public int size(){
		return size;
	}
	public boolean empty(){
		return size == 0;
	}
	private class Node<T>{
		T value;
		int count = 1;
		Node<T> next;
		private Node(T value){
			this.value = value;
		}
	}
}
