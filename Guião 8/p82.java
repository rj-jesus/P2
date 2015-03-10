import static java.lang.System.*;
import java.util.Scanner;

public class p82
{
   public static void main(String[] args)
   {
      NumberArray na = new NumberArray();
      insertionSort(na.array(), 0, na.length());
      na.print();
   }

   public static void insertionSort(int[] arr, int start, int end){
		for(int i = start+1, j; i < end; i++){
			int v = arr[i];
			for(j = i-1; j >= start && arr[j] > v; j--) arr[j+1] = arr[j];
			arr[j+1] = v;
		}
	}
}

