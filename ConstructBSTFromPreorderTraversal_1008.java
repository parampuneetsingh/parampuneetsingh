//https://leetcode.com/problems/construct-binary-search-tree-from-preorder-traversal/

public class ConstructBSTFromPreorderTraversal_1008 {

	TreeNode root;
	int idx = 0;

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

	public TreeNode constructBSTfromPreOrder(int[] preorder, int min, int max) {
		TreeNode root = new TreeNode(preorder[idx]);

		idx++;

		if (preorder.length - 1 >= idx && preorder[idx] < root.val) {
			root.left = constructBSTfromPreOrder(preorder, min, root.val);
		}

		if (preorder.length - 1 >= idx && preorder[idx] >= root.val && preorder[idx] < max) {
			root.right = constructBSTfromPreOrder(preorder, root.val, max);
		}

		return root;
	}

	public TreeNode bstFromPreorder(int[] preorder) {
		if (preorder.length == 0) {
			return null;
		}

		return constructBSTfromPreOrder(preorder, Integer.MIN_VALUE, Integer.MAX_VALUE);
	}

	public static void main(String[] args) {
		ConstructBSTFromPreorderTraversal_1008 tree = new ConstructBSTFromPreorderTraversal_1008();
		int[] preorder = { 8, 5, 1, 7, 10, 12 };
		tree.bstFromPreorder(preorder);
	}

}
