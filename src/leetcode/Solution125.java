package leetcode;

/**
 * Valid Palindrome.
 * 
 * <p>
 * <b>Status: Accepted</b>.
 * </p>
 * 
 * @author Jason
 *
 */
public class Solution125 {

	public boolean isPalindrome(String s) {
		if (s == null || s.trim().length() == 0)
			return true;

		String t = s.trim().toLowerCase();
		int i = 0, j = t.length() - 1;
		while (i != j) {
			char ch1 = t.charAt(i);
			while (!((ch1 >= 'a' && ch1 <= 'z')
					|| (ch1 >= '0' && ch1 <= '9'))) {
				i++;
				if (i == j)
					return true;
				ch1 = t.charAt(i);
			}

			char ch2 = t.charAt(j);
			while (!((ch2 >= 'a' && ch2 <= 'z')
					|| (ch2 >= '0' && ch2 <= '9'))) {
				j--;
				if (j == i)
					return true;
				ch2 = t.charAt(j);
			}

			if (ch1 != ch2)
				return false;
			else {
				if (i + 1 == j)
					return true;
				else {
					i++;
					j--;
				}
			}
		}

		return true;
	}

	public static void main(String[] args) {
		String s1 = "A man, a plan, a canal: Panama";
		String s2 = "race a car";
		System.out.println(new Solution125().isPalindrome(s1));
		System.out.println(new Solution125().isPalindrome(s2));
	}

}
