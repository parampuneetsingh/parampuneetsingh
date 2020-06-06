//https://www.lintcode.com/problem/inorder-successor-in-bst/
//https://www.youtube.com/watch?v=kdK_5rl1cVw

public class InorderSuccessorinBST_285 {

	static TreeNode root;

	static class TreeNode {
		int val;
		TreeNode left, right;

		public TreeNode(int item) {
			val = item;
			left = right = null;
		}
	}

	//Solution 2
	public TreeNode inorderSuccessor2(TreeNode root, TreeNode p) {

		if (root == null) {
			return null;
		}

		TreeNode succ = null;

		while (root != null && root.val != p.val) {
			if (root.val > p.val) {
				succ = root;
				root = root.left;
			} else {
				root = root.right;
			}
		}

		if (root == null)
			return null;

		if (root.right == null)
			return succ;

		root = root.right;

		while (root.left != null)
			root = root.left;

		return root;
	}

	//Solution 1 - Preferred
	public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {

		if (root == null || p == null) {
			return null;
		}

		if (p.right != null) {
			return findMin(p.right);
		}

		TreeNode succ = null;

		while (root != null) {
			if (root.val > p.val) {
				succ = root;
				root = root.left;
			} else if (root.val < p.val) {
				root = root.right;
			} else {
				break;
			}
		}

		return succ;
	}

	public TreeNode findMin(TreeNode p) {
		while (p.left != null) {
			p = p.left;
		}

		return p;
	}

	public static void main(String[] args) {
		InorderSuccessorinBST_285 tree = new InorderSuccessorinBST_285();
		TreeNode root = new TreeNode(5);
		root.left = new TreeNode(3);
		root.right = new TreeNode(6);
		root.left.left = new TreeNode(2);
		root.left.right = new TreeNode(4);
		root.left.left.left = new TreeNode(1);

		TreeNode find = new TreeNode(2);
		System.out.println(tree.inorderSuccessor(root, find));
	}

}
