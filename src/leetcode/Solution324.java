package leetcode;

/**
 * Wiggle Sort II.
 * 
 * <p>
 * <b>Status: .</b>
 * </p>
 * 
 * @author Jason
 *
 */
public class Solution324 {

	public int kthSmallest(int[] nums, int left, int right, int k) {
		int p = partition(nums, left, right);
		if (p == k - 1)
			return nums[p];
		else if (p > k - 1) {
			return kthSmallest(nums, left, p, k);
		} else {
			return kthSmallest(nums, p, right, k - p - 1);
		}
	}

	public int partition(int[] nums, int left, int right) {
		int pivot = nums[right - 1];
		int swapIndex = left;
		for (int i = left; i < right; i++) {
			if (nums[i] < pivot) {
				int t = nums[swapIndex];
				nums[swapIndex] = nums[i];
				nums[i] = t;
				swapIndex++;
			}
		}
		nums[right - 1] = nums[swapIndex];
		nums[swapIndex] = pivot;
		return swapIndex;
	}

	public void wiggleSort(int[] nums) {
		if (nums == null || nums.length < 2)
			return;

		int k = nums.length - nums.length / 2;
		System.out.println("k = " + k);
		// find the kth smallest/largest num in nums:
		int p = kthSmallest(nums, 0, nums.length, k);
		System.out.println("nums[p] = " + p);
//		int insertPosition = 1;
//		for (int i = k; i < nums.length; i += 1) {
//			if ((i + 1) % 2 == 0)
//				continue;
//			int t = nums[insertPosition];
//			nums[insertPosition] = nums[i];
//			nums[i] = t;
//			insertPosition += 2;
//		}
	}

	public static void main(String[] args) {
		Solution324 solution = new Solution324();

		// int[] nums = { 1, 5, 1, 1, 6, 4 };
		int[] nums = { 1, 3, 2, 2, 3, 1 };
		solution.wiggleSort(nums);

		for (int num : nums)
			System.out.println(num);
	}

}
