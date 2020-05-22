//https://github.com/openset/leetcode/tree/master/problems/split-bst

public class SplitBST_776 {

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

	public TreeNode[] splitBST(TreeNode root, int V) {
		if (root == null)
			return new TreeNode[] { null, null };
		if (root.val <= V) {
			TreeNode[] res = splitBST(root.right, V);
			root.right = res[0];
			res[0] = root;
			return res;
		} else {
			TreeNode[] res = splitBST(root.left, V);
			root.left = res[1];
			res[1] = root;
			return res;
		}
	}

	public void split(int v) {
		splitBST(root, v);
	}

	public static void main(String[] args) {
		int[] data = { 4, 2, 6, 1, 3, 5, 7 };
		SplitBST_776 traverseTree = new SplitBST_776();
		traverseTree.insert(data);
		traverseTree.split(2);
	}

}
