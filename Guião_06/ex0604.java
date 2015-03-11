public class ex0604 {
	
	public static void main (String args[]) {
		assert args != null;
		print(args, 0);
	}
	public static String invertString(String a, String final_string, int i){
		assert a != null;
		if(i >= 0) final_string += a.charAt(i) + invertString(a, "", --i);
		return final_string;
	}
	public static void print(String[] a, int i){
		assert a != null;
		if(i == a.length) return;
		System.out.printf("%s\n", invertString(a[i], "", a[i].length() - 1));
		print(a, ++i);
	}
}

