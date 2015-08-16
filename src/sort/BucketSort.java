package sort;

/**
 * 
 * @author Jason
 *
 */
public class BucketSort {

	static void bucketSort(int[] nums, int k) {
		int[] bucket = new int[k];
		for (int num : nums)
			bucket[num] = num;
		for (int num : bucket) {
			if (num != 0) {
				System.out.println(num);
			}
		}
	}

	public static void main(String[] args) {
		int[] arr = { 1, 5, 3, 2, 4, 8, 9, 7, 6 };
		int k = 10;
		bucketSort(arr, k);
	}

}
