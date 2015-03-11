import java.util.Scanner;
import java.io.*;

public class ex0804 {
	
	public static void main (String args[]) throws IOException{
		if(args == null || args.length != 1){
			System.out.print("ERRO: Argumentos inválidos.\nUtilização:\njava ex0804.java <file_name>\n");
			System.exit(1);
		}
		String[] words = extractsWords(new File(args[0]));
		mergeSort(words, 0, words.length);
		System.out.printf("Total de %d palavra(s).\n", words.length);
		words = deleteRepetitions(words);
		for(int i = 0; i < words.length; i++) System.out.printf("%d. %s\n", i+1, words[i]);
	}
	public static String[] deleteNulls(String[] arr){
		int del = 0;
		for(int i = 0; i < arr.length; i++){
			if(arr[i] == null) del++;
		}
		String[] brr = new String[arr.length - del];
		for(int i = 0, j = 0; i < arr.length; i++){
			if(arr[i] != null) brr[j++] = arr[i];
		}
		return brr;
	}
	public static String[] deleteRepetitions(String[] arr){
		int del = 0;
		for(int i = 1; i < arr.length; i++){
			if(arr[i] != null && arr[i].equals(arr[i-1])){
				arr[i] = null;
				del++;
			}
		}
		if(del != 0){
			arr = deleteNulls(arr);
			arr = deleteRepetitions(arr);
		}
		else arr = deleteNulls(arr);
		return arr;
	}
	public static void mergeSort(String[] arr, int start, int end){
		if(end - start > 1){
			int mid = (end + start) / 2;
			mergeSort(arr, start, mid);
			mergeSort(arr, mid, end);
			mergeSubSort(arr, start, mid, end);
		}
	}
	public static void mergeSubSort(String[] arr, int start, int mid, int end){
		String[] brr = new String[end-start];
		int i = start, j = mid, b = 0;
		for(; i < mid && j < end; ){
			if(arr[i].compareTo(arr[j]) < 0) brr[b++] = arr[i++];
			else brr[b++] = arr[j++];
		}
		for(; i < mid; ) brr[b++] = arr[i++];
		for(; j < end; ) brr[b++] = arr[j++];
		System.arraycopy(brr, 0, arr, start, end-start);
	}
	static String[] extractsWords(File fin) throws IOException{
      assert fin != null;
      assert !fin.isDirectory(); // Note that this precondition does not 100% ensure this kind of assertion!
      assert fin.canRead();      // Note that this precondition does not 100% ensure this kind of assertion!

      // count the words
      int n = 0;
      Scanner scf = new Scanner(fin).useDelimiter("[\\p{Punct}\\p{Space}]+");
      while(scf.hasNext())
      {
         scf.next();
         n++;
      }
      scf.close();

      String[] result = new String[n];

      // read the words
      int i = 0;
      scf = new Scanner(fin).useDelimiter("[\\p{Punct}\\p{Space}]+");
      while(scf.hasNext())
      {
         result[i] = scf.next();
         i++;
      }
      scf.close();

      return result;
   }
}

