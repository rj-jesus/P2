public class ex0704 {
	
	public static void main (String args[]) {
		double[] arr = new double[args.length];
		{
			int i = 0;
			for(String value : args){
				try{
					arr[i++] = Double.parseDouble(value);
				}
				catch(NumberFormatException e){
					System.err.print("Error: Invalid input to parse.");
					System.exit(1);
				}
			}
		}
		double result = sumRec(arr, 0, arr.length);
		System.out.printf("%.5f\n", result);
	}
	public static double sumRec(double[] arr, int start, int end){
		double result = 0;
		if(start < end){
			result += arr[start] + sumRec(arr, ++start, end);
		}
		return result;
	}
}

