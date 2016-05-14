package leetcode;

/**
 * H-Index II.
 * 
 * <p>
 * <b>Status: Accepted.</b>
 * </p>
 * 
 * @author Jason
 *
 */
public class Solution275 {

	public int hIndex(int[] citations) {
		if (citations == null || citations.length == 0)
			return 0;

		int ans = 0;
		int i = 0;
		while (i < citations.length) {
			if (citations.length - i <= citations[i])
				ans = ans > citations.length - i ? ans : citations.length - i;
			i++;
		}

		return ans;
	}

	public static void main(String[] args) {
		Solution275 solution = new Solution275();

		int[] citations = { 0, 1, 2, 3, 5, 6, 7, 8 };
		System.out.println(solution.hIndex(citations));
	}

}
