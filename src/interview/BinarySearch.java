package interview;

/**
 * Binary Search Implementation (iteratively and recursively).
 * 
 * @author Jason
 *
 */
public class BinarySearch {

	public static int binarySearchIteratively(int[] nums, int target) {
		int left = 0, right = nums.length - 1;
		while (left <= right) {
			int mid = left + ((right - left) >> 1);
			if (target == nums[mid])
				return mid;
			else if (target < nums[mid])
				right = mid - 1;
			else
				left = mid + 1;
		}
		return -1;
	}

	public static int binarySearchRecursively(int[] nums, int target, int left,
			int right) {
		if (left > right)
			return -1;

		int mid = left + ((right - left) >> 1);
		if (target == nums[mid])
			return target;
		else if (target < nums[mid])
			return binarySearchRecursively(nums, target, left, mid - 1);
		else
			return binarySearchRecursively(nums, target, mid + 1, right);
	}

	public static void main(String[] args) {
		int[] nums = { 1, 2, 3, 4, 5, 6, 7, 7, 8, 9 };
		int target = 7;

		System.out.println("binarySearchIteratively ans: "
				+ binarySearchIteratively(nums, target));

		System.out.println("binarySearchRecursively ans: "
				+ binarySearchRecursively(nums, target, 0, nums.length));
	}

}