package my.datastructures;

/** the other way to do this is to find the length of both the lists & get the difference of list.
 * Then need to traverse the longer list till the difference & then start traversing both the list (since now both pointers are at same index)
 * to find the same intersecting node.
 *
 */

public class FindIntersectingNodeInLinkedList {

	Node header;

	static class Node {
		int data;
		Node next;

		public Node(int data) {
			this.data = data;
		}

	}

	static Node getIntersectionNode(Node headA, Node headB) {
		Node a = headA;
		Node b = headB;
		int count = 0;

		if (a == null || b == null) {
			return null;
		}

		while (a != b) {
			a = a.next;
			b = b.next;
			if (a == null) {
				a = headB;
				count++;
			}
			if (b == null) {
				b = headA;
			}
			if (count == 2) {
				return null;
			}
		}
		return a;
	}

	public static void main(String[] args) {
		FindIntersectingNodeInLinkedList list1 = new FindIntersectingNodeInLinkedList();
		list1.header = new Node(1);
		list1.header.next = new Node(3);
		list1.header.next.next = new Node(5);
		list1.header.next.next.next = new Node(7);
		list1.header.next.next.next.next = new Node(9);
		list1.header.next.next.next.next.next = new Node(11);
		list1.header.next.next.next.next.next.next = new Node(2);
		list1.header.next.next.next.next.next.next.next = new Node(4);
		Node inter = new Node(6);
		list1.header.next.next.next.next.next.next.next.next = inter;
		list1.header.next.next.next.next.next.next.next.next.next = new Node(8);

		FindIntersectingNodeInLinkedList list2 = new FindIntersectingNodeInLinkedList();
		
		list2.header = new Node(20);
		list2.header.next = new Node(21);
		list2.header.next.next = inter;
		Node intersectedNode = getIntersectionNode(list1.header, list2.header);
		if (intersectedNode == null) {
			System.out.println("No Intersection");
		} else {
			System.out.println(intersectedNode.data);
		}
	}

}
