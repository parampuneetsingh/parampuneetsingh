public class PathSum_112 {

	// https://leetcode.com/problems/path-sum/

	TreeNode root;

	public class TreeNode {
		TreeNode left;
		TreeNode right;
		int val;

		public TreeNode(int x) {
			val = x;
			left = null;
			right = null;
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

	public boolean findSum(int sum) {
		if (root == null) {
			return false;
		}
		boolean res = hasPathSum(root, sum);
		return res;
	}

	public boolean checkSum(TreeNode root, int sum, int total) {
		if (root == null) {
			return false;
		}

		if (root.left == null && root.right == null) {
			return (root.val + total == sum);
		}

		boolean left = checkSum(root.left, sum, root.val + total);
		boolean right = checkSum(root.right, sum, root.val + total);

		return left || right;
	}

	public boolean hasPathSum(TreeNode root, int sum) {
		if (root == null) {
			return false;
		}

		return checkSum(root, sum, 0);
	}

	public static void main(String[] args) {
		int[] data = { 5, 4, 8, 11, 13, 4, 7, 5, 2 };
		PathSum_112 checkSum = new PathSum_112();
		checkSum.insert(data);
		checkSum.findSum(22);
	}

}
