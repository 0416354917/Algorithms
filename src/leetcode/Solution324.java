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
		if (left < right) {
			int p = partition(nums, left, right);
			if (p == k - 1)
				return nums[p];
			else if (p > k - 1) {
				return kthSmallest(nums, left, p, k);
			} else {
				return kthSmallest(nums, p + 1, right, k - p - 1);
			}
		}

		return nums[left];
	}

	public int partition(int[] nums, int left, int right) {
		int pivot = nums[right - 1];
		int swapIndex = left;
		for (int i = left; i < right - 1; i++) {
			if (nums[i] <= pivot) {
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
		kthSmallest(nums, 0, nums.length, k);

//		System.out.println("p = " + p);
//		for (int num : nums)
//			System.out.print(num + "  ");
//		System.out.println();

		int p = k - 1;
		int t = nums[1];
		int index = 1;
		int newIndex = 2;
		while (true) {
			if (index <= p) {
				newIndex = index * 2;
			} else {
				newIndex = (index - p - 1) * 2 + 1;
			}

			int x = nums[newIndex];
			nums[newIndex] = t;
			t = x;
			index = newIndex;
			if (index == 1)
				break;
		}
	}

	public static void main(String[] args) {
		Solution324 solution = new Solution324();

		int[] nums = { 1, 5, 1, 1, 6, 4 };
		// int[] nums = { 1, 2, 3, 4, 5, 6, 7 };
		// int[] nums = { 1, 3, 2, 2, 3, 1 };
		solution.wiggleSort(nums);

		for (int num : nums)
			System.out.println(num);
	}

}
