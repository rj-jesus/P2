import static java.lang.System.*;

public class p83
{
   static public void main(String[] args)
   {
      if (args.length != 1)
      {
         err.println("Test sorting algorithms for a N number array.");
         err.println("Usage: java -ea p83 <N>");
         exit(1);
      }

      int n = Integer.valueOf(args[0]);
      int[] x = randomArray(n, n/2);
      int[] tests;
      
	    tests = copyIntArray(x);
      long time = nanoTime(); // To calculate execution time
      SwapsComps swapcompSeq = new SwapsComps();
      sequentialSort(tests, 0, tests.length, swapcompSeq);
      long elapsedTime = nanoTime() - time;
		long seq = elapsedTime;
      
		tests = copyIntArray(x);
      time = nanoTime(); // To calculate execution time
      SwapsComps swapcompBub = new SwapsComps();
      bubbleSort(tests, 0, tests.length, swapcompBub);
      elapsedTime = nanoTime() - time;
		long bub = elapsedTime;
      
		tests = copyIntArray(x);
      time = nanoTime(); // To calculate execution time
      SwapsComps swapcompIns = new SwapsComps();
      insertionSort(tests, 0, tests.length, swapcompIns);
      elapsedTime = nanoTime() - time;
		long ins = elapsedTime;
      
		tests = copyIntArray(x);
      time = nanoTime(); // To calculate execution time
      SwapsComps swapcompMer = new SwapsComps();
      mergeSort(tests, 0, tests.length, swapcompMer);
      elapsedTime = nanoTime() - time;
		long mer = elapsedTime;

      out.printf("%-15s | %-10s | %10s | %9s | %11s | %9s\n", "Algorithm", "Array", "Dimension", "Swaps", "Comparisons", "Time (ns)");
      out.printf("----------------|------------|------------|-----------|-------------|----------\n");
      out.printf("%-15s | %-10s | %10d | %9d | %11s | %9d\n", "Sequential Sort", "random", n, swapcompSeq.swaps, swapcompSeq.comps, seq);
      out.printf("%-15s | %-10s | %10d | %9d | %11s | %9d\n", "Bubble Sort", "random", n, swapcompBub.swaps, swapcompBub.comps, bub);
      out.printf("%-15s | %-10s | %10d | %9d | %11s | %9d\n", "Insertion Sort", "random", n, swapcompIns.swaps, swapcompIns.comps, ins);
      out.printf("%-15s | %-10s | %10d | %9d | %11s | %9d\n", "Merge Sort", "random", n, swapcompMer.swaps, swapcompMer.comps, mer);
      
      //Ascending
      
      x = ascendArray(n);
      
	    tests = copyIntArray(x);
	    swapcompSeq.zero();
      time = nanoTime(); // To calculate execution time
      sequentialSort(tests, 0, tests.length, swapcompSeq);
      elapsedTime = nanoTime() - time;
		seq = elapsedTime;
      
		tests = copyIntArray(x);
		swapcompBub.zero();
      time = nanoTime(); // To calculate execution time
      bubbleSort(tests, 0, tests.length, swapcompBub);
      elapsedTime = nanoTime() - time;
		bub = elapsedTime;
      
		tests = copyIntArray(x);
		swapcompIns.zero();
      time = nanoTime(); // To calculate execution time
      insertionSort(tests, 0, tests.length, swapcompIns);
      elapsedTime = nanoTime() - time;
		ins = elapsedTime;
      
		tests = copyIntArray(x);
		swapcompMer.zero();
      time = nanoTime(); // To calculate execution time
      mergeSort(tests, 0, tests.length, swapcompMer);
      elapsedTime = nanoTime() - time;
		mer = elapsedTime;
      
      out.printf("----------------|------------|------------|-----------|-------------|----------\n");
      out.printf("%-15s | %-10s | %10d | %9d | %11s | %9d\n", "Sequential Sort", "ascending", n, swapcompSeq.swaps, swapcompSeq.comps, seq);
      out.printf("%-15s | %-10s | %10d | %9d | %11s | %9d\n", "Bubble Sort", "ascending", n, swapcompBub.swaps, swapcompBub.comps, bub);
      out.printf("%-15s | %-10s | %10d | %9d | %11s | %9d\n", "Insertion Sort", "ascending", n, swapcompIns.swaps, swapcompIns.comps, ins);
      out.printf("%-15s | %-10s | %10d | %9d | %11s | %9d\n", "Merge Sort", "ascending", n, swapcompMer.swaps, swapcompMer.comps, mer);
      
      //Descending
      
      x = descendArray(n);
      
	    tests = copyIntArray(x);
	    swapcompSeq.zero();
      time = nanoTime(); // To calculate execution time
      sequentialSort(tests, 0, tests.length, swapcompSeq);
      elapsedTime = nanoTime() - time;
		seq = elapsedTime;
      
		tests = copyIntArray(x);
		swapcompBub.zero();
      time = nanoTime(); // To calculate execution time
      bubbleSort(tests, 0, tests.length, swapcompBub);
      elapsedTime = nanoTime() - time;
		bub = elapsedTime;
      
		tests = copyIntArray(x);
		swapcompIns.zero();
      time = nanoTime(); // To calculate execution time
      insertionSort(tests, 0, tests.length, swapcompIns);
      elapsedTime = nanoTime() - time;
		ins = elapsedTime;
      
		tests = copyIntArray(x);
		swapcompMer.zero();
      time = nanoTime(); // To calculate execution time
      mergeSort(tests, 0, tests.length, swapcompMer);
      elapsedTime = nanoTime() - time;
		mer = elapsedTime;
      
      out.printf("----------------|------------|------------|-----------|-------------|----------\n");
      out.printf("%-15s | %-10s | %10d | %9d | %11s | %9d\n", "Sequential Sort", "descending", n, swapcompSeq.swaps, swapcompSeq.comps, seq);
      out.printf("%-15s | %-10s | %10d | %9d | %11s | %9d\n", "Bubble Sort", "descending", n, swapcompBub.swaps, swapcompBub.comps, bub);
      out.printf("%-15s | %-10s | %10d | %9d | %11s | %9d\n", "Insertion Sort", "descending", n, swapcompIns.swaps, swapcompIns.comps, ins);
      out.printf("%-15s | %-10s | %10d | %9d | %11s | %9d\n", "Merge Sort", "descending", n, swapcompMer.swaps, swapcompMer.comps, mer);
   }

   /**
    * Creates an integer random array with numbers in the interval [0; max].
    * @param len length of the array.
    * @param max maximum random value.
    * @return the array
    */
   static int[] randomArray(int len, int max)
   {
      assert len >= 0;
      assert max >= 0;

      int[] result = new int[len];
      for (int i = 0; i < len; i++)
         result[i] = (int)(Math.random()*(max+1));
      return result;
   }

   /**
    * Swaps two elements of an integer array.
    * @param a the array
    * @param i index of an element to swap
    * @param j index of the other element to swap
    * {@code i},{@code j} must be valid indexes within array {@code a}
    */
   static void swap(int[] a, int i, int j)
   {
      assert a!=null;
      assert 0<=i && i<a.length;
      assert 0<=j && j<a.length;

      int temp;
      temp = a[i];
      a[i] = a[j];
      a[j] = temp;
   }

   /**
    * Sequential sort ("greed" variation of selection sort).
    * Increasing sorting of integer subarray a[start..end[
    * @param a      the array to be (partially) sorted.
    * @param start  index of the first element to sort.
    * @param end    index of the first element not to be sorted (the last element to sort is {@code end-1}).
    * Requires:   a!=null and 0 <= start <= end <= a.length
    * Ensures:  The elements a[k] with start <= k < end are sorted.  the remaining elements are not changed.
    */
   static void sequentialSort(int[] a, int start, int end, SwapsComps ac)
   {
      assert a!=null;
      assert 0<=start && start<=end && end<=a.length;
      for (int i=start; i<end-1; i++) // For each elements (except the last one):
      {
         for (int j=i+1; j<end; j++)
         { 
			 ac.comps++;
            if (a[j] < a[i]){
			   ac.swaps++;                  // compares them
               swap(a, i, j);              // if necessary a swap occurs
			}
         }
      }

      assert isSorted(a, start, end); // checking for possible incorrections of the algorithm!
   }

   /**
    * Checks if a given subarray is sorted (increasing order).
    * @param a[start..end[  the subarray to chack.
    * @return true    if subarray is sorted.
    */
   static boolean isSorted(int [] a, int start, int end)
   {
      assert a!=null;
      assert 0<=start && start<=end && end<=a.length;

      boolean result = true;
      for (int k=start+1; result && k<end; k++) 
         result = (a[k-1]<=a[k]);
      return result;
   }
   public static void mergeSort(int[] arr, int start, int end, SwapsComps a){
		if(end - start > 1){
			int mid = (end+start) / 2;
			mergeSort(arr, start, mid, a);
			mergeSort(arr, mid, end, a);
			mergeSubSort(arr, start, mid, end, a);
		}
		if(!isSorted(arr, start, end)) throw new AssertionError();
	}
	public static void mergeSubSort(int[] arr, int start, int mid, int end, SwapsComps a){
		int[] brr = new int[end-start];
		int i = start, j = mid, b = 0;
		for(; i < mid && j < end; ){
			a.comps++;
			if(arr[i] < arr[j]) brr[b++] = arr[i++];
			else{
				brr[b++] = arr[j++];
				a.swaps++;
			}
		}
		for(; i < mid; ) brr[b++] = arr[i++];
		for(; j < end; ) brr[b++] = arr[j++];
		System.arraycopy(brr, 0, arr, start, end-start);
	}
	public static void bubbleSort(int[] arr, int start, int end, SwapsComps a){
		boolean repeat = true;
		for(int n = end; repeat && n > start; n--){
			repeat = false;
			for(int j = 0; j < n - 1; j++){
				a.comps++;
				if(arr[j] > arr[j+1]){
					swap(arr, j, j+1);
					a.swaps++;
					repeat = true;
				}
			}
		}
		if(!isSorted(arr, start, end)) throw new AssertionError();
	}
	public static void insertionSort(int[] arr, int start, int end, SwapsComps a){
		for(int i = start + 1, j; i < end; i++){
			int tmp = arr[i];
			for(j = i-1; j >= start && arr[j] > tmp; j--){
				arr[j+1] = arr[j];
				a.swaps++;
				a.comps++;
			}
			a.comps++;
			arr[j+1] = tmp;
		}
		if(!isSorted(arr, start, end)) throw new AssertionError();
	}
	public static int[] copyIntArray(int[] arr){
		int[] brr = new int[arr.length];
		for(int i = 0; i < arr.length; i++) brr[i] = arr[i];
		return brr;
	}
	public static int[] ascendArray(int n){
		int[] brr = new int[n];
		for(int i = 0; i < n; i++) brr[i] = i;
		return brr;
	}
	public static int[] descendArray(int n){
		int[] brr = new int[n];
		for(int i = 0; i < n; i++) brr[i] = n - i;
		return brr;
	}
}
class SwapsComps{
	int swaps;
	int comps;
	
	public void zero(){
		swaps = 0;
		comps = 0;
	}
}
