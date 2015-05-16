/**
 * Uma estrutura de dados baseada numa fila, mas em que só ficam
 * armazenados os últimos N números inseridos. Quando a fila está
 * preenchida (N elementos) a inserção de um novo número implica
 * a saída do primeiro (que deixa de existir).
 */

public class LeakyQueue{
	private int size, max_size;
	private Node<Double> last_in, first_out;
	
	public LeakyQueue(int n){
		max_size = n;
	}
	public void in(double value){
		Node tmp = new Node(value);
		if(isEmpty()){
			last_in = tmp;
			first_out = tmp;
		}
		else{
			last_in.next = tmp;
			last_in = tmp;
		}
		if(size++ == max_size){
			out();
		}
	}
	public void out(){
		if(!isEmpty()){
			first_out = first_out.next;
			size--;
		}
	}
	public void print(){
		Node to_print = this.first_out;
		while(to_print != null){
			System.out.print(to_print.value + "  ");
			to_print = to_print.next;
		}
	}
	public int size(){
		return size;
	}
	public double minimum(){
		Node<Double> node_with_value = this.first_out;
		if(node_with_value == null) throw new AssertionError("Can't get minimum of empty set.");
		double minimum = node_with_value.value;
		while(node_with_value != null){
			if(minimum > node_with_value.value) minimum = node_with_value.value;
			node_with_value = node_with_value.next;
		}
		return minimum;
	}
	public boolean isEmpty(){
		return size == 0;
	}
	private class Node<T>{
		private T value;
		private Node next;
		private Node(T value){
			this.value = value;
		}
	}
}

