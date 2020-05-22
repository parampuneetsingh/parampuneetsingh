import java.util.Stack;

//https://leetcode.com/problems/validate-binary-search-tree/
//https://www.youtube.com/watch?v=ofuXorE-JKE

public class ValidateBinarySearchTree_98 {

	TreeNode root;

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

	// BFS Approach
	// https://leetcode.com/problems/validate-binary-search-tree/solution/
	public boolean isValidBST(TreeNode root) {
		Stack<TreeNode> stack = new Stack<TreeNode>();
		double inorder = -Double.MAX_VALUE;

		while (!stack.isEmpty() || root != null) {
			while (root != null) {
				stack.push(root);
				root = root.left;
			}
			root = stack.pop();
			// If next element in inorder traversal
			// is smaller than the previous one
			// that's not BST.
			if (root.val <= inorder)
				return false;
			inorder = root.val;
			root = root.right;
		}
		return true;
	}

	// https://www.youtube.com/watch?v=MILxfAbIhrE

	public boolean validate(TreeNode root, TreeNode left, TreeNode right) {
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

		if (!validate(root.left, left, root))
			return false;
		if (!validate(root.right, root, right))
			return false;

		return true;
	}

	public boolean isValidBST() {
		return validateDFS(root, null, null);
		//return isValidBST(root);
	}

	// DFS Approach
	public boolean validateDFS(TreeNode root, TreeNode left, TreeNode right) {
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

		if (!validate(root.left, left, root))
			return false;
		if (!validate(root.right, root, right))
			return false;

		return true;
	}

	public boolean isValidBSTDFS(TreeNode root) {
		return validateDFS(root, null, null);
	}

	public static void main(String[] args) {
		ValidateBinarySearchTree_98 tree = new ValidateBinarySearchTree_98();
		// int data[] = { 10,5,15,2,4,6,20 };
		int data[] = { 10, 5, 15, 2, 6, 7, 20 };
		tree.insertRoot(data);
		//BFS
		boolean response = tree.isValidBST();
		//isValidBSTDFS
		//boolean response = tree.isValidBSTDFS();
		System.out.println(response);
	}
}
