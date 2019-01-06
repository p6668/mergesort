import java.util.ArrayList;
import java.util.Scanner;
/**
 * A merge sort program using ArrayList
 * @author Zifan Yang
 *
 */
public class MergeSort {
	public static int numOfComparisons = 0;
	/**
	 * ArrayList based implementation of merge sort
	 * @param List the list of integers to be sorted 
	 */
	public static void mergeSort(ArrayList<Integer> List){
		
		int size = List.size();
		int mid = size / 2;
		// return if there is only one element left
		if (size < 2) return;
		// create two separate lists
		 ArrayList<Integer> List1 = new ArrayList<Integer>();
		 ArrayList<Integer> List2 = new ArrayList<Integer>();
		 //copy lists
	     for(int i = 0; i < mid; i++){
	        List1.add(List.get(i));
	     }
	     for(int i = mid ; i < size; i++){
	        List2.add(List.get(i));
	     }

		// recursive merge
		mergeSort(List1);
		mergeSort(List2);
		
		merge(List1, List2, List);
		
		
	}
	/**
	 * Merge the elements back to the original list
	 * @param List1 left half list
	 * @param List2 right half list
	 * @param List original list
	 */
	private static void merge(ArrayList<Integer> List1, ArrayList<Integer> List2, ArrayList<Integer> List) {
		int i = 0;
		int j = 0;
		// merge the two lists back to the original
		while (i + j < List.size()){
			if(j == List2.size() || (i < List1.size() && List1.get(i) < List2.get(j))){
				List.set(i + j, List1.get(i++));
			}
			else{
				List.set(i + j, List2.get(j++));
			}
			numOfComparisons++;
		}
		
		
	}
	
	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in);
		ArrayList<Integer> test = new ArrayList<Integer>();
		System.out.print("Enter the size of the list: ");
		int n = input.nextInt();
		for (int i = 0; i < n; i++){
			System.out.print("Enter a value for [" + i + "]: ");
			int value = input.nextInt();
			test.add(value);
		}
		System.out.println("Unsorted List:");
		System.out.println(test);
		mergeSort(test);
		System.out.println("Sorted List:");
		System.out.println(test);
		System.out.println("Comparisons made:");
		System.out.println(numOfComparisons);
		

	}

}
