package interview;

/**
 * Common sorting algorithms.
 * 
 * @author Jason
 */
public class Sorting {

	/**
	 * Insertion Sort.
	 * 
	 * <p>
	 * Stable, in-place sorting algorithm.
	 * </p>
	 * <p>
	 * Time complexity: O(n) in best case, O(n^2) in worst case.
	 * </p>
	 * 
	 * @param nums
	 */
	public static void insertionSort(int[] nums) {
		for (int i = 1; i < nums.length; i++) {
			while (nums[i] < nums[i - 1]) {
				int t = nums[i];
				nums[i] = nums[i - 1];
				nums[i - 1] = t;
				i--;
				if (i == 0)
					break;
			}
		}
	}

	/**
	 * Selection Sort.
	 * 
	 * <p>
	 * In-place comparison-based sorting algorithm.
	 * </p>
	 * <p>
	 * Time Complexity: O(n^2).
	 * </p>
	 * 
	 * @param nums
	 */
	public static void selectionSort(int[] nums) {
		for (int i = 0; i < nums.length - 1; i++) {
			int minIndex = i;
			int min = nums[i];
			for (int j = i + 1; j < nums.length; j++) {
				if (nums[j] < min) {
					minIndex = j;
					min = nums[j];
				}
			}
			int t = nums[minIndex];
			nums[minIndex] = nums[i];
			nums[i] = t;
		}
	}

	/**
	 * Merge Sort.
	 * 
	 * <p>
	 * Comparison-based sorting algorithm.
	 * </p>
	 * 
	 * @param nums
	 */
	public static void mergeSort(int[] nums) {
		int n = nums.length;
		int[] tempArray = new int[n];
		split(nums, tempArray, 0, n);
	}

	public static void split(int[] A, int[] B, int begin, int end) {
		if (end - begin < 2)
			return;
		// incorrect below!
		// int mid = (end - begin) / 2;
		int mid = (begin + end) / 2;
		split(A, B, begin, mid);
		split(A, B, mid, end);
		merge(A, B, begin, mid, end);
		copyArray(A, B, begin, end);
	}

	public static void merge(int[] A, int[] B, int begin, int mid, int end) {
		int i = begin, j = mid;
		for (int k = begin; k < end; k++) {
			// incorrect below!
			// if (i < mid && (A[i] <= A[j] || j >= end)) {
			if (i < mid && (j >= end || A[i] <= A[j])) {
				B[k] = A[i];
				i++;
			} else {
				B[k] = A[j];
				j++;
			}
		}
	}

	public static void copyArray(int[] A, int[] B, int begin, int end) {
		for (int i = begin; i < end; i++) {
			A[i] = B[i];
		}
	}

	/**
	 * 
	 * Heap Sort.
	 * 
	 * <p>
	 * In-place comparison-based sorting algorithm. Not stable.
	 * </p>
	 * 
	 * @param nums
	 */
	public static void heapSort(int[] nums) {
		buildMaxHeap(nums);
		for (int index = nums.length - 1; index >= 0; index--) {
			swap(nums, 0, index);
			heapify(nums, 0, index);
		}
	}

	public static void heapify(int[] nums, int index, int endIndex) {
		int leftIndex = 2 * index + 1;
		int rightIndex = 2 * index + 2;
		if (leftIndex >= endIndex)
			return;
		int swapIndex = index;
		if (nums[leftIndex] > nums[index])
			swapIndex = leftIndex;
		if (rightIndex < endIndex) {
			if (nums[rightIndex] > nums[leftIndex]
					&& nums[rightIndex] > nums[index]) {
				swapIndex = rightIndex;
			}
		}

		if (swapIndex != index) {
			swap(nums, index, swapIndex);
			heapify(nums, swapIndex, endIndex);
		}
	}

	public static void buildMaxHeap(int[] nums) {
		for (int i = nums.length / 2 - 1; i >= 0; i--) {
			heapify(nums, i, nums.length);
		}
	}

	public static void swap(int[] nums, int index1, int index2) {
		int t = nums[index1];
		nums[index1] = nums[index2];
		nums[index2] = t;
	}

	/**
	 * Quick Sort.
	 * 
	 * <p>
	 * In-place comparison-based sorting algorithm.
	 * </p>
	 * <p>
	 * Time Complexity: O(nlogn).
	 * </p>
	 * 
	 * @param nums
	 * @param low
	 * @param high
	 */
	public static void quickSort(int[] nums, int low, int high) {
		if (low < high) {
			int pivotIndex = partition(nums, low, high);
			quickSort(nums, low, pivotIndex - 1);
			quickSort(nums, pivotIndex + 1, high);
		}
	}

	public static int partition(int[] nums, int low, int high) {
		int pivot = nums[high];
		int swapIndex = low;
		for (int i = low; i < high; i++) {
			if (nums[i] < pivot) {
				int t = nums[i];
				nums[i] = nums[swapIndex];
				nums[swapIndex] = t;
				swapIndex++;
			}
		}
		nums[high] = nums[swapIndex];
		nums[swapIndex] = pivot;
		return swapIndex;
	}

	/**
	 * Bubble Sort.
	 * 
	 * <p>
	 * In-place comparison-based sorting algorithm.
	 * </p>
	 * <p>
	 * Time Complexity: O(n^2).
	 * </p>
	 * 
	 * @param nums
	 */
	public static void bubbleSort(int[] nums) {
		boolean swapped = true;
		for (int i = 1; i < nums.length && swapped; i++) {
			swapped = false;
			for (int j = 0; j < nums.length - i; j++) {
				if (nums[j] > nums[j + 1]) {
					int t = nums[j];
					nums[j] = nums[j + 1];
					nums[j + 1] = t;
					swapped = true;
				}
			}
		}
	}

	public static void main(String[] args) {

	}

}
