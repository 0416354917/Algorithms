package tree;

/**
 * Binary Tree.
 * 
 * @author Jason
 *
 */
public class BinaryTree {

	BinaryTreeNode root;

	public BinaryTree() {

	}

	public BinaryTree(int val) {
		this.createRootNode(val);
	}

	public void createRootNode(int val) {
		if (root == null) {
			this.root = new BinaryTreeNode(val);
		}
	}

	public void preOrderTraversal(BinaryTreeNode p) {
		if (p != null) {
			System.out.print(p.val + "  ");
			if (p.left != null) {
				preOrderTraversal(p.left);
			}
			if (p.right != null) {
				preOrderTraversal(p.right);
			}
		}
	}

	public void inOrderTraversal(BinaryTreeNode p) {
		if (p != null) {
			if (p.left != null) {
				inOrderTraversal(p.left);
			}
			System.out.print(p.val + "  ");
			if (p.right != null) {
				inOrderTraversal(p.right);
			}
		}
	}

	public void postOrderTraversal(BinaryTreeNode p) {
		if (p != null) {
			if (p.left != null) {
				postOrderTraversal(p.left);
			}
			if (p.right != null) {
				postOrderTraversal(p.right);
			}
			System.out.print(p.val + "  ");
		}
	}

	public BinaryTreeNode getRoot() {
		return this.root;
	}

	public static void main(String[] args) {
		BinaryTree tree = new BinaryTree(5);

		BinaryTreeNode p4 = new BinaryTreeNode(4);
		BinaryTreeNode p2 = new BinaryTreeNode(2);
		BinaryTreeNode p3 = new BinaryTreeNode(3);
		BinaryTreeNode p6 = new BinaryTreeNode(6);
		BinaryTreeNode p7 = new BinaryTreeNode(7);
		BinaryTreeNode p9 = new BinaryTreeNode(9);

		tree.root.left = p4;
		tree.root.right = p7;
		p4.left = p2;
		p2.right = p3;
		p7.left = p6;
		p7.right = p9;

		System.out.println("Pre-order traversal:");
		tree.preOrderTraversal(tree.root);
		System.out.println();

		System.out.println("In-order traversal:");
		tree.inOrderTraversal(tree.root);
		System.out.println();

		System.out.println("Post-order traversal:");
		tree.postOrderTraversal(tree.root);
		System.out.println();
	}

}
