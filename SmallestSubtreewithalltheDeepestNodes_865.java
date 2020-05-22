//https://leetcode.com/problems/smallest-subtree-with-all-the-deepest-nodes

public class SmallestSubtreewithalltheDeepestNodes_865 {

	TreeNode root;

	class Node {
		TreeNode node;
		int height;

		public Node(TreeNode node, int height) {
			this.node = node;
			this.height = height;
		}
	}

	public TreeNode subtreeWithAllDeepest(TreeNode root) {
		if (root == null) {
			return null;
		}

		Node ans = postOrder(root, 0);
		return ans.node;
	}

	private Node postOrder(TreeNode root, int height) {
		if (root == null) {
			return null;
		}

		Node left = postOrder(root.left, height + 1);
		Node right = postOrder(root.right, height + 1);

		// Leaf node
		if (left == null && right == null) {
			return new Node(root, height);
		}

		// One sided, return non null
		if (left == null) {
			return right;
		}

		if (right == null) {
			return left;
		}

		// When both are not null, return Node with larger height
		return left.height == right.height ? new Node(root, left.height) : left.height > right.height ? left : right;
	}

	public void findDeepest() {
		subtreeWithAllDeepest(root);
	}

	public static void main(String[] args) {
		SmallestSubtreewithalltheDeepestNodes_865 tree = new SmallestSubtreewithalltheDeepestNodes_865();
		tree.root = new TreeNode(3);
		tree.root.left = new TreeNode(5);
		tree.root.right = new TreeNode(1);
		tree.root.left.left = new TreeNode(6);
		tree.root.left.right = new TreeNode(2);
		tree.root.left.right.left = new TreeNode(7);
		tree.root.left.right.right = new TreeNode(4);
		tree.root.right.left = new TreeNode(0);
		tree.root.right.right = new TreeNode(8);
		tree.findDeepest();
	}

}
