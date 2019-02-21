package my.problemsolving;

/**
 * This is a tree where there can be 3 items in a node. One square, triangle & a
 * circle. Square > Triangle > Circle. Square cannot have Triangle or Circle as
 * Parent. Triangle cannot have circle as parent.
 * 
 * The problem is to check whether the given tree is valid or not.
 * 
 * Lets assume the data is Square = 4, Triangle = 3, Circle = 0
 * 
 */
public class CustomTreeIsValid {

	static class Node {
		int data;

		Node left;

		Node right;

		public Node(int data) {
			this.data = data;
			left = null;
			right = null;
		}
	}

	public static boolean isTreeValid(Node node, int max) {
		if (node == null) {
			return true;
		}
		if (node.data > max) {
			return false;
		}
		return isTreeValid(node.left, node.data) && isTreeValid(node.right, node.data);
	}

	public static void main(String[] args) {
//		Node root = new Node(4);
//		root.left = new Node(3);
//		root.right = new Node(0);
//		root.left.left = new Node(3);
//		root.left.right = new Node(3);
//		root.right.left = new Node(0);
//		root.right.right = new Node(0);
		
		Node root = new Node(3);
		root.left = new Node(3);
		root.right = new Node(0);
		root.left.left = new Node(3);
		root.left.right = new Node(3);
		root.right.left = new Node(0);
		root.right.right = new Node(0);
		
		System.out.println(isTreeValid(root, root.data));
	}
}
