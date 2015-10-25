import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int row = scanner.nextInt();
		int col = scanner.nextInt();
		int num_operations = scanner.nextInt();
		int[][] block = initialBlock(row, col);
		while (scanner.hasNextLine()) {
			String action = scanner.next();
			int tlr = scanner.nextInt();
			int tlc = scanner.nextInt();
			int brr = scanner.nextInt();
			int brc = scanner.nextInt();

			artBlock(action, tlr, tlc, brr, brc, block);

			//

		}
		scanner.close();

	}

	public static int[][] initialBlock(int row, int column) {
		int[][] block = new int[row][column];
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < column; j++) {
				block[i][j] = 0;
			}
		}

		return block;
	}

	public static boolean emptyBlcok(int[][] block, int tlr, int tlc, int brr,
			int brc) {
		// boolean empty=false;
		for (int i = 0; i < block.length; i++) {
			for (int j = 0; j < block[i].length; j++) {
				if (block[i][j] == 0) {
					// empty = true;
					return true;
				}
				// if(block[i][j]!=0)
				// empty=false;
				//
				// else
				// empty = true;

			}
		}

		return false;
	}

	public static int[][] artBlock(String action, int tlr, int tlc, int brr,
			int brc, int[][] block) {

		switch (action) {
		case "a":
			for (int i = tlr - 1; i <= brr - 1; i++) {
				for (int j = tlc - 1; j <= brc - 1; j++) {
					block[i][j]++;
				}
			}
			break;

		case "r":
//			if (emptyBlcok(block, tlr, tlc, brr, brc))
//				break;
//			else {
				for (int i = tlr - 1; i <= brr - 1; i++) {
					for (int j = tlc - 1; j <= brc - 1; j++) {
						block[i][j]--;
						block[i][j] = (block[i][j] < 0) ? 0 : block[i][j];
					}
				}
				break;
			//}

		case "q":
			System.out.println(sumBlock(block, tlr, tlc, brr, brc));
			break;
		}

		return block;
	}

	public static int sumBlock(int[][] block, int tlr, int tlc, int brr, int brc) {
		int sum = 0;
		for (int i = tlr - 1; i <= brr - 1; i++) {
			for (int j = tlc - 1; j <= brc - 1; j++) {
				sum += block[i][j];
			}
		}
		return sum;
	}

}
