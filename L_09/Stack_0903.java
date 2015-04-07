public class Stack_0903 {
	private double[] list = null;
	private int index;
	
	public void push(double n){
		list = addElement(list);
		list[index++] = n;
	}
	private static double[] addElement(double[] arr){
		if(arr == null) return new double[1];
		double[] brr = new double[arr.length+1];
		for(int i = 0; i < arr.length; i++) brr[i] = arr[i];
		return brr;
	}
	public void pop(){
		if(isEmpty()) throw new AssertionError();
		index--;
		list = removeElement(list);
	}
	public double[] removeElement(double[] arr){
		double[] brr = new double[arr.length-1];
		for(int i = 0; i < brr.length; i++) brr[i] = arr[i];
		return brr;
	}
	public double top(){
		if(isEmpty()) throw new AssertionError();
		return list[index-1];
	}
	public boolean isEmpty(){
		return index == 0;
	}
	public void print(){
		for(int i = 0; i < list.length; i++) System.out.printf("%.2f ", list[i]);
	}
}

