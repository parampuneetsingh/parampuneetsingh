//https://leetcode.com/problems/maximum-difference-between-node-and-ancestor/

public class MaximumDifferenceBetweenNodeandAncestor_1026 {

	int resVal = 0;

	static TreeNode root;

	public void findDiff(TreeNode root, int min, int max) {
		if (root == null) {
			return;
		}

		resVal = Math.max(resVal, Math.max(Math.abs(root.val - min), Math.abs(root.val - max)));
		min = Math.min(min, root.val);
		max = Math.max(max, root.val);

		findDiff(root.left, min, max);
		findDiff(root.right, min, max);
	}

	public int maxAncestorDiff(TreeNode root) {
		if (root == null) {
			return 0;
		}

		findDiff(root, root.val, root.val);

		return resVal;
	}

	public static void main(String[] args) {
		MaximumDifferenceBetweenNodeandAncestor_1026 tree = new MaximumDifferenceBetweenNodeandAncestor_1026();
		root = new TreeNode(8);
		root.left = new TreeNode(3);
		root.right = new TreeNode(10);
		root.left.left = new TreeNode(1);
		root.left.right = new TreeNode(6);
		root.left.right.left = new TreeNode(4);
		root.left.right.right = new TreeNode(7);
		root.right.right = new TreeNode(14);
		root.right.right.left = new TreeNode(13);

		tree.maxAncestorDiff(root);
	}

}
