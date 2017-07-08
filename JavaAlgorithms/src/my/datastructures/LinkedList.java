package my.datastructures;

public class LinkedList {

	class Node {
		int data;
		Node next;

		public Node(int data) {
			this.data = data;
		}

		public void setNextNode(Node next) {
			this.next = next;
		}
	}

	Node header;
	int size = 0;

	public int getHead() {
		if (header != null) {
			return header.data;
		}
		return 0;
	}

	public void addData(int data) {
		if (header == null) {
			header = new Node(data);
			size++;
			return;
		}
		Node current = header;
		Node newNode = new Node(data);
		while (current != null && current.next != null) {
			current = current.next;
		}
		current.next = newNode;
		size++;
	}

	public void insertDataAt(int position, int data) {
		if (position > size || position < 1) {
			return;
		} else {
			int counter = 1;
			Node current = header;
			Node prev = header;
			while (counter != position) {
				prev = current;
				current = current.next;
				counter++;
			}
			Node newNode = new Node(data);
			prev.next = newNode;
			newNode.next = current;
		}
	}

	public boolean removeData(int data) {
		Node finder = header;
		Node prev = header;
		while (finder != null) {
			if (finder.data == data) {
				if (finder == header) {
					size--;
					if (finder.next != null) {
						header = header.next;
					} else {
						header = null;
					}
				}
				if (finder.next != null) {
					prev.next = finder.next;
					finder = null;
					size--;
					return true;
				} else {
					prev.next = null;
					finder = null;
					size--;
					return true;
				}
			}
			prev = finder;
			finder = finder.next;
		}
		return false;
	}

	public int getDataAt(int location) {
		Node finder = header;
		int counter = 1;
		while (finder != null) {
			if (counter == location) {
				return finder.data;
			}
			finder = finder.next;
			counter++;
		}
		return 0;
	}

	public void printList() {
		Node finder = header;
		while (finder != null) {
			System.out.print(finder.data + " ");
			finder = finder.next;
		}
		System.out.println(" Size : " + size);
	}

	public static void main(String[] args) {
		LinkedList list = new LinkedList();
		list.addData(1);
		list.addData(2);
		list.addData(3);
		list.addData(4);
		list.addData(5);
		list.printList();
		System.out.println("data @ 3 : " + list.getDataAt(3));
		list.printList();
		list.removeData(3);
		list.printList();
		list.removeData(3);
		list.printList();
		list.addData(3);
		list.printList();
		System.out.println("data @ 3 : " + list.getDataAt(3));
		list.removeData(6);
		System.out.println("data @ 3 : " + list.getDataAt(3));
		System.out.println("data @ 6 : " + list.getDataAt(6));
		list.printList();
		list.removeData(1);
		list.printList();
		list.removeData(2);
		list.removeData(5);
		list.printList();
		list.removeData(3);
		list.removeData(4);
		list.printList();
		list.addData(1);
		list.addData(2);
		list.printList();

		list.insertDataAt(5, 6);
		list.printList();
		list.insertDataAt(3, 3);
		list.printList();
	}
}
