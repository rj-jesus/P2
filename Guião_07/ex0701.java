public class ex0701 {
	
	public static void main (String args[]) {
		if(args.length != 2) throw new AssertionError();
		System.out.printf("Distância de Levenshtein entre \"%s\" e \"%s\": %d\n", args[0], args[1], levenshtein(args[0], args[1]));
	}
	public static int levenshtein(String a, String b){
		int result = -1;
		if(a == null || b == null) throw new AssertionError();
		if(a.length() == 0) result = b.length();
		else if(b.length() == 0) result = a.length();
		else if(a.charAt(0) == b.charAt(0)) result = levenshtein(a.substring(1), b.substring(1));
		else{
			int[] ds = new int[3];
			ds[0] = 1 + levenshtein(a.substring(1), b);
			ds[1] = 1 + levenshtein(a, b.substring(1));
			ds[2] = 1 + levenshtein(a.substring(1), b.substring(1));
			result = ds[0];
			for(int i = 0; i < ds.length; i++){
				if(ds[i] < result || result == -1) result = ds[i];
			}
		}
		if(result == -1) throw new AssertionError();
		return result;
	}
}

