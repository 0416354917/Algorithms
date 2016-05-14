package leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 * Word Ladder.
 * 
 * <p>
 * <b>Status: TLE.</b>
 * </p>
 * 
 * @author Jason
 *
 */
public class Solution127 {

	public boolean compareWords(String s1, String s2) {
		int count = 0;

		for (int i = 0; i < s1.length(); i++) {
			if (s1.charAt(i) != s2.charAt(i))
				count++;
		}

		return count == 1 ? true : false;
	}

	public int ladderLength(String beginWord, String endWord,
			Set<String> wordList) {
		if (beginWord.equals(endWord))
			return 0;

		if (compareWords(beginWord, endWord))
			return 1;

		int ans = 0;
		Set<String> frontier = new HashSet<String>();
		Set<String> explored = new HashSet<String>();
		for (String s : wordList) {
			if (compareWords(beginWord, s)) {
				if (compareWords(s, endWord))
					return 2;
				frontier.add(s);
			}
		}

		wordList.removeAll(frontier);
		if (wordList.isEmpty())
			return 0;

		ans = 2;
		while (!frontier.isEmpty()) {
			ans++;
			for (String s1 : frontier) {
				if (compareWords(s1, endWord))
					return ans;
				// System.out.print(s1 + " ");
				for (String word : wordList) {
					if (compareWords(s1, word)) {
						if (compareWords(word, endWord))
							return ans + 1;
						explored.add(word);
					}
				}
			}
			// System.out.println();
			wordList.removeAll(explored);
			if (wordList.isEmpty())
				return 0;
			frontier = explored;
			explored = new HashSet<String>();
		}

		return ans;
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
