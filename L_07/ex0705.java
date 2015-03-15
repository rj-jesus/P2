public class ex0705 {
	public static void main (String args[]) {
		boolean[][] board = null;
		try{
			board = new boolean[Integer.parseInt(args[0])][Integer.parseInt(args[0])];
		}
		catch(NumberFormatException|NullPointerException e){
			System.out.print("Error: Usage: java ex0705 <N>\n");
			System.exit(1);
		}
		finally{
			if(board == null){
				System.out.print("Error: No arguments found!\n");
				System.exit(1);
			}
		}
		setArrayFalse(board);
		solveSuperQueen(board, 0);
	}
	public static void setArrayFalse(boolean[][] arr){
		for(int i = 0; i < arr.length; i++){
			for(int j = 0; j < arr.length; j++) arr[i][j] = false;
		}
	}
	public static boolean solveSuperQueen(boolean[][] arr, int j){
		if(arr == null || j > arr.length || j < 0) throw new AssertionError();
		boolean to_return = j == arr.length;
		if(to_return){
			to_return = false;
			print(arr);
			System.out.print("\n");
			j--;
		}
		for(int i = 0; !to_return && i < arr.length; i++){
			if(!attacked(arr, i, j)){
				arr[i][j] = true;
				to_return = solveSuperQueen(arr, j+1);
				if(!to_return) arr[i][j] = false;
			}
		}
		return to_return;
	}
	public static boolean attacked(boolean[][] arr, int i, int j){
		if(arr == null || j >= arr.length || j < 0 || i >= arr.length || i < 0) throw new AssertionError();
		for(int k = 0; k < arr.length; k++){
			if(arr[i][k]) return true;
			if(arr[k][j]) return true;
		}
		for(int k = 0; i-k >= 0 && j-k >= 0; k++) if(arr[i-k][j-k]) return true;
		for(int k = 0; i+k < arr.length && j-k >= 0; k++) if(arr[i+k][j-k]) return true;
		if(i-2 >= 0 && j-1 >= 0 && arr[i-2][j-1]) return true;
		if(i+2 < arr.length && j-1 >= 0 && arr[i+2][j-1]) return true;
		if(i-1 >= 0 && j-2 >= 0 && arr[i-1][j-2]) return true;
		if(i+1 < arr.length && j-2 >= 0 && arr[i+1][j-2]) return true;
		return false;
	}
	public static void print(boolean[][] arr){
		if(arr == null) throw new AssertionError();
		for(int i = 0; i < arr.length; i++){
			for(int j = 0; j < arr.length; j++){
				System.out.print(" ");
				if(arr[i][j]) System.out.print("Q");
				else System.out.print("*");
				System.out.print(" ");
			}
			System.out.print("\n");
		}
	}
}

