//https://leetcode.com/problems/count-good-nodes-in-binary-tree/

public class CountGoodNodesinBinaryTree_1448 {

	static TreeNode root;

	static class TreeNode {
		int val;
		TreeNode left, right;

		public TreeNode(int item) {
			val = item;
			left = right = null;
		}
	}

	int count = 0;

	public void findGoodNodes(TreeNode root, int x) {
		if (root == null) {
			return;
		}

		if (root.val >= x) {
			count++;
		}

		findGoodNodes(root.left, Math.max(x, root.val));
		findGoodNodes(root.right, Math.max(x, root.val));
	}

	public int goodNodes(TreeNode root) {

		if (root == null) {
			return 0;
		}

		findGoodNodes(root, root.val);
		return count;
	}

	public static void main(String[] args) {
		CountGoodNodesinBinaryTree_1448 tree = new CountGoodNodesinBinaryTree_1448();
		root = new TreeNode(3);
		root.left = new TreeNode(1);
		root.right = new TreeNode(4);
		root.left.left = new TreeNode(3);
		root.right.left = new TreeNode(1);
		root.right.right = new TreeNode(5);
		tree.goodNodes(root);
	}

}
