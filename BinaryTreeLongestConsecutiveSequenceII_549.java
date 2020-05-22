//https://www.youtube.com/watch?v=id-iVCPy0eA
//https://www.lintcode.com/problem/binary-tree-longest-consecutive-sequence-ii

public class BinaryTreeLongestConsecutiveSequenceII_549 {

	static TreeNode root;
	int max = 0;

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

	public int[] maxNums(TreeNode root) {
		if (root == null) {
			return new int[] { 0, 0 };
		}

		int[] left = maxNums(root.left);
		int[] right = maxNums(root.right);

		if (root.left != null && (root.val + 1 == root.left.val)) {
			left[0]++;
		} else {
			left[0] = 1;
		}

		if (root.left != null && (root.val - 1 == root.left.val)) {
			left[1]++;
		} else {
			left[1] = 1;
		}

		if (root.right != null && (root.val + 1 == root.right.val)) {
			right[0]++;
		} else {
			right[0] = 1;
		}

		if (root.right != null && (root.val - 1 == root.right.val)) {
			right[1]++;
		} else {
			right[1] = 1;
		}

		max = Math.max(max, Math.max(left[1] + right[0] - 1, left[0] + right[1] - 1));
		return new int[] { Math.max(left[0], right[0]), Math.max(left[1], right[1]) };

	}

	public int longestConsecutive2(TreeNode root) {
		if (root == null) {
			return 0;
		}

		maxNums(root);

		return max;
	}

	public static void main(String[] args) {
		BinaryTreeLongestConsecutiveSequenceII_549 tree = new BinaryTreeLongestConsecutiveSequenceII_549();
		int[] data = { 1, 2, 0, 3 };
		tree.insert(data);
		System.out.println(tree.longestConsecutive2(root));
	}

}
