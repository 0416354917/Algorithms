package tree;

/**
 * Binary Tree Node.
 * 
 * @author Jason
 *
 */
public class BinaryTreeNode {

	int val;
	BinaryTreeNode left;
	BinaryTreeNode right;
	boolean visited;

	public BinaryTreeNode(int val) {
		this.val = val;
		this.left = null;
		this.right = null;
		this.visited = false;
	}

	public void createLeftChild(int val) {
		this.left = new BinaryTreeNode(val);
	}

	public void createRightChild(int val) {
		this.right = new BinaryTreeNode(val);
	}

}
