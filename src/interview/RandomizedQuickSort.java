package interview;

import java.util.Random;
import java.util.stream.IntStream;

/**
 * Randomized QuickSort.
 * 
 * @author Jason
 *
 */
public class RandomizedQuickSort {

	public static void randomizedQuickSort(int[] nums) {
		quickSort(nums, 0, nums.length - 1);
	}

	public static void quickSort(int[] nums, int lo, int hi) {
		if (lo < hi) {
			int pivot = randomPartition(nums, lo, hi);
			quickSort(nums, lo, pivot - 1);
			quickSort(nums, pivot + 1, hi);
		}
	}

	public static int randomPartition(int[] nums, int lo, int hi) {
		Random rand = new Random();
		int r = rand.nextInt(hi - lo + 1) + lo;
		swap(nums, r, hi);
		int swapIndex = lo;
		for (int i = lo; i < hi; i++) {
			if (nums[i] <= nums[hi]) {
				swap(nums, i, swapIndex);
				swapIndex++;
			}
		}
		swap(nums, swapIndex, hi);
		return swapIndex;
	}

	public static void swap(int[] nums, int index1, int index2) {
		int t = nums[index1];
		nums[index1] = nums[index2];
		nums[index2] = t;
	}

	public static void main(String[] args) {
		int[] nums = { 3, 7, 1, 4, 2, 6, 8, 5, 9, 6 };

		randomizedQuickSort(nums);
		IntStream.of(nums).forEach(x -> System.out.println(x));
	}

}