public class ex0703 {
	
	public static void main (String args[]) {
		double[] n = new double[args.length];
		try{
			for(int i = 0; i < args.length; i++) n[i] = Double.parseDouble(args[i]);
		}
		catch(NumberFormatException e){
			System.err.print("Error: Invalid arguments.\n");
			System.exit(1);
		}
		finally{
			if(n.length == 0){
				System.out.print("No arguments found. Sum: 0\n");
				System.exit(0);
			}
		}
		System.out.printf("Sum: %.2f\n", sumRec(n, 0, n.length-1));
	}
	public static double sumRec(double[] arr, int start, int end){
		assert arr != null && start >= 0 && start <= end && end < arr.length;
		double result = 0;
		if(start == end) result = arr[start];
		else result = arr[start] + sumRec(arr, ++start, end);
		return result;
	}
}

