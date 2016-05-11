package interview;

import static org.junit.Assert.assertArrayEquals;

import org.junit.Test;

public class SortingTest {

	int[] nums = { 5, 1, 6, 2, 3, 1, 3, 4, 7 };
	int[] sortedNums = { 1, 1, 2, 3, 3, 4, 5, 6, 7 };

	@Test
	public void testInsertionSort() {
		Sorting.insertionSort(nums);
		assertArrayEquals(sortedNums, nums);
	}

	@Test
	public void testSelectionSort() {
		Sorting.selectionSort(nums);
		assertArrayEquals(sortedNums, nums);
	}

	@Test
	public void testMergeSort() {
		Sorting.mergeSort(nums);
		assertArrayEquals(sortedNums, nums);
	}

	@Test
	public void testHeapSort() {
		Sorting.heapSort(nums);
		assertArrayEquals(sortedNums, nums);
	}

	@Test
	public void testQuickSort() {
		Sorting.quickSort(nums, 0, nums.length - 1);
		assertArrayEquals(sortedNums, nums);
	}

	@Test
	public void testBubbleSort() {
		Sorting.bubbleSort(nums);
		assertArrayEquals(sortedNums, nums);
	}

}
