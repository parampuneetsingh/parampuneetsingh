class TreeNode {
	TreeNode left, right = null;
	int val;

	public TreeNode(int val) {
		this.val = val;
		left = right = null;
	}
}

public final class SecondMinimumNodeInBinaryTree_671 {

	TreeNode root;

	int min;
	int secondMin = Integer.MAX_VALUE;

	public int findSecondMinimumValue(TreeNode root) {
		min = root.val;
		helper(root);
		return secondMin;
	}

	public void helper(TreeNode root) {
		if (root != null) {
			if (root.val > min && root.val < secondMin) {
				secondMin = root.val;
			} else if (min == root.val){
				helper(root.left);
				helper(root.right);
			}
		}
	}

	public static void main(String[] args) {
		SecondMinimumNodeInBinaryTree_671 tree = new SecondMinimumNodeInBinaryTree_671();
		TreeNode root = new TreeNode(2);
		root.left = new TreeNode(2);
		root.right = new TreeNode(5);
		root.right.left = new TreeNode(5);
		root.right.right = new TreeNode(7);
		tree.findSecondMinimumValue(root);
	}

}
