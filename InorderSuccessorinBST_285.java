//https://www.lintcode.com/problem/inorder-successor-in-bst/

public class InorderSuccessorinBST_285 {

	public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {

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

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
