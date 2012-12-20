package ads;

/**
 * An implementation of a parameterized singly linked list.
 * 
 * @author Andrzej Ruszczewski
 */
public class MyLinkedList<T> {

	Node<T> head;
	Node<T> tail;

	/**
	 * Adds a node at the end of the list
	 * 
	 * @param data
	 *            the value that the node will contain
	 */
	void addNode(T data) {
		if (head == null) {
			head = tail = new Node<T>(data);
		} else {
			tail.next = new Node<T>(data);
			tail = tail.next;
		}
	}

	/**
	 * Checks if the list contains a certain value
	 * 
	 * @param x
	 *            the value to check for
	 * @return true if the list contains x, false otherwise
	 */
	boolean contains(T x) {
		if (head != null) {
			Node<T> aNode = head;
			while (aNode != null) {
				if (aNode.data == x)
					return true;
				aNode = aNode.next;
			}
		}
		return false;
	}

	/**
	 * Removes the last node from the list
	 */
	void removeLast() {
		
		if (head == null)
			return;
		
		else if (head.next == null) {
			head.next = null;
			tail = head;
			
		} else {
			Node<T> aNode = head;
			while (aNode != null) {
				if (aNode.next.next == null) {
					tail = aNode;
					aNode.next = null;
				}
				aNode = aNode.next;
			}
		}
	}

	/**
	 * A testing method
	 */
	public static void main(String[] args) {

		MyLinkedList<Integer> aList = new MyLinkedList<Integer>();

		for (int i = 0; i < 10; i++) {
			aList.addNode(i);
		}

		Node<Integer> aNode = aList.head;
		while (aNode != null) {
			System.out.print(aNode.data + " ");
			aNode = aNode.next;
		}
		System.out.println();

		System.out.println("Contains 7 (true): " + aList.contains(7));
		System.out.println("Contains 13 (false): " + aList.contains(13));

		aList.removeLast();

		System.out.println("Contains 9 (false): " + aList.contains(9));

		Node<Integer> bNode = aList.head;
		while (bNode != null) {
			System.out.print(bNode.data + " ");
			bNode = bNode.next;
		}
		System.out.println();

		MyLinkedList<String> bList = new MyLinkedList<String>();
		for (int j = 0; j < 6; j++) {
			bList.addNode("string number " + j);
		}
		Node<String> cNode = bList.head;
		while (cNode != null){
			System.out.println(cNode.data);
			cNode = cNode.next;
		}
	}
}

class Node<T> {
	T data;
	Node<T> next;

	Node(T d) {
		data = d;
	}
}
