//https://www.lintcode.com/problem/binary-tree-longest-consecutive-sequence/description

public class BinaryTreeLongestConsecutiveSequence_298 {

	int max = Integer.MIN_VALUE;

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

	public int findMax(TreeNode root, int sum) {
		if (root == null) {
			return sum;
		}

		int left = (root.left != null && root.val + 1 == root.left.val) ? findMax(root.left, sum + 1)
				: findMax(root.left, 1);

		int right = (root.right != null && root.val + 1 == root.right.val) ? findMax(root.right, sum + 1)
				: findMax(root.right, 1);

		return Math.max(sum, Math.max(left, right));
	}

	public int longestConsecutive(TreeNode root) {
		if (root == null) {
			return 0;
		}

		return findMax(root, 1);
	}

	public int longestNum() {
		return longestConsecutive(root);
	}

	public static void main(String[] args) {
		int[] data = { 3, 4, 9, 20, 12, 34, 15, 7 };
		BinaryTreeLongestConsecutiveSequence_298 traverseTree = new BinaryTreeLongestConsecutiveSequence_298();
		traverseTree.insert(data);
		System.out.println(traverseTree.longestNum());
	}

}
