package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Status: Accepted.
 * 
 * @author Jason
 *
 */
public class Solution345 {

	public String reverseVowels(String s) {
		StringBuffer sb = new StringBuffer(s);
		List<Integer> index = new ArrayList<Integer>();
		List<String> chars = new ArrayList<String>();
		List<String> vowels = new ArrayList<String>();

		vowels.add("a");
		vowels.add("e");
		vowels.add("i");
		vowels.add("o");
		vowels.add("u");

		for (int i = 0; i < sb.length(); i++) {
			String sub = sb.substring(i, i + 1);
			if (vowels.contains(sub.toLowerCase())) {
				index.add(i);
				chars.add(sub);
			}
		}

		for (int i = 0; i < index.size(); i++) {
			sb.setCharAt(index.get(i),
					chars.get(index.size() - i - 1).charAt(0));
		}

		return sb.toString();
	}

	public static void main(String[] args) {
		String s = "Leetcode";
		System.out.println(new Solution345().reverseVowels(s));
	}

}
