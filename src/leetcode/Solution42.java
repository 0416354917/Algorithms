package leetcode;

/**
 * Trapping Rain Water.
 * <p>
 * The idea is very simple. Begin scan from beginning and end of array. Compare
 * value of left and right pointer, hold the greater one and move the other to
 * inner array. Compute passed area when pointer gets inner. (
 * {@link https://leetcode.com/discuss/63606/very-concise-java-solution-no-stack-with-explanations}
 * )
 * </p>
 * 
 * <p>
 * <b>Status: Accepted.</b>
 * </p>
 * 
 * @author Jason
 *
 */
public class Solution42 {

	public int trap(int[] height) {
		if (height == null | height.length < 3)
			return 0;

		int ans = 0;

		int left = 0;
		int right = height.length - 1;
		int secMaxHeight = 0;
		while (left < right) {
			if (height[left] < height[right]) {
				secMaxHeight = Math.max(secMaxHeight, height[left]);
				ans += secMaxHeight - height[left];
				left++;
			} else {
				secMaxHeight = Math.max(secMaxHeight, height[right]);
				ans += secMaxHeight - height[right];
				right--;
			}
		}

		return ans;
	}

	public static void main(String[] args) {
		Solution42 solution = new Solution42();

		int[] height1 = { 0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1 };
		System.out.println(solution.trap(height1));

		int[] height2 = { 4, 2, 3 };
		System.out.println(solution.trap(height2));

		int[] height3 = { 5, 4, 1, 2 };
		System.out.println(solution.trap(height3));
	}

}
