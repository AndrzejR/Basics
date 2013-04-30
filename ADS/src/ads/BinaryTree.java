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
	 * @return True if the value is contained in the tree, false otherwise.
	 */
	public boolean contains(int value) {
		if (findNode(value) != null) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * Main recursive search method. Deprecated. ;) Used to be used by contains
	 * method.
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
	 * Recursively finds a reference to the node containing the given value.
	 * 
	 * @param value
	 *            Data of the node to find.
	 * @return A reference to the node containing the given value, null if the
	 *         value does not exist in the tree.
	 */
	public TreeNode findNode(int value) {
		return findNodeRecursion(value, root);
	}

	/**
	 * Main recursive logic of the findNode method.
	 * 
	 * @param value
	 * @param current
	 * @return
	 */
	private TreeNode findNodeRecursion(int value, TreeNode current) {
		if (current == null) {
			return null;
		} else if (current.data == value) {
			return current;
		} else {
			if (value > current.data) {
				return findNodeRecursion(value, current.right);
			} else {
				return findNodeRecursion(value, current.left);
			}
		}

	}

	/**
	 * Finds the parent node of the node containing the given value.
	 * 
	 * @param value
	 *            Parent of the node containing this value will be returned.
	 * @return Reference to the parent node, null if the value doesn't exist in
	 *         the tree, or it is contained in the root node.
	 */
	public TreeNode findParent(int value) {
		return findParentRecursion(value, root);
	}

	/**
	 * Main recursive logic for the findParent method.
	 * 
	 * @param value
	 * @param current
	 * @return Reference to the parent node, null if the value doesn't exist in
	 *         the tree, or it is contained in the root node.
	 */
	private TreeNode findParentRecursion(int value, TreeNode current) {
		if (root.data == value) {
			return null;
		}
		if (value < current.data) {
			if (current.left == null) {
				return null;
			} else if (current.left.data == value) {
				return current;
			} else {
				return findParentRecursion(value, current.left);
			}
		} else {
			if (current.right == null) {
				return null;
			} else if (current.right.data == value) {
				return current;
			} else {
				return findParentRecursion(value, current.right);
			}
		}
	}

	/**
	 * Removes node with the given value from the tree.
	 * 
	 * @param value
	 *            Data of the node to remove.
	 * @return True if the value existed and was removed, false if the value did
	 *         not exist in the tree.
	 */
	public boolean remove(int value) {
		TreeNode nodeToRemove = findNode(value);
		if (nodeToRemove == null) {
			return false;
		}
		TreeNode parent = findParent(value);
		if (root.left == null && root.right == null) {
			root = null;
		} else if (nodeToRemove.left == null && nodeToRemove.right == null) {
			if (value < parent.data) {
				parent.left = null;
			} else {
				parent.right = null;
			}
		} else if (nodeToRemove.left == null) {
			if (value < parent.data) {
				parent.left = nodeToRemove.right;
			} else {
				parent.right = nodeToRemove.right;
			}
		} else if (nodeToRemove.right == null) {
			if (value < parent.data) {
				parent.left = nodeToRemove.left;
			} else {
				parent.right = nodeToRemove.left;
			}
		} else {
			TreeNode largestValue = nodeToRemove.left;
			boolean right = false;
			while (largestValue.right != null) {
				largestValue = largestValue.right;
				right = true;
			}
			// bug bug bug !!!
			if (right) {
				findParent(largestValue.data).right = null;
			} else {
				findParent(largestValue.data).left = null;
			}
			nodeToRemove.data = largestValue.data;
		}

		return true;
	}

	/**
	 * Test method
	 */
	public static void main(String[] args) {

		BinaryTree bt = new BinaryTree();
		bt.insert(42);
		bt.insert(13);
		bt.insert(666);
		bt.insert(10);
		bt.insert(11);
		bt.insert(7);
		bt.insert(9);
		bt.insert(4);

		System.out.println("1: " + bt.contains(1));
		System.out.println("10: " + bt.contains(10));
		System.out.println("42: " + bt.contains(42));
		System.out.println("13: " + bt.contains(13));
		System.out.println("11: " + bt.contains(11));
		System.out.println("7: " + bt.contains(7));
		System.out.println("9: " + bt.contains(9));
		System.out.println("4: " + bt.contains(4));
		System.out.println("666: " + bt.contains(666));
		System.out.println("123456: " + bt.contains(123456));
		System.out.println();

		System.out.println(bt.findParent(42));
		System.out.println(bt.findParent(13).data);
		System.out.println(bt.findParent(10).data);
		System.out.println(bt.findParent(123456));
		System.out.println();

		System.out.println(bt.findNode(1));
		System.out.println(bt.findNode(42));
		System.out.println(bt.findNode(666));
		System.out.println();

		// remove test
		int vToRemove = 42;
		System.out.println(vToRemove + ": " + bt.contains(vToRemove));
		System.out.println("Removing " + vToRemove);
		bt.remove(vToRemove);

		System.out.println("42: " + bt.contains(42));
		System.out.println("10: " + bt.contains(10));
		System.out.println("13: " + bt.contains(13));
		System.out.println("11: " + bt.contains(11));
		System.out.println("7: " + bt.contains(7));
		System.out.println("9: " + bt.contains(9));
		System.out.println("4: " + bt.contains(4));
		System.out.println("666: " + bt.contains(666));
		System.out.println();

	}

}

class TreeNode {

	int data;
	TreeNode left;
	TreeNode right;

}