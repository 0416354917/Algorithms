package leetcode;

public class ValidPalindrome {

	/**
	 * 
	 * @param s
	 * @return
	 */
	public static boolean isPalindrome(String s) {
		int n = s.length();
		if (n == 0) {
			return true;
		}
		int i = 0, j = n - 1;
		String s1 = "", s2 = "";
		while (i < n) {
			if (Character.isLetterOrDigit(s.charAt(i))) {
				s1 += s.charAt(i);
			}
			i++;
		}
		s1 = s1.toLowerCase();
		while (j >= 0) {
			if (Character.isLetterOrDigit(s.charAt(j))) {
				s2 += s.charAt(j);
			}
			j--;
		}
		s2 = s2.toLowerCase();
		// System.out.println(s1 + " ---> " + s2);
		if (s1.equals(s2)) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * -- Two Pointers.
	 * 
	 * @param s
	 * @return
	 */
	public static boolean isPalindrome2(String s) {
		int n = s.length();
		if (n == 0) {
			return true;
		}
		int i = 0, j = n - 1;
		while (i <= j - 1) {
			while (i < n && !Character.isLetterOrDigit(s.charAt(i))) {
				i += 1;
			}
			while (j >= 0 && !Character.isLetterOrDigit(s.charAt(j))) {
				j -= 1;
			}
			// System.out.println(s.charAt(i) + " --> " + s.charAt(j));

			if (i > n - 1 && j < 0) {
				return true;
			}

			if (j < i) {
				return false;
			} else if (Character.toLowerCase(s.charAt(i)) != Character.toLowerCase(s.charAt(j))) {
				return false;
			} else {
				i++;
				j--;
			}
			// System.out.println(i + ", " + j);
		}
		return true;
	}

	public static void main(String[] args) {
		String s = "A man, a plan, a canal: Panama";
		String t = "race a car";
		String x = "!!!";
		String y = "ab";
		String z = ".,";
		String a = "1a2";

		System.out.println(isPalindrome(s));
		System.out.println(isPalindrome2(s));

		System.out.println(isPalindrome(t));
		System.out.println(isPalindrome2(t));

		System.out.println(isPalindrome(x));
		System.out.println(isPalindrome2(x));
		System.out.println(isPalindrome(y));
		System.out.println(isPalindrome2(y));

		System.out.println(isPalindrome(z));
		System.out.println(isPalindrome2(z));

		System.out.println(isPalindrome(a));
		System.out.println(isPalindrome2(a));

	}

}
