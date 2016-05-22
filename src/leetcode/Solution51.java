package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * N-Queens.
 * 
 * <p>
 * <b>Description: </b>Given an integer n, return all distinct solutions to the
 * n-queens puzzle.
 * 
 * Each solution contains a distinct board configuration of the n-queens'
 * placement, where 'Q' and '.' both indicate a queen and an empty space
 * respectively.
 * </p>
 * 
 * <p>
 * <b>Algorithm: </b>Backtracking. Stop a subroutine as soon as possible when it
 * has been detected to be an invalid partial solution.
 * </p>
 * 
 * <p>
 * <b>Status: </b>Accepted.
 * </p>
 * 
 * @author Jason
 *
 */
public class Solution51 {

	public boolean check(List<String> ass) {
		if (ass.size() == 0)
			return true;
		else {
			int cols = ass.get(0).length();
			int rows = ass.size();
			int row = rows - 1;
			int col = ass.get(row).indexOf("Q");
			// check column:
			for (int testRow = 0; testRow < rows; testRow++) {
				if (testRow == row)
					continue;
				if (ass.get(testRow).charAt(col) == 'Q')
					return false;
			}

			// check main diagonal:
			int row1 = row - 1;
			int col1 = col - 1;
			while (row1 >= 0 && col1 >= 0) {
				if (ass.get(row1).charAt(col1) == 'Q')
					return false;
				row1--;
				col1--;
			}
			int row2 = row + 1;
			int col2 = col + 1;
			while (row2 < rows && col2 < cols) {
				if (ass.get(row2).charAt(col2) == 'Q')
					return false;
				row2++;
				col2++;
			}

			// check antidiagonal:
			row1 = row - 1;
			col1 = col + 1;
			while (row1 >= 0 && col1 < cols) {
				if (ass.get(row1).charAt(col1) == 'Q')
					return false;
				row1--;
				col1++;
			}
			row2 = row + 1;
			col2 = col - 1;
			while (row2 < rows && col2 >= 0) {
				if (ass.get(row2).charAt(col2) == 'Q')
					return false;
				row2++;
				col2--;
			}
		}

		return true;
	}

	public void backtracking(List<List<String>> ans, List<String> ass, int n) {
		if (check(ass)) {
			if (ass.size() == n) {
				ans.add(ass);
				return;
			}
		} else {
			return;
		}

		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < n; i++) {
			sb.append(".");
		}
		for (int i = 0; i < n; i++) {
			List<String> ass2 = new ArrayList<String>();
			ass.stream().forEach(s -> ass2.add(s));
			sb.setCharAt(i, 'Q');
			ass2.add(sb.toString());
			backtracking(ans, ass2, n);
			sb.setCharAt(i, '.');
		}
	}

	public List<List<String>> solveNQueens(int n) {
		List<List<String>> ans = new ArrayList<List<String>>();

		if (n == 1) {
			ans.add(Arrays.asList("Q"));
			return ans;
		}

		if (n == 2 || n == 3)
			return ans;

		List<String> ass = new ArrayList<String>();
		backtracking(ans, ass, n);

		return ans;
	}

	public static void main(String[] args) {
		Solution51 solution = new Solution51();

		Scanner sc = new Scanner(System.in);
		System.out.print("Input n: ");
		int n = sc.nextInt();
		sc.close();

		List<List<String>> ans = solution.solveNQueens(n);
		int count = 1;
		for (List<String> sol : ans) {
			System.out.println("Solution " + count + ":");
			for (String s : sol) {
				System.out.println(s);
			}
			count++;
			System.out.println();
		}
	}

}
