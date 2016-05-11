package interview;

import java.util.Scanner;

public class NQueens {

	public static void main(String[] args) {
		System.out.println("Input n (>= 4):");
		Scanner sc = new Scanner(System.in);
		String input = sc.next();
		int n = 0;
		try {
			n = Integer.parseInt(input);
		} catch (Exception e) {
			System.out.println("Input was invalid!");
		}

		sc.close();
	}

}
