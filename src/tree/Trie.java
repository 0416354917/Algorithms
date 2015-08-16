package tree;

import java.util.HashMap;

/**
 * A prefix-tree for words insertion and search.
 * 
 * @author Jason
 *
 */
public class Trie {
	private TrieNode root;

	public Trie() {
		root = new TrieNode();
	}

	/**
	 * Inserts a word into the trie.
	 * 
	 * @param word
	 */
	public void insert(String word) {
		int n = word.length();

		if (n == 0)
			return;

		TrieNode insertNode = root;
		HashMap<Character, TrieNode> insertDic = insertNode.dic;
		for (int i = 0; i < n; i++) {
			char ch = word.charAt(i);
			if (insertDic.containsKey(ch)) {
				insertNode = insertDic.get(ch);
			} else {
				insertNode = new TrieNode();
				insertDic.put(ch, insertNode);
			}
			insertDic = insertNode.dic;
		}
	}

	/**
	 * Returns if the word is in the trie.
	 * 
	 * @param word
	 * @return
	 */
	public boolean search(String word) {
		int n = word.length();

		if (n == 0)
			return true;

		TrieNode searchNode = root;
		HashMap<Character, TrieNode> searchDic = searchNode.dic;
		for (int i = 0; i < n; i++) {
			char ch = word.charAt(i);
			if (searchDic.containsKey(ch)) {
				searchNode = searchDic.get(ch);
				searchDic = searchNode.dic;
			} else {
				return false;
			}
		}

		if (searchDic.size() != 0)
			return false;

		return true;

	}

	/**
	 * Returns if there is any word in the trie that starts with the given
	 * prefix.
	 */
	public boolean startsWith(String prefix) {
		int n = prefix.length();

		if (n == 0)
			return true;

		TrieNode searchNode = root;
		HashMap<Character, TrieNode> searchDic = searchNode.dic;
		for (int i = 0; i < n; i++) {
			char ch = prefix.charAt(i);
			if (searchDic.containsKey(ch)) {
				searchNode = searchDic.get(ch);
				searchDic = searchNode.dic;
			} else {
				return false;
			}
		}

		return true;
	}

	/**
	 * Print out all of words that representated by this trie.
	 */
	public void display() {

	}

	public static void main(String[] args) {
		String testStr1 = "cat";
		String testStr2 = "case";
		String testStr3 = "c";
		String testStr4 = "cas";

		Trie trie = new Trie();

		System.out.println("insert:");
		trie.insert(testStr1);
		trie.insert(testStr3);
		System.out.println();

		System.out.println("search:");
		System.out.println(trie.search(testStr1));
		System.out.println(trie.search(testStr2));
		System.out.println(trie.search(testStr3));
		System.out.println(trie.search(testStr4));
		System.out.println();

		System.out.println("startsWith:");
		System.out.println(trie.startsWith("cas"));
		System.out.println(trie.startsWith("ca"));
		System.out.println();

	}

}
