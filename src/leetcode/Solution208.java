package leetcode;

import java.util.HashMap;

/**
 * Implement Trie (Prefix Tree).
 * 
 * <p>
 * <b>Status: Accepted.</b>
 * </p>
 * 
 * @author Jason
 *
 */
public class Solution208 {
	class TrieNode {
		String key = null;
		HashMap<String, TrieNode> children = new HashMap<String, TrieNode>();

		// Initialize your data structure here.
		public TrieNode() {

		}

		public TrieNode(String key) {
			this.key = key;
		}

	}

	public class Trie {
		private TrieNode root;

		public Trie() {
			root = new TrieNode();
		}

		// Inserts a word into the trie.
		public void insert(String word) {
			if (word == null)
				return;

			TrieNode p = root;
			int i = 0;
			for (; i < word.length(); i++) {
				String s = word.substring(i, i + 1);
				if (p.children.containsKey(s)) {
					p = p.children.get(s);
				} else {
					break;
				}
			}
			while (i < word.length()) {
				String s = word.substring(i, i + 1);
				TrieNode node = new TrieNode(s);
				p.children.put(s, node);
				p = node;
				i++;
			}
			if (!p.children.containsKey("#")) {
				p.children.put("#", new TrieNode("#"));
			}
		}

		// Returns if the word is in the trie.
		public boolean search(String word) {
			if (word == null)
				return true;

			TrieNode p = root;
			for (int i = 0; i < word.length(); i++) {
				String s = word.substring(i, i + 1);
				if (!p.children.containsKey(s)) {
					return false;
				} else {
					p = p.children.get(s);
				}
			}
			if (!p.children.containsKey("#"))
				return false;
			else
				return true;
		}

		// Returns if there is any word in the trie
		// that starts with the given prefix.
		public boolean startsWith(String prefix) {
			if (prefix == null)
				return true;

			TrieNode p = root;
			for (int i = 0; i < prefix.length(); i++) {
				String s = prefix.substring(i, i + 1);
				if (!p.children.containsKey(s)) {
					return false;
				} else {
					p = p.children.get(s);
				}
			}
			return true;
		}
	}

	public static void main(String[] args) {
		Solution208 solution = new Solution208();

		Trie trie = solution.new Trie();
		trie.insert("abc");
		System.out.println(trie.search("abc"));
		System.out.println(trie.search("ab"));
		trie.insert("ab");
		System.out.println(trie.search("ab"));
		trie.insert("ab");
		System.out.println(trie.search("ab"));
	}

}
