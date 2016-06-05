package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Shortest Word Distance II.
 * 
 * <p>
 * <b>Status: </b>...
 * </p>
 * 
 * @author Jason
 *
 */
public class Solution244 {
	public class WordDistance {

		Map<String, List<Integer>> map;

		public WordDistance(String[] words) {
			this.map = new HashMap<>();
			for (int i = 0; i < words.length; i++) {
				List<Integer> index = map.get(words[i]);
				if (index == null) {
					index = new ArrayList<>();
					map.put(words[i], index);
				}
				index.add(i);
			}
			for (String word : map.keySet()) {
				map.get(word).sort(null);
			}
		}

		public int shortest(String word1, String word2) {
			int ans = Integer.MAX_VALUE;

			List<Integer> index1 = map.get(word1);
			List<Integer> index2 = map.get(word2);

			int i1 = 0, i2 = 0;
			int v1 = index1.get(i1);
			int v2 = index2.get(i2);
			while (i1 < index1.size() || i2 < index2.size()) {
				ans = Math.min(Math.abs(v1 - v2), ans);
				if ((v1 > v2 || i1 >= index1.size()) && i2 < index2.size()) {
					i2++;
					if (i2 < index2.size()) {
						v2 = index2.get(i2);
					}
				} else {
					i1++;
					if (i1 < index1.size()) {
						v1 = index1.get(i1);
					}
				}
			}
			return ans;
		}
	}

	public static void main(String[] args) {
		Solution244 solution = new Solution244();

		String[] words = { "practice", "makes", "perfect", "coding", "makes" };
		WordDistance wordDistance = solution.new WordDistance(words);
		System.out.println(wordDistance.shortest("practice", "coding"));
	}

}
