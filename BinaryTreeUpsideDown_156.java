//https://www.lintcode.com/problem/binary-tree-upside-down/

public class BinaryTreeUpsideDown_156 {

	TreeNode root;

	public TreeNode upsideDownBinaryTree(TreeNode root) {
		if (root == null || root.left == null && root.right == null)
			return root;

		TreeNode newRoot = upsideDownBinaryTree(root.left);

		root.left.left = root.right;
		root.left.right = root;

		root.left = null;
		root.right = null;

		return newRoot;
	}
	
	public TreeNode convertTree() {
		return upsideDownBinaryTree(root);
	}

	public static void main(String[] args) {
		BinaryTreeUpsideDown_156 tree = new BinaryTreeUpsideDown_156();
		tree.root = new TreeNode(1);
		tree.root.left = new TreeNode(2);
		tree.root.left.left = new TreeNode(4);
		tree.root.left.right = new TreeNode(5);
		tree.root.right = new TreeNode(3);
		tree.convertTree();
	}

}
