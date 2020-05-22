public class InvertBinaryTree_226 {

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

	public void invert() {
		invertTree(root);
	}
	
	public TreeNode invertTree(TreeNode root) {
		if (root == null) {
			return null;
		}
		TreeNode output = new TreeNode(root.val);
		return helper(root.left, root.right, output);
	}

	public TreeNode helper(TreeNode left, TreeNode right, TreeNode res) {
		if (left != null && right != null) {
			res.left = right;
			res.right = left;
		}
		if (right.left != null && right.right != null) {
			helper(right.left, right.right, res);
		}
		if (left.left != null && left.right != null) {
			helper(left.left, right.right, res);
		}
		return res;
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
	
	public static void main(String[] args) {
		InvertBinaryTree_226 tree = new InvertBinaryTree_226();
		int data[] = { 4, 2, 7, 1, 3, 6, 9 };
		tree.insert(data);
		tree.invert();
	}

}
