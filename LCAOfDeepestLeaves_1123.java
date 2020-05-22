public class LCAOfDeepestLeaves_1123 {

	TreeNode root;
	TreeNode res;
	int max = 0;

	static class TreeNode {
		TreeNode left;
		TreeNode right;
		int val;

		public TreeNode(int x) {
			val = x;
			left = null;
			right = null;
		}
	}

	public int findLCA(TreeNode root, int depth) {
		if (root == null) {
			return depth;
		}

		int left = findLCA(root.left, depth + 1);
		int right = findLCA(root.right, depth + 1);

		if (left == right && max <= left) {
			res = root;
			max = left;
		}

		return Math.max(left, right);
	}

	public TreeNode lcaLeaves() {
		return lcaDeepestLeaves(root);
	}
	
	public TreeNode lcaDeepestLeaves(TreeNode root) {

		if (root == null) {
			return null;
		}
		
		findLCA(root, 0);
		
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
		LCAOfDeepestLeaves_1123 tree = new LCAOfDeepestLeaves_1123();
		int data[] = { 1, 2, 3, 4, 5 };
		tree.insert(data);
		tree.lcaLeaves();
	}

}
