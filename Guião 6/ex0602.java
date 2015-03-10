public class ex0602 {
	
	public static void main (String args[]) {
		print(args, 0);
	}
	public static void print(String[] a, int i){
		assert a != null;
		if(i == a.length) return;
		System.out.printf("%s\n", a[i]);
		print(a, ++i);
	}
}

