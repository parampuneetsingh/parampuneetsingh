
public class LargestBSTSubTree_333 {

	TreeNode root;
	int max = Integer.MIN_VALUE;

	class TreeNode {
		TreeNode left;
		TreeNode right;
		int val;

		public TreeNode(int x) {
			val = x;
			left = null;
			right = null;
		}
	}

	public void insertRoot(int[] data) {
		root = insertData(root, data, 0, data.length);
	}

	// Took it from existing code
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

	public boolean isBST(TreeNode root, TreeNode left, TreeNode right) {
		if (root == null) {
			return true;
		}

		int val = root.val;

		if (left != null && left.val >= val) {
			return false;
		}

		if (right != null && right.val <= val) {
			return false;
		}

		if (!isBST(root.left, left, root)) {
			return false;
		}
		if (!isBST(root.right, root, right)) {
			return false;
		}

		return true;
	}

	public int largestTree() {
		return largestBST(root);
	}

	public int size(TreeNode root) {
		if (root == null) {
			return 0;
		}

		return 1 + size(root.left) + size(root.right);
	}

	public int largestBST(TreeNode root) {
		if (root == null) {
			return 0;
		}

		if (isBST(root, null, null)) {
			return size(root);
		}

		return Math.max(largestBST(root.left), largestBST(root.right));
	}

	public static void main(String[] args) {
		LargestBSTSubTree_333 tree = new LargestBSTSubTree_333();
		int data[] = { 10, 5, 15, 2, 6, 7, 20 };
		tree.insertRoot(data);
		System.out.println(tree.largestTree());
	}

}
