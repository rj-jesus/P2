public class TorreDeHanói {
	private Stack<Integer> t1 = null, t2 = null, t3 = null;
	private int n;
	
	public TorreDeHanói(int n){
		if(n <= 0) throw new AssertionError("Error: Must have at least one disk.");
		t1 = new Stack();
		t2 = new Stack();
		t3 = new Stack();
		this.n = n;
		for(int i = n; i > 0; t1.push(i--));
	}
	public void solveTowerOfHanoi(int n, Stack t1, Stack t2, Stack t3){
		if(n > 0){
			solveTowerOfHanoi(n-1, t1, t3, t2);
			print();
			t2.push(t1.top());
			t1.pop();
			solveTowerOfHanoi(n-1, t3, t2, t1);
		}
	}
	public void solveTowerOfHanoi(){
		solveTowerOfHanoi(n, t1, t2, t3);
		print();
	}
	public void print(){
		System.out.print("   |\n");
		System.out.print("TA |");
		t1.print();
		System.out.print("\n   |\n");
		System.out.print("TB |");
		t2.print();
		System.out.print("\n   |\n");
		System.out.print("TC |");
		t3.print();
		System.out.print("\n   |\n");
	}
}

