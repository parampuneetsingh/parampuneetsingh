//https://leetcode.com/problems/longest-univalue-path/

public class LongestUnivaluePath_687 {

	public int longestUnivaluePath(TreeNode root) {
		int[] res = new int[1];
		findMax(root, res);
		return res[0];
	}

	public int findMax(TreeNode root, int[] res) {
		if (root == null) {
			return 0;
		}

		int left = findMax(root.left, res);
		int right = findMax(root.right, res);

		int leftVal = 0, rightVal = 0;
		if (root.left != null && root.val == root.left.val) {
			leftVal = left + 1;
		}

		if (root.right != null && root.val == root.right.val) {
			rightVal = right + 1;
		}

		res[0] = Math.max(res[0], rightVal + leftVal);

		return Math.max(leftVal, rightVal);
	}

	public static void main(String[] args) {
		LongestUnivaluePath_687 tree = new LongestUnivaluePath_687();
		TreeNode root = new TreeNode(5);
		root.left = new TreeNode(4);
		root.right = new TreeNode(5);
		root.left.left = new TreeNode(1);
		root.left.right = new TreeNode(1);
		root.right.right = new TreeNode(5);
		System.out.println(tree.longestUnivaluePath(root));
	}

}
