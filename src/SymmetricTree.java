public class SymmetricTree {

	/**
	 * Definition for a binary tree node.
	 */
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode() {
		}

		TreeNode(int val) {
			this.val = val;
		}

		TreeNode(int val, TreeNode left, TreeNode right) {
			this.val = val;
			this.left = left;
			this.right = right;
		}
	}

	public boolean isSymmetric(TreeNode root) {

		if (root == null) {
			return false;
		}
		return traverseAndCompare(root.left, root.right);
	}

	public boolean traverseAndCompare(TreeNode left, TreeNode right) {
		if ((left == null && right != null) || (left != null && right == null)) {
			return false;
		}

		if (left == null && right == null) {
			return true;
		}

		if (left.val != right.val) {
			return false;
		}

		if (!traverseAndCompare(left.left, right.right)) {
			return false;
		}
		if (!traverseAndCompare(left.right, right.left)) {
			return false;
		}
		return true;
	}

}
