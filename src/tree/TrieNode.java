package tree;

import java.util.HashMap;

/**
 * Data structure of a prefix-tree.
 * 
 * @author Jason
 *
 */
public class TrieNode {
	/** character stored in the current node. */
	Character data = null;

	/** next character(s) set. */
	HashMap<Character, TrieNode> dic = null;

	/**
	 * construct a default empty trie node.
	 */
	public TrieNode() {
		this.dic = new HashMap<Character, TrieNode>();
	}

}
