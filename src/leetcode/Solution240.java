package leetcode;

/**
 * Search a 2D Matrix II.
 * 
 * <p>
 * <b>Status: .</b>
 * </p>
 * 
 * @author Jason
 *
 */
public class Solution240 {

	public boolean searchMatrix(int[][] matrix, int target) {
		if (matrix == null || matrix[0].length == 0 || matrix[0][0] > target)
			return false;
		
		boolean result = false;
		
		
		
		return result;
	}

	public static void main(String[] args) {
		int m = 5, n = 5;
		int x = 1;
		int[][] matrix = new int[m][n];
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				matrix[i][j] = x++;
			}
		}

		int target1 = 5;
		int target2 = 20;
		System.out.println(new Solution240().searchMatrix(matrix, target1));
		System.out.println(new Solution240().searchMatrix(matrix, target2));
	}

}
