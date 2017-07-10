package my.datastructures;
//Java implementation to check if given Binary tree

//is a BST or not

/* Class containing left and right child of current
 node and key value*/
class BTNode {
	int data;
	BTNode left, right;

	public BTNode(int item) {
		data = item;
		left = right = null;
	}
}

public class IsBinaryTree {
	// Root of the Binary Tree
	BTNode root;

	/*
	 * can give min and max value according to your code or can write a function
	 * to find min and max value of tree.
	 */

	/*
	 * returns true if given search tree is binary search tree (efficient
	 * version)
	 */
	boolean isBST() {
		return isBSTUtil(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
	}

	/*
	 * Returns true if the given tree is a BST and its values are >= min and <=
	 * max.
	 */
	boolean isBSTUtil(BTNode node, int min, int max) {
		System.out.println("Min : " + min + " Max : " + max);
		/* an empty tree is BST */
		if (node == null) {
			return true;
		}

		/* false if this node violates the min/max constraints */
		if (node.data < min || node.data > max) {
			System.out.println("node data : " + node.data + " Min : " + min + " Max : " + max);
			return false;
		}

		/*
		 * otherwise check the subtrees recursively tightening the min/max
		 * constraints
		 */
		// Allow only distinct values
		return (isBSTUtil(node.left, min, node.data - 1) && isBSTUtil(node.right, node.data + 1, max));
	}

	/* Driver program to test above functions */
	public static void main(String args[]) {
		IsBinaryTree tree = new IsBinaryTree();
		tree.root = new BTNode(4);
		tree.root.left = new BTNode(2);
		tree.root.right = new BTNode(5);
		tree.root.left.left = new BTNode(1);
		tree.root.left.right = new BTNode(3);
		
		tree.root.right.left = new BTNode(3);
		tree.root.right.right = new BTNode(6);

		if (tree.isBST()) {
			System.out.println("IS BST");
		} else {
			System.out.println("Not a BST");
		}
	}
}