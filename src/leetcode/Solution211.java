package leetcode;

/**
 * Add and Search Word - Data structure design.
 * 
 * <p>
 * <b>Description: </b>
 * 
 * Design a data structure that supports the following two operations:
 * 
 * void addWord(word) bool search(word) search(word) can search a literal word
 * or a regular expression string containing only letters a-z or .. A . means it
 * can represent any one letter.
 * 
 * For example:
 * 
 * addWord("bad") addWord("dad") addWord("mad") search("pad") -> false
 * search("bad") -> true search(".ad") -> true search("b..") -> true Note: You
 * may assume that all words are consist of lowercase letters a-z.
 * </p>
 * 
 * <p>
 * <b>Algorithm: </b>Backtracking, Trie, Design.
 * </p>
 * 
 * <p>
 * <b>Reference: </b>
 * {@link https://leetcode.com/discuss/92820/trie-tree-java-solution-very-easy-to-understand}
 * </p>
 * 
 * <p>
 * <b>Note: </b>...
 * <p>
 * 
 * <p>
 * <b>Status: </b>TLE.
 * </p>
 * 
 * @author Jason
 *
 */
public class Solution211 {

	public class WordDictionary {

		class TrieNode {

			TrieNode[] children = new TrieNode[26];

			boolean flag = false;

			public TrieNode() {

			}

		}

		TrieNode root;

		public WordDictionary() {
			this.root = new TrieNode();
		}

		// Adds a word into the data structure.
		public void addWord(String word) {
			if (word == null)
				return;

			TrieNode p = root;
			for (char x : word.toCharArray()) {
				if (p.children[x - 'a'] == null) {
					p.children[x - 'a'] = new TrieNode();
				}
				p = p.children[x - 'a'];
			}
			p.flag = true;
		}

		// Returns if the word is in the data structure. A word could
		// contain the dot character '.' to represent any one letter.
		public boolean search(String word) {
			if (word == null)
				return true;

			return bt(word, root, 0);
		}

		public boolean bt(String word, TrieNode root, int index) {
			if (index == word.length()) {
				return root.flag;
			} else if (word.charAt(index) != '.') {
				TrieNode p = root;
				while (index < word.length() && word.charAt(index) != '.') {
					p = p.children[word.charAt(index) - 'a'];
					if (p == null) {
						return false;
					}
					index++;
				}
				return bt(word, p, index);
			} else {
				TrieNode[] children = root.children;
				for (TrieNode child : children) {
					if (child != null && bt(word, child, index + 1))
						return true;
				}
			}

			return false;
		}
	}

	public static void main(String[] args) {
		Solution211 solution = new Solution211();

		WordDictionary words = solution.new WordDictionary();
		words.addWord("word");
		System.out.println(words.search("words"));
		System.out.println(words.search("word"));
		System.out.println(words.search("."));
	}

}
