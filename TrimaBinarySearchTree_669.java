//https://leetcode.com/problems/trim-a-binary-search-tree/

public class TrimaBinarySearchTree_669 {

	TreeNode root;

	class TreeNode {
		TreeNode left, right;
		int val;

		public TreeNode(int val) {
			this.val = val;
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

	public TreeNode trimBST(TreeNode root, int L, int R) {
		if (root == null) {
			return null;
		}

		if (root.val < L) {
			return trimBST(root.right, L, R);
		} else if (root.val > R) {
			return trimBST(root.left, L, R);
		}

		root.left = trimBST(root.left, L, R);
		root.right = trimBST(root.right, L, R);

		return root;
	}

	public void trim(int L, int R) {

	}

	public static void main(String[] args) {
		TrimaBinarySearchTree_669 tree = new TrimaBinarySearchTree_669();
		int[] data = { 1, 0, 2 };
		tree.insert(data);
		tree.trim(1, 2);
	}

}
