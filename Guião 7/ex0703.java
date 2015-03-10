public class ex0703 {
	
	public static void main (String args[]) {
		double[] n = new double[args.length];
		try{
			for(int i = 0; i < args.length; i++) n[i] = Double.parseDouble(args[i]);
		}
		catch(NumberFormatException e){
			System.out.print("ERRO: Argumentos inválidos.\n");
			System.exit(1);
		}
		finally{
			if(n.length == 0){
				System.out.print("Nenhuns argumentos encontrados. Soma: 0\n");
				System.exit(1);
			}
		}
		System.out.printf("Soma: %.2f\n", sumRec(n, 0, n.length-1));
	}
	public static double sumRec(double[] arr, int start, int end){
		assert arr != null && start >= 0 && start <= end && end < arr.length;
		double result = 0;
		if(end == start) return arr[start];
		result = arr[end] + sumRec(arr, start, --end);
		return result;
	}
}

