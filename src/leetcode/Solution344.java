package leetcode;

/**
 * Status: Accepted.
 * 
 * @author Jason
 *
 */
public class Solution344 {

	public String reverseString(String s) {
		// StringBuffer sb = new StringBuffer();
		// for (int i = s.length() - 1; i >= 0; i--) {
		// sb.append(s.charAt(i));
		// }
		// return sb.toString();

		return new StringBuffer(s).reverse().toString();
	}

	public static void main(String[] args) {
		String s = "hello";
		System.out.println(new Solution344().reverseString(s));
	}

}
