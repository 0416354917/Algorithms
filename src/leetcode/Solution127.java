package leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 * Word Ladder.
 * 
 * <p>
 * <b>Description: </b>
 * 
 * Given two words (beginWord and endWord), and a dictionary's word list, find
 * the length of shortest transformation sequence from beginWord to endWord,
 * such that:
 * 
 * Only one letter can be changed at a time Each intermediate word must exist in
 * the word list For example,
 * 
 * Given: beginWord = "hit" endWord = "cog" wordList =
 * ["hot","dot","dog","lot","log"] As one shortest transformation is "hit" ->
 * "hot" -> "dot" -> "dog" -> "cog", return its length 5.
 * 
 * Note: Return 0 if there is no such transformation sequence. All words have
 * the same length. All words contain only lowercase alphabetic characters.
 * </p>
 * 
 * <p>
 * <b>Algorithm: </b>(Two-Ends) Breadth-First Search.
 * </p>
 * 
 * <p>
 * <b>Reference: </b>
 * {@link https://leetcode.com/discuss/68935/two-end-bfs-in-java-31ms}
 * </p>
 * 
 * <p>
 * <b>Note: </b>
 * 
 * "The idea behind bidirectional search is to run two simultaneous searches—one
 * forward from the initial state and the other backward from the goal—hoping
 * that the two searches meet in the middle. The motivation is that b^(d/2) +
 * b^(d/2) is much less than b^d. b is branch factor, d is depth. " </br>
 * 
 * {@link section 3.4.6 in Artificial Intelligence - A modern approach by Stuart
 * Russel and Peter Norvig}
 * <p>
 * 
 * <p>
 * <b>Status: </b>Accepted.
 * </p>
 * 
 * @author Jason
 *
 */
public class Solution127 {

	/**
	 * Two-Ends BFS.
	 * 
	 * Status: Accepted.
	 * 
	 * @param beginWord
	 * @param endWord
	 * @param wordList
	 * @return
	 */
	public int ladderLength(String beginWord, String endWord,
			Set<String> wordList) {
		int ans = 1;
		Set<String> set1 = new HashSet<String>();
		Set<String> set2 = new HashSet<String>();
		Set<String> visited = new HashSet<String>();
		set1.add(beginWord);
		set2.add(endWord);
		while (!set1.isEmpty() && !set2.isEmpty()) {
			// Always loops through the smaller set.
			if (set1.size() > set2.size()) {
				Set<String> temp = set1;
				set1 = set2;
				set2 = temp;
			}

			Set<String> temp = new HashSet<String>();
			for (String x : set1) {
				char[] arr = x.toCharArray();
				for (int i = 0; i < arr.length; i++) {
					char old = arr[i];
					for (char newChar = 'a'; newChar <= 'z'; newChar++) {
						arr[i] = newChar;
						String y = String.valueOf(arr);
						if (set2.contains(y)) {
							return ans + 1;
						} else {
							if (!visited.contains(y) && wordList.contains(y)) {
								visited.add(y);
								temp.add(y);
							}
						}
					}
					arr[i] = old;
				}
			}

			set1 = temp;

			ans++;
		}

		return 0;
	}

	public static void main(String[] args) {
		Solution127 solution = new Solution127();

		String beginWord = "hit";
		String endWord = "cog";
		Set<String> wordList = new HashSet<String>();
		wordList.add("hot");
		wordList.add("dot");
		wordList.add("dog");
		wordList.add("lot");
		wordList.add("log");

		System.out.println(solution.ladderLength(beginWord, endWord, wordList));
	}

}
