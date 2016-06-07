package leetcode;

/**
 * Reverse Words in a String II.
 * 
 * <p>
 * <b>Algorithm: </b>String.
 * </p>
 * 
 * <p>
 * <b>Status: </b>Accepted.
 * </p>
 * 
 * @author Jason
 *
 */
public class Solution186 {

	public void reverseWords(char[] s) {
		// corner cases:
		if (s == null || s.length == 0)
			return;

		boolean containsSpace = false;
		for (int k = 0; k < s.length; k++) {
			if (s[k] == ' ') {
				containsSpace = true;
				break;
			}
		}

		if (!containsSpace)
			return;

		int n = s.length;
		int i = 0, j = n - 1;
		while (i < j) {
			swap(s, i, j);
			i++;
			j--;
		}

		i = 0;
		while (i < n - 1) {
			j = i + 1;
			while (j < n) {
				if (s[j] == ' ' || j == n - 1) {
					int p = i;
					int q = j - 1;
					if (j == n - 1) {
						q = n - 1;
					}
					while (p < q) {
						swap(s, p, q);
						p++;
						q--;
					}
					i = j + 1;
					break;
				}
				j++;
			}
		}

	}

	public void swap(char[] s, int i, int j) {
		char t = s[i];
		s[i] = s[j];
		s[j] = t;
	}

	public static void main(String[] args) {
		Solution186 solution = new Solution186();

		char[] s = "hello world!".toCharArray();
		solution.reverseWords(s);
		System.out.println(new StringBuffer().append(s).toString());
	}

}
