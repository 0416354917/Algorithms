package interview;

import java.util.Scanner;

/**
 * Use <b>Backtracking Algorithm</b> to solve N-Queens.
 * 
 * @author Jason
 *
 */
public class NQueens {

	public static void printMatrix(int[][] matrix) {
		int rows = matrix.length;
		int cols = matrix[0].length;
		for (int row = 0; row < rows; row++) {
			for (int col = 0; col < cols; col++) {
				System.out.print(matrix[row][col]);
				if (col != cols - 1)
					System.out.print(" ");
			}
			System.out.println();
		}
	}

	public static boolean isValidPosition(int[][] matrix, int x, int y) {
		int rows = matrix.length;
		int cols = matrix[0].length;

		int a = 0;
		int b = 0;

		// (1) fix column, check all rows:
		for (a = 0; a < rows; a++) {
			if (a == x)
				continue;
			if (matrix[a][y] == 1) {
				return false;
			}
		}

		// (2) fix row, check all columns:
		for (b = 0; b < cols; b++) {
			if (b == y)
				continue;
			if (matrix[x][b] == 1) {
				return false;
			}
		}

		// (3) check main diagonal:
		a = x - 1;
		b = y - 1;
		while (a >= 0 && b >= 0) {
			if (matrix[a][b] == 1)
				return false;
			a--;
			b--;
		}
		a = x + 1;
		b = y + 1;
		while (a < rows && b < cols) {
			if (matrix[a][b] == 1)
				return false;
			a++;
			b++;
		}

		// (4) check antidiagonal:
		a = x - 1;
		b = y + 1;
		while (a >= 0 && b < cols) {
			if (matrix[a][b] == 1)
				return false;
			a--;
			b++;
		}
		a = x + 1;
		b = y - 1;
		while (a < cols && b >= 0) {
			if (matrix[a][b] == 1)
				return false;
			a++;
			b--;
		}

		return true;
	}

	public static void solveNQueens(int n) {
		if(n < 4) {
			System.out.println("n should be at least 4!");
			System.exit(0);
		}
		
		int[][] solution = new int[n][n];
		
	}

	public static void main(String[] args) {
		System.out.println("Input n (>= 4):");
		Scanner sc = new Scanner(System.in);
		String input = sc.next();
		int n = 0;
		try {
			n = Integer.parseInt(input);
		} catch (Exception e) {
			System.out.println("Input was invalid!");
			sc.close();
			System.exit(0);
		}

		solveNQueens(n);

		sc.close();
	}

}
