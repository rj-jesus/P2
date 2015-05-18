/**
Um objecto da classe Train representa um comboio composto de vários vagões
de mercadorias a granel.
Quando se cria um comboio, é necessário especificar a capacidade de cada
vagão e a capacidade total que o comboio suporta, ambas em toneladas.
Pode acrescentar-se um vagão com certa carga à cauda de um comboio
(addWagon) ou pode retirar-se um vagão da cauda (removeWagon), segundo uma
política LIFO (último a entrar é o primeiro a sair).
Naturalmente, a carga de um vagão não pode superar a sua capacidade e só
se pode acrescentar um vagão que não faça ultrapassar a carga total máxima do
comboio.
Também é possível pedir para descarregar (unload) uma dada quantidade, o que
será feito pela descarga completa e retirada de zero ou mais vagões da cauda
e pela descarga parcial de outro vagão para completar a quantidade pedida.
Em qualquer altura é possível obter uma lista da carga nos vagões do
comboio (list); saber o número de vagões (size) ou a carga total
transportada (totalCargo).

Métodos principais:
addWagon     Acrescenta um vagão com uma certa carga ao fim do comboio.
removeWagon  Retira o vagão do fim do comboio e devolve a sua carga.
unload       Descarrega uma certa quantidade, retirando os vagões que ficarem
             vazios.  Devolve o número de vagões retirados.
acceptsCargo Verifica se o comboio pode aceitar uma carga adicional,
             sem ultrapassar o limite de carga total.
list         Devolve um array com as cargas de cada vagão, do primeiro ao último.
             Não altera nada no comboio.
size         Tamanho (número de vagões) do comboio.
totalCargo   Carga total transportada no comboio.
**/

public class Train {
	private double wagonCapacity, trainCapacity, totalCargo;
	private int size;
	private Node<Double> top;
	public Train(double wagonCapacity, double trainCapacity){
		assert wagonCapacity <= trainCapacity: "Wagon capacity mustn't be smaller than train capacity.";
		assert trainCapacity >= 0: "Capacities must be nonnegaive values.";
		this.wagonCapacity = wagonCapacity;
		this.trainCapacity = trainCapacity;
	}
	public void addWagon(double cargo){
		assert cargo >= 0: "Cargo must be a nonnegative value.";
		assert cargo <= wagonCapacity: "Cargo exceeds maximum wagon cargo.";
		assert acceptsCargo(cargo): "Can't exceed maximum train cargo.";
		Node<Double> tmp = new Node<Double>(cargo);
		if(top == null) top = tmp;
		else{
			tmp.next = top;
			top = tmp;
		}
		totalCargo += cargo;
		size++;
	}
	public double removeWagon(){
		assert !isEmpty(): "Can't remove a wagon from an empty train.";
		double cargo = top.value;
		top = top.next;
		totalCargo -= cargo;
		size--;
		return cargo;
	}
	public double totalCargo(){
		return totalCargo;
	}
	public int unload(double cargo){
		assert cargo <= totalCargo: "Can't remove cargo the train doesn't have.";
		int wagons_removed = 0;
		while(cargo > 0){
			if(top.value <= cargo){
				cargo -= removeWagon();
				wagons_removed++;
			}
			else{
				top.value -= cargo;
				totalCargo -= cargo;
				cargo = 0;
			}
		}
		return wagons_removed;
	}
	public double[] list(){
		Node<Double> wagon = top;
		double[] cargos = new double[size];
		for(int i = size-1; i >= 0; i--){
			cargos[i] = wagon.value;
			wagon = wagon.next;
		}
		return cargos;
	}
	public int size(){
		return size;
	}
	public boolean isEmpty(){
		return size == 0;
	}
	public boolean acceptsCargo(double cargo){
		return totalCargo + cargo <= trainCapacity;
	}
	private class Node<T>{
		T value;
		Node<T> next;
		private Node(T value){
			this.value = value;
		}
	}
}
