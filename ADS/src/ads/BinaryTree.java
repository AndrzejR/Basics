package ads;

/**
 * 
 * A simple implementation of a binary search tree.
 * 
 * @author Andrzej Ruszczewski
 * 
 */
public class BinaryTree {

	TreeNode root;

	/**
	 * 
	 * Basic insertion method which inserts into root if null, or calls the
	 * recursive method otherwise. This is the method that should be called to
	 * insert a value into the tree.
	 * 
	 * @param value
	 *            the data to insert
	 * 
	 */
	public void insert(int value) {
		if (root == null) {
			root = new TreeNode();
			root.data = value;
		} else {
			insertNode(value, root);
		}
	}

	/**
	 * 
	 * Recursive insertion method for inserting deeper than the root.
	 * 
	 * @param value
	 * @param current
	 * 
	 */
	private void insertNode(int value, TreeNode current) {
		if (value < current.data) {
			if (current.left == null) {
				current.left = new TreeNode();
				current.left.data = value;
			} else {
				insertNode(value, current.left);
			}
		} else {
			if (current.right == null) {
				current.right = new TreeNode();
				current.right.data = value;
			} else {
				insertNode(value, current.right);
			}
		}
	}

	/**
	 * Checks if a given value is contained in the tree.
	 * 
	 * @param value
	 *            the value to search for in the tree
	 * @return true if the value is contained in the tree, false otherwise *
	 */
	public boolean contains(int value) {
		return containsRecursion(value, root);
	}

	/**
	 * 
	 * Main recursive search method.
	 * 
	 * @param value
	 * @param current
	 * @return
	 */
	private boolean containsRecursion(int value, TreeNode current) {
		if (current == null) {
			return false;
		} else if (current.data == value) {
			return true;
		} else {
			if (value > current.data) {
				return containsRecursion(value, current.right);
			} else {
				return containsRecursion(value, current.left);
			}
		}
	}

	/**
	 * Finds the parent node of the node containing the given value.
	 * 
	 * @param value
	 * @param current
	 * @return reference to the parent node, null if the value doesn't exist in
	 *         the tree, or it is contained in the root node
	 */
	private TreeNode findParent(int value, TreeNode current) {
		if (root.data == value) {
			return null;
		}
		if (value < current.data) {
			if (current.left == null) {
				return null;
			} else if (current.left.data == value) {
				return current;
			} else {
				return findParent(value, current.left);
			}
		} else {
			if (current.right == null) {
				return null;
			} else if (current.right.data == value) {
				return current;
			} else {
				return findParent(value, current.right);
			}
		}
	}

	/**
	 * Test method
	 */
	public static void main(String[] args) {

		BinaryTree bt = new BinaryTree();
		bt.insert(42);
		bt.insert(13);
		bt.insert(666);
		bt.insert(11);
		bt.insert(10);

		System.out.println("1: " + bt.contains(1));
		System.out.println("10: " + bt.contains(10));
		System.out.println("42: " + bt.contains(42));
		System.out.println("13: " + bt.contains(13));
		System.out.println("666: " + bt.contains(666));
		System.out.println("123456: " + bt.contains(123456));
		
		System.out.println(bt.findParent(42, bt.root));
		System.out.println(bt.findParent(13, bt.root).data);
		System.out.println(bt.findParent(10, bt.root).data);

	}

}

class TreeNode {

	int data;
	TreeNode left;
	TreeNode right;

}