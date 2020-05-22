//https://leetcode.com/problems/binary-tree-maximum-path-sum/
//https://www.youtube.com/watch?v=_wUz0XKQ5JM

public class BinaryTreeMaximumPathSum_124 {

	TreeNode root;

	class TreeNode {
		int val;
		TreeNode left, right;

		public TreeNode(int item) {
			val = item;
			left = right = null;
		}
	}

	public void insert(int[] data) {
		root = insertData(root, data, 0, data.length);
	}

	public TreeNode insertData(TreeNode root, int[] data, int start, int size) {

		TreeNode temp = new TreeNode(0);
		int left = 2 * start + 1;
		int right = 2 * start + 2;

		if (left > size && right > size) {
			return null;
		}

		if (root == null) {
			temp.val = data[start];
			root = temp;
		}

		if (root.left == null && root.right == null) {
			if (left < size) {
				root.left = new TreeNode(data[left]);
			}
			if (right < size) {
				root.right = new TreeNode(data[right]);
			}
		}

		insertData(root.left, data, left, size);
		insertData(root.right, data, right, size);

		return root;
	}

	int maxSum = Integer.MIN_VALUE;

	public int maxPath() {
		return maxPathSum(root);
	}

	public int maxPathSum(TreeNode root) {
		updateValue(root);
		return maxSum;
	}

	// Solution 2
	private int updateValue2(TreeNode root) {
		if (root == null) {
			return 0;
		}

		int left = updateValue(root.left);
		int right = updateValue(root.right);

		int leafSum = Math.max(Math.max(left, right) + root.val, root.val);
		int max = Math.max(leafSum, left + right + root.val);
		maxSum = Math.max(maxSum, max);

		return leafSum;
	}

	// Solution 1
	private int updateValue(TreeNode root) {
		if (root == null) {
			return 0;
		}

		int left = Math.max(0, updateValue(root.left));
		int right = Math.max(0, updateValue(root.right));

		maxSum = Math.max(maxSum, left + right + root.val);

		return Math.max(left, right) + root.val;
	}

	public static void main(String[] args) {
		int data[] = { 1, 2, 3 };
		// int[] data = {-10,9,20,null,null,15,7};

		BinaryTreeMaximumPathSum_124 tree = new BinaryTreeMaximumPathSum_124();
		tree.insert(data);
		System.out.println(tree.maxPath());
	}

}
