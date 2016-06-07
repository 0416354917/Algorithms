package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Generalized Abbreviation.
 * 
 * <p>
 * <b>Algorithm: </b>Backtracking.
 * </p>
 * 
 * <p>
 * <b>Status: </b>Accepted.
 * </p>
 * 
 * @author Jason
 *
 */
public class Solution320 {

	public void bt(List<String> ass, String word, int index) {
		StringBuffer sb = new StringBuffer(word);

		StringBuffer x = new StringBuffer();
		for (int i = 0; i < sb.length(); i++) {
			if (!Character.isDigit(sb.charAt(i))) {
				x.append(sb.charAt(i));
			} else {
				int sum = Integer.parseInt(sb.substring(i, i + 1));
				while (i + 1 < sb.length()
						&& Character.isDigit(sb.charAt(i + 1))) {
					i++;
					sum += Integer.parseInt(sb.substring(i, i + 1));
				}
				x.append(sum);
			}
		}
		ass.add(x.toString());

		for (int i = index; i < sb.length(); i++) {
			if (!Character.isDigit(sb.charAt(i))) {
				char old = sb.charAt(i);
				sb.setCharAt(i, '1');
				bt(ass, sb.toString(), i + 1);
				sb.setCharAt(i, old);
			}
		}
	}

	public List<String> generateAbbreviations(String word) {
		List<String> ans = new ArrayList<>();
		if (word == null)
			return ans;

		bt(ans, word, 0);

		return ans;
	}

	public static void main(String[] args) {
		Solution320 solution = new Solution320();

		String word = "operating";
		List<String> ans = solution.generateAbbreviations(word);
		ans.stream().forEach(x -> System.out.print(x + "  "));
	}

}
