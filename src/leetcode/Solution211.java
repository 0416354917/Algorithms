package leetcode;

import java.util.HashMap;

/**
 * Add and Search Word - Data structure design.
 * 
 * <p>
 * <b>Status: TLE.</b>
 * </p>
 * 
 * @author Jason
 *
 */
public class Solution211 {

	class TrieNode {
		String key = null;
		HashMap<String, TrieNode> children = new HashMap<String, TrieNode>();

		public TrieNode() {

		}

		public TrieNode(String key) {
			this.key = key;
		}
	}

	public class WordDictionary {
		TrieNode root;

		public WordDictionary() {
			this.root = new TrieNode();
		}

		// Adds a word into the data structure.
		public void addWord(String word) {
			if (word == null)
				return;

			TrieNode p = root;
			for (int i = 0; i < word.length(); i++) {
				String s = word.substring(i, i + 1);
				if (p.children.containsKey(s))
					p = p.children.get(s);
				else {
					TrieNode q = new TrieNode(s);
					p.children.put(s, q);
					p = q;
				}
			}
			if (!p.children.containsKey("#"))
				p.children.put("#", new TrieNode("#"));

		}

		// Returns if the word is in the data structure. A word could
		// contain the dot character '.' to represent any one letter.
		public boolean search(String word) {
			if (word == null)
				return true;

			TrieNode p = root;
			int i = 0;
			for (; i < word.length(); i++) {
				String key = word.substring(i, i + 1);
				if (key.equals(".")) {
					StringBuffer sb = new StringBuffer(word);
					for (char ch = 'a'; ch <= 'z'; ch++) {
						sb.setCharAt(i, ch);
						if (search(sb.toString())) {
							return true;
						}
					}
				} else {
					if (!p.children.containsKey(key)) {
						return false;
					} else {
						p = p.children.get(key);
					}
				}
			}
			if (i == word.length() && p.children.containsKey("#"))
				return true;
			else
				return false;
		}
	}

	public static void main(String[] args) {
		Solution211 solution = new Solution211();

		WordDictionary words = solution.new WordDictionary();
		words.addWord("word");
		System.out.println(words.search("words"));
		System.out.println(words.search("word"));
		// System.out.println(words.search("......"));
	}

}
