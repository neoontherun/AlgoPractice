package my.datastructures;
// Java program to convert binary tree into its mirror

/* Class containing left and right child of current
   node and key value*/

public class MirrorBinaryTree {
	BTNode root;

	void mirror() {
		root = mirror(root);
	}

	BTNode mirror(BTNode node) {
		if (node == null) {
			return node;
		}

		/* do the subtrees */
		BTNode left = mirror(node.left);
		BTNode right = mirror(node.right);

		/* swap the left and right pointers */
		node.left = right;
		node.right = left;

		return node;
	}

	void inOrder() {
		inOrder(root);
	}

	/*
	 * Helper function to test mirror(). Given a binary search tree, print out
	 * its data elements in increasing sorted order.
	 */
	void inOrder(BTNode node) {
		if (node == null) {
			return;
		}
		inOrder(node.left);
		System.out.print(node.data + " ");
		inOrder(node.right);
	}

	/* testing for example nodes */
	public static void main(String args[]) {
		/* creating a binary tree and entering the nodes */
		MirrorBinaryTree tree = new MirrorBinaryTree();
		tree.root = new BTNode(1);
		tree.root.left = new BTNode(2);
		tree.root.right = new BTNode(3);
		tree.root.left.left = new BTNode(4);
		tree.root.left.right = new BTNode(5);

		/* print inorder traversal of the input tree */
		System.out.println("Inorder traversal of input tree is :");
		tree.inOrder();
		System.out.println("");

		/* convert tree to its mirror */
		tree.mirror();

		/* print inorder traversal of the minor tree */
		System.out.println("Inorder traversal of binary tree is : ");
		tree.inOrder();

	}
}