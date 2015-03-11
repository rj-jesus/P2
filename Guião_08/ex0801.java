public class ex0801 {
	
	public static void main (String args[]) {
		
	}
	public static void mergeSort(int[] arr, int start, int end){
		assert start >= 0 && end <= arr.length;
		int mid;
		if(end - start > 1){
			mid = (end + start) / 2;
			mergeSort(arr, start, mid);
			mergeSort(arr, mid, end);
			mergeSubSort(arr, start, mid, end);
		}
	}
	public static void mergeSubSort(int[] arr, int start, int mid, int end){
		int[] brr = new int[end-start];
		int b = 0;
		int i = start, j = mid;
		for(; i < mid && j < end; ){
			if(arr[i] < arr[j]) brr[b++] = arr[i++];
			else brr[b++] = arr[j++];
		}
		for(; i < mid; ) brr[b++] = arr[i++];
		for(; j < end; ) brr[b++] = arr[j++];
		System.arraycopy(brr, 0, arr, start, end - start);
	}
}

