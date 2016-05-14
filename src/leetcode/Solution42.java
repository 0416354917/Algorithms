package leetcode;

/**
 * Trapping Rain Water.
 * 
 * <p>
 * <b>Status: TLE.</b>
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
		int i = 0;
		while (i < height.length - 1) {
			if (height[i] <= height[i + 1])
				i++;
			else
				break;
		}
		while (i < height.length - 2) {
			// System.out.println("i = " + i);

			int j = i;
			while (j < height.length - 1 && height[j + 1] < height[j]) {
				j++;
			}
			if (j >= height.length - 1)
				break;
			// System.out.println("j = " + j);

			int k = j;
			while (k < height.length - 1 && height[k + 1] >= height[k]) {
				k++;
			}
			// System.out.println("k = " + k);

			int i2 = j - 1;
			while (i2 >= i + 1 && height[i2] < height[k]) {
				i2--;
			}

			int subans = (k - i2 - 1) * Math.min(height[i2], height[k]);
			for (int t = i2 + 1; t < k; t++)
				subans -= height[t];
			ans += subans;
			i = k;

			// System.out.println("ans = " + ans);
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
