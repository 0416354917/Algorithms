package leetcode;

/**
 * Word Search.
 * 
 * <p>
 * <b>Description: </b> Given a 2D board and a word, find if the word exists in
 * the grid.
 * 
 * The word can be constructed from letters of sequentially adjacent cell, where
 * "adjacent" cells are those horizontally or vertically neighboring. The same
 * letter cell may not be used more than once.
 * 
 * </p>
 * 
 * <p>
 * <b>Algorithm: </b>Backtracking.
 * </p>
 * 
 * <p>
 * <b>Status: </b>Accepted.
 * </p>
 * 
 * @author Jason
 *
 */
public class Solution79 {

	public boolean bt(char[][] board, String word, int i, int j,
			StringBuffer sb) {
		if (sb.charAt(sb.length() - 1) != word.charAt(sb.length() - 1)) {
			return false;
		} else {
			if (sb.toString().equals(word))
				return true;
		}

		// (1) up:
		if (i - 1 >= 0) {
			sb.append(board[i - 1][j]);
			board[i - 1][j] = '#';
			if (bt(board, word, i - 1, j, sb)) {
				board[i - 1][j] = sb.charAt(sb.length() - 1);
				return true;
			} else {
				board[i - 1][j] = sb.charAt(sb.length() - 1);
				sb.deleteCharAt(sb.length() - 1);
			}
		}

		// (2) right:
		if (j + 1 < board[0].length) {
			sb.append(board[i][j + 1]);
			board[i][j + 1] = '#';
			if (bt(board, word, i, j + 1, sb)) {
				board[i][j + 1] = sb.charAt(sb.length() - 1);
				return true;
			} else {
				board[i][j + 1] = sb.charAt(sb.length() - 1);
				sb.deleteCharAt(sb.length() - 1);
			}
		}

		// (3) down:
		if (i + 1 < board.length) {
			sb.append(board[i + 1][j]);
			board[i + 1][j] = '#';
			if (bt(board, word, i + 1, j, sb)) {
				board[i + 1][j] = sb.charAt(sb.length() - 1);
				return true;
			} else {
				board[i + 1][j] = sb.charAt(sb.length() - 1);
				sb.deleteCharAt(sb.length() - 1);
			}
		}

		// (4) left:
		if (j - 1 >= 0) {
			sb.append(board[i][j - 1]);
			board[i][j - 1] = '#';
			if (bt(board, word, i, j - 1, sb)) {
				board[i][j - 1] = sb.charAt(sb.length() - 1);
				return true;
			} else {
				board[i][j - 1] = sb.charAt(sb.length() - 1);
				sb.deleteCharAt(sb.length() - 1);
			}
		}

		return false;
	}

	public boolean exist(char[][] board, String word) {
		// corner cases:
		if ((board == null || board.length == 0)) {
			if (word == null || word.length() == 0)
				return true;
			else
				return false;
		} else if (word == null || word.length() == 0) {
			return false;
		}

		// main algorithm:
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[0].length; j++) {
				if (board[i][j] == word.charAt(0)) {
					StringBuffer sb = new StringBuffer();
					sb.append(board[i][j]);
					board[i][j] = '#';
					if (bt(board, word, i, j, sb))
						return true;
					else
						board[i][j] = sb.charAt(0);
				}
			}
		}

		return false;
	}

	public static void main(String[] args) {
		Solution79 solution = new Solution79();

		char[][] board = { { 'A', 'B', 'C', 'E' }, { 'S', 'F', 'C', 'S' },
				{ 'A', 'D', 'E', 'E' } };

		String word1 = "ABCCED";
		System.out.println(solution.exist(board, word1)); // true

		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[0].length; j++) {
				System.out.print(board[i][j] + " ");
			}
			System.out.println();
		}

		String word2 = "SEE";
		System.out.println(solution.exist(board, word2)); // true

		String word3 = "ABCB";
		System.out.println(solution.exist(board, word3)); // false

		char[][] board4 = { { 'a', 'a' } };
		String word4 = "aaa";
		System.out.println(solution.exist(board4, word4)); // false
	}

}
