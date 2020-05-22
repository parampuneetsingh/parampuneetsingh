//https://leetcode.com/problems/count-complete-tree-nodes/
//https://www.youtube.com/watch?v=8BPKe6N8xdk

public class CountCompleteTreeNodes_222 {

	static TreeNode root;

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

	public int countNodes(TreeNode root) {
		int leftCount = 0, rightCount = 0;
		TreeNode left = root, right = root;

		while (left != null) {
			leftCount++;
			left = left.left;
		}

		while (right != null) {
			rightCount++;
			right = right.right;
		}

		if (leftCount == rightCount) {
			return (int) Math.pow(2, leftCount) - 1;
		}

		return countNodes(root.left) + countNodes(root.right) + 1;
	}

	public static void main(String[] args) {
		CountCompleteTreeNodes_222 tree = new CountCompleteTreeNodes_222();
		int[] data = { 1, 2, 3, 4, 5, 6 };
		tree.insert(data);
		System.out.println(tree.countNodes(root));
	}

}
