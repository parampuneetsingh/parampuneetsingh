//https://leetcode.com/problems/cousins-in-binary-tree/

public class CousinsInBinaryTree_993 {

	static TreeNode root;

	static class TreeNode {
		int val;
		TreeNode left, right;

		public TreeNode(int item) {
			val = item;
			left = right = null;
		}
	}

	int x, y;
	Level xNode = new Level(x, y);
	Level yNode = new Level(x, y);

	class Level {
		int parent;
		int depth;

		public Level(int parent, int depth) {
			this.parent = parent;
			this.depth = depth;
		}
	}

	public boolean isCousins(TreeNode root, int x, int y) {

		this.x = x;
		this.y = y;

		checkCousin(root, -1, 1);

		return xNode.parent != yNode.parent && xNode.depth == yNode.depth;
	}

	private void checkCousin(TreeNode root, int parent, int depth) {
		if (root == null) {
			return;
		}

		if (root.val == x) {
			xNode.parent = parent;
			xNode.depth = depth;
		}

		if (root.val == y) {
			yNode.parent = parent;
			yNode.depth = depth;
		}

		checkCousin(root.left, root.val, depth + 1);
		checkCousin(root.right, root.val, depth + 1);
	}

	public static void main(String[] args) {
		CousinsInBinaryTree_993 tree = new CousinsInBinaryTree_993();
		root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);
		root.left.right = new TreeNode(4);
		root.right.right = new TreeNode(5);
		System.out.println(tree.isCousins(root, 5, 4));
	}

}
