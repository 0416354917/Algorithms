/**
 * Given two words word1 and word2, find the minimum number of steps required to convert word1 to word2. 
 * (each operation is counted as 1 step.)
 * You have the following 3 operations permitted on a word:
 * a) Insert a character
 * b) Delete a character
 * c) Replace a character
 */
package leetcode;

/**
 * Dynamic Programming.
 * 
 * @author Jason
 *
 */
public class EditDistance {

	static int minDistance(String word1, String word2) {
		if (word1.length() == 0) {
			return word2.length();
		} else if (word2.length() == 0) {
			return word1.length();
		}
		return 0;
	}

	public static void main(String[] args) {
		String word1 = "fan";
		String word2 = "fun";
		System.out.println(word1 + " --> " + word2 + " needs (steps): "
				+ minDistance(word1, word2));
	}

}
