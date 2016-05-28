package leetcode;

/**
 * Find the Duplicate Number*.
 * 
 * <p>
 * <b>Description: </b>Given an array nums containing n + 1 integers where each
 * integer is between 1 and n (inclusive), prove that at least one duplicate
 * number must exist. Assume that there is only one duplicate number, find the
 * duplicate one.
 * 
 * Note:
 * 
 * 1. You must not modify the array (assume the array is read only).
 * 
 * 2. You must use only constant, O(1) extra space.
 * 
 * 3. Your runtime complexity should be less than O(n2).
 * 
 * 4. There is only one duplicate number in the array, but it could be repeated
 * more than once.
 * </p>
 * 
 * <p>
 * <b>Algorithm: </b>Two Pointers.
 * </p>
 * 
 * <p>
 * <b>Reference:</b>
 * {@link http://keithschwarz.com/interesting/code/find-duplicate/FindDuplicate.python.html}
 * </p>
 * 
 * <p>
 * <b>Status: </b>Accepted.
 * </p>
 * 
 * @author Jason
 *
 */
public class Solution287 {

	public int findDuplicate(int[] nums) {
		// Two-Pointers:
		// (nums: 1...n) && (index: 0...n) => nums[0] is not in the cycle.
		// => So start slow & fast pointers at index 0.
		int slow = 0, fast = 0;

		while (true) {
			slow = nums[slow];
			fast = nums[nums[fast]];
			if (slow == fast)
				break;
		}

		int finder = 0;
		while (finder != slow) {
			finder = nums[finder];
			slow = nums[slow];
		}

		return finder;
	}

	public static void main(String[] args) {
		Solution287 solution = new Solution287();

		int[] nums = { 4, 5, 2, 6, 2, 1, 2 };

		System.out.println(solution.findDuplicate(nums)); // => 2
	}

}
