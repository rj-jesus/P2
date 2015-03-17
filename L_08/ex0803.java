public class ex0803 {
	
	public static void main (String args[]) {
		
	}
	public static void mergeSort(int[] arr, int start, int end){
		if(end - start > 1){
			int mid = (end+start) / 2;
			mergeSort(arr, start, mid);
			mergeSort(arr, mid, end);
			mergeSubSort(arr, start, mid, end);
		}
	}
	public static void mergeSubSort(int[] arr, int start, int mid, int end){
		int[] brr = new int[end-start];
		int i = start, j = mid, b = 0;
		for(; i < mid && j < end; ){
			if(arr[i] < arr[j]) brr[b++] = arr[i++];
			else brr[b++] = arr[j++];
		}
		for(; i < mid; ) brr[b++] = arr[i++];
		for(; j < end; ) brr[b++] = arr[j++];
		System.arraycopy(brr, 0, arr, start, end-start);
	}
	public static void bubbleSort(int[] arr, int start, int end){
		boolean to_repeat = true;
		for(; to_repeat; ){
			to_repeat = false;
			for(int i = start+1; i < end; i++){
				if(arr[start-1] > arr[start]){
					swap(arr, start-1, start);
					to_repeat = true;
				}
			}
		}
	}
	public static void swap(int[] arr, int i, int j){
		int tmp = arr[i];
		arr[i] = arr[j];
		arr[j] = tmp;
	}
	public static void insertionSort(int[] arr, int start, int end){
		for(int i = start+1, j; i < end; i++){
			int v = arr[i];
			for(j = i-1; j >= start && arr[j] > v; j--) arr[j+1] = arr[j];
			arr[j+1] = v;
		}
	}
}

