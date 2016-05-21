package leetcode;

/**
 * Largest Rectangle in Histogram.
 * 
 * <p>
 * <b>Status: Accepted.</b>
 * </p>
 * 
 * @author Jason
 *
 */
public class Solution84 {

	public int largestRectangleArea(int[] heights) {
		if (heights == null || heights.length == 0) {
			return 0;
		}

		int[] lessFromLeft = new int[heights.length];
		int[] lessFromRight = new int[heights.length];

		lessFromLeft[0] = -1;
		lessFromRight[heights.length - 1] = heights.length;

		for (int i = 1; i < heights.length; i++) {
			if (heights[i] > heights[i - 1]) {
				lessFromLeft[i] = i - 1;
			} else {
				int p = i - 1;
				while (p >= 0 && heights[p] >= heights[i]) {
					p = lessFromLeft[p];
				}
				lessFromLeft[i] = p;
			}
		}

		for (int i = heights.length - 2; i >= 0; i--) {
			if (heights[i] > heights[i + 1]) {
				lessFromRight[i] = i + 1;
			} else {
				int p = i + 1;
				while (p < heights.length && heights[p] >= heights[i]) {
					p = lessFromRight[p];
				}
				lessFromRight[i] = p;
			}
		}

		int ans = 0;
		for (int i = 0; i < heights.length; i++) {
			ans = Math.max(ans,
					heights[i] * (lessFromRight[i] - lessFromLeft[i] - 1));
		}

		return ans;
	}

	public static void main(String[] args) {
		Solution84 solution = new Solution84();

		int[] heights = { 2, 1, 5, 6, 2, 3 };
		System.out.println(solution.largestRectangleArea(heights));
	}

}
