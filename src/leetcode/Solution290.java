package leetcode;

import java.util.HashMap;

/**
 * Word Pattern.
 * 
 * Status: Accepted.
 * 
 * @author Jason
 *
 */
public class Solution290 {

	public boolean wordPattern(String pattern, String str) {
		String[] arr = str.split(" ");
		if (pattern.length() != arr.length)
			return false;
		HashMap<Character, String> map = new HashMap<Character, String>();
		for (int i = 0; i < pattern.length(); i++) {
			char ch = pattern.charAt(i);
			if (!map.containsKey(ch)) {
				if (map.containsValue(arr[i]))
					return false;
				else
					map.put(ch, arr[i]);
			} else {
				// if (!(((String) map.get(ch)).equals(arr[i])))
				if (!map.get(ch).equals(arr[i]))
					return false;
			}
		}
		return true;
	}

	public static void main(String[] args) {
		String pattern = "abba";
		String str = "dog cat cat dog";
		System.out.println(new Solution290().wordPattern(pattern, str));
	}

}
