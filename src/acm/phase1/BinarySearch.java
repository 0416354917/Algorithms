package acm.phase1;

/**
 * Binary Search in 5-line.
 * 
 * @author Jun Chen
 *
 */
public class BinarySearch {

	public static int binarySearch(int[] arr, int left, int right, int target) {
		int mid = (left + right) >> 1;
		if (target == arr[mid])
			return mid;
		else
			return target < arr[mid] ? binarySearch(arr, left, mid, target) : binarySearch(arr, mid, right, target);
	}

	public static void main(String[] args) {
		// test cases:
		// case (1):
		int[] arr1 = { 1, 2, 3, 4, 5, 6, 7 };
		int target1 = 3;
		System.out.println(binarySearch(arr1, 0, arr1.length, target1));

		// case (2):
		int[] arr2 = { 4, 3, 2, 7, 6, 5, 1 };
		int target2 = 7;
		System.out.println(binarySearch(arr2, 0, arr2.length, target2));

	}

}
