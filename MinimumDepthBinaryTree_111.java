public class MinimumDepthBinaryTree_111 {

	TreeNode root;
	int min = Integer.MAX_VALUE;

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

	public int minDepth() {
		int min = findMinDepthRecur(root);
		return min;
	}

	//Solution 1
	public int findMinDepthRecur(TreeNode root) {
		if (root == null) {
			return 0;
		}

		if ((root.left == null) && (root.right == null)) {
			return 1;
		}

		int min_depth = Integer.MAX_VALUE;
		if (root.left != null) {
			min_depth = Math.min(findMinDepthRecur(root.left), min_depth);
		}
		if (root.right != null) {
			min_depth = Math.min(findMinDepthRecur(root.right), min_depth);
		}

		return min_depth + 1;
	}

	public void findMin(TreeNode root, int depth) {
		if (root == null || depth > min) {
			return;
		}

		if (root.left == null && root.right == null) {
			min = Math.min(min, depth);
		}

		findMin(root.left, depth + 1);
		findMin(root.right, depth + 1);
	}

	//Solution 2
	public int minDepth(TreeNode root) {
		if (root == null) {
			return 0;
		}

		findMin(root, 1);

		return min;
	}

	public static void main(String[] args) {
		int[] data = { 3, 9, 20, 12, 34 };
		MinimumDepthBinaryTree_111 traverseTree = new MinimumDepthBinaryTree_111();
		traverseTree.insert(data);
		System.out.println(traverseTree.minDepth());
	}

}
