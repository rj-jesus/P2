public class ex0701 {
	
	public static void main (String args[]) {
		if(args.length != 2) throw new AssertionError();
		System.out.printf("Distância de Levenshtein entre \"%s\" e \"%s\": %d\n", args[0], args[1], levenshtein(args[0], args[1]));
	}
	public static int levenshtein(String a, String b){
		int result = -1;
		if(a == null || b == null) throw new AssertionError();
		if(b.length() == 0) result = a.length();
		else if(a.length() == 0) result = b.length();
		else if(a.charAt(0) == b.charAt(0)) result = levenshtein(a.substring(1), b.substring(1));
		else{
			int[] dl = new int[3];
			dl[0] = 1 + levenshtein(a.substring(1), b);
			dl[1] = 1 + levenshtein(a, b.substring(1));
			dl[2] = 1 + levenshtein(a.substring(1), b.substring(1));
			result = dl[0];
			for(int i = 1; i < dl.length; i++){
				if(dl[i] < result) result = dl[i];
			}
		}
		if(result == -1) throw new AssertionError();
		return result;
	}
}

