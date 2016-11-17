import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int res = 0;
		String s1 = sc.next();
		String s2 = sc.next();

		// s1 = "abcdef";
		// s2 = "gcdemf";

		int n = s1.length();
		int m = s2.length();
		int[][] dp = new int[n + 1][m + 1];
		for (int i = 0; i <= n; i++) {
			for (int j = 0; j <= m; j++) {
				dp[i][j] = 0;
			}
		}

		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= m; j++) {
				if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
					dp[i][j] = dp[i - 1][j - 1] + 1;
					res = dp[i][j] > res ? dp[i][j] : res;
				}
			}
		}

		sc.close();

		System.out.println(res);
	}

}