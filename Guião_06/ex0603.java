public class ex0603 {
	
	public static void main (String args[]) {
		print(args, args.length - 1);
	}
	public static void print(String[] a, int i){
		assert a != null;
		if(i == -1) return;
		System.out.printf("%s\n", a[i]);
		print(a, --i);
	}
}

