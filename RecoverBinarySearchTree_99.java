//https://leetcode.com/problems/recover-binary-search-tree/
//https://leetcode.com/problems/recover-binary-search-tree/discuss/462610/Java-solution-using-InOrder-traversal-with-explanation

public class RecoverBinarySearchTree_99 {

	static TreeNode root;

	static class TreeNode {
		int val;
		TreeNode left, right;

		public TreeNode(int item) {
			val = item;
			left = right = null;
		}
	}

	private TreeNode pre, first, second;

	private void inorder(TreeNode root) {
		if (root == null)
			return;
		inorder(root.left);
		if (pre != null && pre.val > root.val) { // found wrong
			if (first == null) {
				first = pre;
			}
			second = root;
		}
		pre = root;
		inorder(root.right);
	}

	public void recoverTree(TreeNode root) {
		pre = null;
		first = null;
		second = null;
		inorder(root); // traverse the tree
		// swap
		if (first != null) {
			int tmp = first.val;
			first.val = second.val;
			second.val = tmp;
		}
	}

	public static void main(String[] args) {
		RecoverBinarySearchTree_99 tree = new RecoverBinarySearchTree_99();
		// root = new TreeNode(3);
		// root.left = new TreeNode(1);
		// root.left.right = new TreeNode(2);
		root = new TreeNode(2);
		root.left = new TreeNode(3);
		root.left.right = new TreeNode(1);
		tree.recoverTree(root);
	}

}
