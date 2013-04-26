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
	 * Test method
	 */
	public static void main(String[] args) {

		BinaryTree bt = new BinaryTree();
		bt.insert(42);
		bt.insert(13);
		bt.insert(666);

	}

}

class TreeNode {

	int data;
	TreeNode left;
	TreeNode right;

}