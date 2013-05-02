package ads;

import java.util.ArrayDeque;

/**
 * 
 * A simple implementation of a binary search tree (unbalanced).
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

			while (largestValue.right != null) {
				largestValue = largestValue.right;
			}

			/**
			 * Need to take care of the special cases when the largest value
			 * node is the only node in the left tree of the node to remove or
			 * it has children but it is the left child of the node to remove.
			 */
			TreeNode parentOfLargest = findParent(largestValue.data);
			if (parentOfLargest.left == largestValue) {
				if (largestValue.left == null) {
					parentOfLargest.left = null;
				} else {
					parentOfLargest.left = largestValue.left;
				}
			} else {
				parentOfLargest.right = null;
			}

			nodeToRemove.data = largestValue.data;
		}

		return true;
	}

	/**
	 * findMin and findMax could potentially return the value instead of the
	 * node, but then it creates a problem when the tree is empty - throwing an
	 * exception can be a solution to this problem.
	 */

	/**
	 * Finds the node with the minimum value.
	 * 
	 * @return Node with minimum value.
	 */
	public TreeNode findMin() {
		if (root == null) {
			return null;
		}
		return findMinRecursion(root);

	}

	/**
	 * Recursive logic for findMin method.
	 * 
	 * @param current
	 * @return
	 */
	private TreeNode findMinRecursion(TreeNode current) {
		if (current.left == null) {
			return current;
		} else {
			return findMinRecursion(current.left);
		}
	}

	/**
	 * Finds the node with the maximum value.
	 * 
	 * @return Node with maximum value.
	 */
	public TreeNode findMax() {
		if (root == null) {
			return null;
		}
		return findMaxRecursion(root);

	}

	/**
	 * Recursive logic for findMax method.
	 * 
	 * @param current
	 * @return
	 */
	private TreeNode findMaxRecursion(TreeNode current) {
		if (current.right == null) {
			return current;
		} else {
			return findMaxRecursion(current.right);
		}
	}

	/**
	 * Preorder traversal - visit the root first, the left subtree, and then the
	 * right subtree.
	 */
	public void traversePreorder() {
		traversePreorderHelper(root);
	}

	private void traversePreorderHelper(TreeNode current) {
		if (current != null) {
			System.out.println(current.data);
			traversePreorderHelper(current.left);
			traversePreorderHelper(current.right);
		}
	}

	/**
	 * Postorder traversal - left subtree first, then right, finally the root.
	 */
	public void traversePostorder() {
		traversePostorderHelper(root);
	}

	private void traversePostorderHelper(TreeNode current) {
		if (current != null) {
			traversePostorderHelper(current.left);
			traversePostorderHelper(current.right);
			System.out.println(current.data);
		}
	}

	/**
	 * Inorder traversal - left subtree, then root, finally right subtree.
	 * Returns values in comparison order.
	 */
	public void traverseInorder() {
		traverseInorderHelper(root);
	}

	private void traverseInorderHelper(TreeNode current) {
		if (current != null) {
			traverseInorderHelper(current.left);
			System.out.println(current.data);
			traverseInorderHelper(current.right);
		}
	}

	/**
	 * Breadth first traversal - yields all the nodes of the same depth, before
	 * any deeper ones.
	 */
	public void traverseBreadth(){
		traverseBreadthHelper(root);
	}
	
	private void traverseBreadthHelper(TreeNode current){
		ArrayDeque<TreeNode> deq = new ArrayDeque<TreeNode>();
		while (current!=null){
			System.out.println(current.data);
			if (current.left!=null){
				deq.add(current.left);
			}
			if (current.right!=null){
				deq.add(current.right);
			}
			if (!deq.isEmpty()){
				current = deq.remove();
			} else {
				current = null;
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

		System.out.println("Preorder Traverse:");
		bt.traversePreorder();
		System.out.println();

		System.out.println("Postorder Traverse:");
		bt.traversePostorder();
		System.out.println();

		System.out.println("Inorder Traverse:");
		bt.traverseInorder();
		System.out.println();
		
		System.out.println("Breadth First Traverse:");
		bt.traverseBreadth();
		System.out.println();

		/**
		 *  remove() test
		 */
		// int vToRemove = 42;
		// System.out.println(vToRemove + ": " + bt.contains(vToRemove));
		// System.out.println("Removing " + vToRemove);
		// bt.remove(vToRemove);
		//
		// System.out.println("42: " + bt.contains(42));
		// System.out.println("10: " + bt.contains(10));
		// System.out.println("13: " + bt.contains(13));
		// System.out.println("11: " + bt.contains(11));
		// System.out.println("7: " + bt.contains(7));
		// System.out.println("9: " + bt.contains(9));
		// System.out.println("4: " + bt.contains(4));
		// System.out.println("666: " + bt.contains(666));
		// System.out.println();

		System.out.println("Min: " + bt.findMin().data);
		System.out.println("Max: " + bt.findMax().data);
		System.out.println();

	}

}

class TreeNode {

	int data;
	TreeNode left;
	TreeNode right;

}