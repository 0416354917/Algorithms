package leetcode;

/**
 * Sudoku Solver.
 * 
 * <p>
 * <b>Status: Accepted.</b>
 * <p>
 * <b>Reference</b>:
 * {@link http://stackoverflow.com/questions/9040968/how-to-find-the-first-solution-only-with-this-backtracking}
 * </p>
 * </p>
 * <p>
 * If you are already at a solution, report success.
 * 
 * for (every possible choice in the current position ) {
 * 
 * Make that choice and take one step along the path.
 * 
 * Use recursion to solve the problem from the new position.
 * 
 * If the recursive call succeeds, report the success to the next higher level.
 * 
 * Back out of the current choice to restore the state at the beginning of the
 * loop.
 * 
 * }
 * 
 * Report failure.
 * </p>
 * 
 * @author Jason
 * 
 *
 */
public class Solution37 {

	boolean solutionFound = false;

	public boolean isValid(char[][] board, int x, int y) {
		// check row:
		for (int col = 0; col < 9; col++) {
			if (col == y)
				continue;
			if (board[x][col] == board[x][y])
				return false;
		}

		// check column:
		for (int row = 0; row < 9; row++) {
			if (row == x)
				continue;
			if (board[row][y] == board[x][y])
				return false;
		}

		// check 3 * 3 square:
		int xLow = (x / 3) * 3, yLow = (y / 3) * 3;

		for (int row = xLow; row < xLow + 3; row++) {
			for (int col = yLow; col < yLow + 3; col++) {
				if (row == x && col == y)
					continue;
				if (board[row][col] == board[x][y])
					return false;
			}
		}

		return true;
	}

	public boolean bt(char[][] board, int x, int y, int lastX, int lastY) {
		if (solutionFound)
			return true;

		for (char ch = '1'; ch <= '9' && !solutionFound; ch++) {
			board[x][y] = ch;
			if (isValid(board, x, y)) {
				if (x == lastX && y == lastY) {
					solutionFound = true;
					return true;
				}

				// find next '.':
				int nextX = x, nextY = y;
				for (nextX = x; nextX < 9; nextX++) {
					boolean flag = false;
					if (nextX == x)
						nextY = y;
					else
						nextY = 0;
					for (; nextY < 9; nextY++) {
						if (board[nextX][nextY] == '.') {
							flag = true;
							break;
						}
					}
					if (flag)
						break;
				}

				if (bt(board, nextX, nextY, lastX, lastY)) {
					solutionFound = true;
					return true;
				}
				board[x][y] = '.';
			} else {
				board[x][y] = '.';
				continue;
			}
		}

		return false;
	}

	public void solveSudoku(char[][] board) {
		int firstX = 0, firstY = 0, flag1 = 0;
		for (int row = 0; row < 9; row++) {
			flag1 = 0;
			for (int col = 0; col < 9; col++) {
				if (board[row][col] == '.') {
					firstX = row;
					firstY = col;
					flag1 = 1;
					break;
				}
			}
			if (flag1 == 1)
				break;
		}

		// if already in solved state:
		if (flag1 == 0)
			return;

		int lastX = 0, lastY = 0, flag2 = 0;
		for (int row = 8; row >= 0; row--) {
			flag2 = 0;
			for (int col = 8; col >= 0; col--) {
				if (board[row][col] == '.') {
					lastX = row;
					lastY = col;
					flag2 = 1;
					break;
				}
			}
			if (flag2 == 1)
				break;
		}

		System.out.println("x0 = " + firstX + ", y0 = " + firstY);
		System.out.println("x1 = " + lastX + ", y2 = " + lastY);

		bt(board, firstX, firstY, lastX, lastY);
	}

	public static void main(String[] args) {
		Solution37 solution = new Solution37();

		char[][] board = { { '.', '.', '9', '7', '4', '8', '.', '.', '.' },
				{ '7', '.', '.', '.', '.', '.', '.', '.', '.' },
				{ '.', '2', '.', '1', '.', '9', '.', '.', '.' },
				{ '.', '.', '7', '.', '.', '.', '2', '4', '.' },
				{ '.', '6', '4', '.', '1', '.', '5', '9', '.' },
				{ '.', '9', '8', '.', '.', '.', '3', '.', '.' },
				{ '.', '.', '.', '8', '.', '3', '.', '2', '.' },
				{ '.', '.', '.', '.', '.', '.', '.', '.', '6' },
				{ '.', '.', '.', '2', '7', '5', '9', '.', '.' } };

		solution.solveSudoku(board);

		System.out.println("Solution:");
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[0].length; j++) {
				System.out.print(board[i][j] + " ");
			}
			System.out.println();
		}
	}

}
